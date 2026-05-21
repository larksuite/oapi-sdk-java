# 飞书开放接口SDK/Feishu OpenPlatform Server SDK

旨在让开发者便捷的调用飞书开放API、处理订阅的事件、处理服务端推送的卡片行为等。

Feishu Open Platform offers a series of server-side atomic APIs to achieve diverse functionalities. However, actual coding requires additional work, such as obtaining and maintaining access tokens, encrypting and decrypting data, and verifying request signatures. Furthermore, the lack of semantic descriptions for function calls and type system support can increase coding burdens.

To address these issues, Feishu Open Platform has developed the Open Interface SDK, which incorporates all lengthy logic processes, provides a comprehensive type system, and offers a semantic programming interface to enhance the coding experience.

## 介绍文档 Introduction Documents

- [开发前准备（安装） / Preparations before development(Install SDK)](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/server-side-sdk/java-sdk-guide/preparations)
- [调用服务端 API / Calling Server-side APIs](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/server-side-sdk/java-sdk-guide/invoke-server-api)
- [处理事件订阅 / Handle Events](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/server-side-sdk/java-sdk-guide/handle-events)
- [处理卡片回调 / Handle Card Callbacks](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/server-side-sdk/java-sdk-guide/handle-callback)
- [常见问题 / SDK FAQs](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/server-side-sdk/faq)
- [Channel 与 Agent 接入 / Channel and Agent Integration](CHANNEL.md) / [English](CHANNEL.en.md)

## Channel and Agent Integration

`LarkChannel` is a high-level conversation facade for Agent and bot scenarios. It brings event intake, message normalization, safety policy gates, replies, streaming output, media upload/download, card actions and reactions into one Java entry point.

Use Channel when you are building a conversational bot, AI Agent, support assistant, knowledge-base assistant or any service that needs to receive Feishu/Lark messages and reply in the same chat context. For small one-off API calls, use the regular `Client`; for long-running chat workflows, Channel handles the surrounding plumbing.

Key entry points:
- Create a channel with `LarkChannelFactory.createLarkChannel(...)`.
- Call `connect()` before processing inbound events; it returns `CompletableFuture<BotIdentity>`.
- Listen with `channel.on("message", handler)`, `channel.on("cardAction", handler)`, `channel.on("reject", handler)` and related event names.
- Reply with `send(...)`, stream incremental output with `stream(...)`, and use `downloadResource(...)` for image/file content.
- Configure `policy(...)` for group allowlists, direct-message behavior, mention requirements and mention-all handling.
- Use `includeRawEvent(true)` only when handlers need the original event body.

See [CHANNEL.en.md](CHANNEL.en.md) for the English guide and [CHANNEL.md](CHANNEL.md) for the Chinese guide.

## App Registration 

The SDK provides `RegisterApp.register(...)` for one-click app creation based on OAuth 2.0 Device Authorization Grant (RFC 8628).
It returns a verification URL that users can open in Feishu/Lark to authorize and automatically register an app, then obtain the app credentials without manually creating one in the developer console.

```java
import com.lark.oapi.scene.registration.QRCodeInfo;
import com.lark.oapi.scene.registration.RegisterApp;
import com.lark.oapi.scene.registration.RegisterAppException;
import com.lark.oapi.scene.registration.RegisterAppOptions;
import com.lark.oapi.scene.registration.RegisterAppResult;

public class Sample {

    public static void main(String[] args) {
        try {
            RegisterAppResult result = RegisterApp.register(
                    RegisterAppOptions.newBuilder()
                            .source("test")
                            .onQRCode(info -> {
                                System.out.println("Please scan the QR code:");
                                System.out.println(info.getUrl());
                                System.out.println(String.format("Expires in %s seconds", info.getExpireIn()));
                            })
                            .onStatusChange(info -> System.out.println(
                                    "Status: " + info.getStatus()
                                            + (info.getInterval() > 0
                                            ? String.format(" (interval: %ss)", info.getInterval())
                                            : "")
                            ))
                            .build()
            );

            System.out.println("App ID: " + result.getClientId());
            System.out.println("App Secret: " + result.getClientSecret());
            System.out.println("User Info: " + result.getUserInfo());
        } catch (RegisterAppException e) {
            System.err.println("Failed: " + e.getCode() + " " + e.getDescription());
        }
    }
}
```

Real runnable demo:
- [RegisterAppRealDemo](larksuite-oapi/src/test/java/com/lark/oapi/scene/registration/RegisterAppRealDemo.java)

### `RegisterAppOptions` parameters

| Parameter | Description | Type | Required | Default |
| ---- | ---- | ---- | ---- | ---- |
| `source` | Source identifier, appended to the QR code URL `source` parameter as `java-sdk/{source}` | `String` | No | - |
| `domain` | Custom Feishu accounts base URL | `String` | No | `https://accounts.feishu.cn` |
| `larkDomain` | Custom Lark accounts base URL, used when tenant brand is detected as Lark | `String` | No | `https://accounts.larksuite.com` |
| `onQRCode` | Callback when the verification URL is ready. Receives `QRCodeInfo` with `url` and `expireIn` | `Consumer<QRCodeInfo>` | Yes | - |
| `onStatusChange` | Callback on polling status changes. Receives `StatusChangeInfo` | `Consumer<StatusChangeInfo>` | No | - |

### Return value

| Field | Type | Description |
| ---- | ---- | ---- |
| `clientId` | `String` | App ID |
| `clientSecret` | `String` | App Secret |
| `userInfo` | `UserInfo` | Scanning user info |
| `userInfo.openId` | `String` | User's `open_id` |
| `userInfo.tenantBrand` | `String` | `"feishu"` or `"lark"` |

### Status callback

| Status | Description |
| ---- | ---- |
| `polling` | Authorization is still pending |
| `slow_down` | The server asks the client to slow down polling; `interval` contains the new interval in seconds |
| `domain_switched` | The SDK detected a Lark tenant and switched polling to `larkDomain` |

### Error handling

`RegisterAppException` contains `code` and `description` fields:

| code | Description |
| ---- | ---- |
| `access_denied` | User denied the authorization |
| `expired_token` | QR code expired or polling timed out |
| `abort` | Registration was canceled via thread interruption |
| `invalid_response` | The service returned an unexpected response |

## 扩展示例
我们还基于 SDK 封装了常用的 API 组合调用及业务场景示例，如：
* 消息
    * [发送文件消息](https://github.com/larksuite/oapi-sdk-java-demo/blob/main/src/main/java/com/larksuite/oapi/composite_api/im/Im.java)
    * [发送图片消息](https://github.com/larksuite/oapi-sdk-java-demo/blob/main/src/main/java/com/larksuite/oapi/composite_api/im/Im.java)
* 通讯录
    * [获取部门下所有用户列表](https://github.com/larksuite/oapi-sdk-java-demo/blob/main/src/main/java/com/larksuite/oapi/composite_api/contact/Contact.java)
* 多维表格
    * [创建多维表格同时添加数据表](https://github.com/larksuite/oapi-sdk-java-demo/blob/main/src/main/java/com/larksuite/oapi/composite_api/base/Base.java)
* 电子表格
    * [复制粘贴某个范围的单元格数据](https://github.com/larksuite/oapi-sdk-java-demo/blob/main/src/main/java/com/larksuite/oapi/composite_api/sheets/Sheets.java)
    * [下载指定范围单元格的所有素材列表](https://github.com/larksuite/oapi-sdk-java-demo/blob/main/src/main/java/com/larksuite/oapi/composite_api/sheets/Sheets.java)
* 教程
    * [机器人自动拉群报警](https://github.com/larksuite/oapi-sdk-java-demo/tree/main/src/main/java/com/larksuite/oapi/quick_start/robot) ([开发教程](https://open.feishu.cn/document/home/message-development-tutorial/introduction))

更多示例可参考：https://github.com/larksuite/oapi-sdk-java-demo

## 加入交流互助群
[单击加入交流互助群](https://applink.feishu.cn/client/chat/chatter/add_by_link?link_token=dc7p3b08-78ac-451b-855b-daf8156a4a11)

## License

使用 MIT
