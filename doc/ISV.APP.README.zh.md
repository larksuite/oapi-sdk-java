# 使用应用商店应用调用服务端API

---

- 如何获取app_access_token，请看：[获取app_access_token](https://open.feishu.cn/document/ukTMukTMukTM/uEjNz4SM2MjLxYzM) （应用商店应用）
    - 与企业自建应用相比，应用商店应用的获取app_access_token的流程复杂一些。
        - 需要开放平台下发的app_ticket，通过订阅事件接收。SDK已经封装了app_ticket事件的处理，只需要启动事件订阅服务。
        - 使用SDK调用服务端API时，如果当前还没有收到开发平台下发的app_ticket，会报错且向开放平台申请下发app_ticket，可以尽快的收到开发平台下发的app_ticket，保证再次调用服务端API的正常。
        - 使用SDK调用服务端API时，需要使用tenant_access_token访问凭证时，需要 tenant_key ，来表示当前是哪个租户使用这个应用调用服务端API。
            - tenant_key，租户安装启用了这个应用，开放平台发送的服务端事件，事件内容中都含有tenant_key。

### 使用`应用商店应用`访问 [发送文本消息API](https://open.feishu.cn/document/ukTMukTMukTM/uUjNz4SN2MjL1YzM) 示例

- 第一步：启动启动事件订阅服务，用于接收`app_ticket`。

```java
package com.larksuite.oapi.example;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.event.EventServlet;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.service.contact.v3.ContactService;
import com.larksuite.oapi.service.contact.v3.model.UserUpdatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.servlet.annotation.WebServlet;

// "开发者后台" -> "事件订阅" 请求网址 URL：https://domain/webhook/event
// 继承EventServlet
@WebServlet("/webhook/event")
public class EventController extends EventServlet {

    private static final Logger log = LoggerFactory.getLogger(EventController.class);

    // 通过InitConfig提供Config实例，依赖注入Config实例，使用"应用商店应用"的配置
    public EventController(Config config) {
        super(config);
    }
}
```

- 第二步：调用服务端接口，有些老版接口，没有直接可以使用的SDK，可以使用`原生`模式。

```java
package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.AppSettings;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.DefaultStore;
import com.larksuite.oapi.core.Domain;
import com.larksuite.oapi.core.api.AccessTokenType;
import com.larksuite.oapi.core.api.Api;
import com.larksuite.oapi.core.api.request.Request;
import com.larksuite.oapi.core.api.response.Response;
import com.larksuite.oapi.core.utils.Jsons;

import java.util.HashMap;
import java.util.Map;

public class Sample {

    // 应用商店应用的配置
    // AppID、AppSecret: "开发者后台" -> "凭证与基础信息" -> 应用凭证（App ID、App Secret）
    // VerificationToken、EncryptKey："开发者后台" -> "事件订阅" -> 事件订阅（Verification Token、Encrypt Key）。
    public static final AppSettings appSettings = Config.createIsvAppSettings("AppID", "AppSecret", "VerificationToken", "EncryptKey");

    // 当前访问的是飞书，使用默认存储，更多可选配置，请看：README.zh.md->高级使用->如何构建整体配置（Config）。
    public static final Config config = new Config(Domain.FeiShu, appSettings, new DefaultStore());

    public static void main(String[] args) throws Exception {
        // 发送消息的内容
        Map<String, Object> message = new HashMap<>();
        message.put("user_id", "77bbc392");
        message.put("msg_type", "text");
        Map<String, Object> content = new HashMap<>();
        content.put("text", "java test");
        message.put("content", content);

        // 构建请求&&设置企业标识（tenant key）
        Request<Map<String, Object>, Map<String, Object>> request = Request.newRequest("message/v4/send",
                "POST", AccessTokenType.Tenant, message, new HashMap<>(), Request.setTenantKey("Tenant Key"));

        // 发送请求，拿到结果 = http response body json
        Response<Map<String, Object>> response = Api.send(config, request);
        // 打印请求的RequestID
        System.out.println(response.getRequestID());
        // 打印请求的响应状态吗
        System.out.println(response.getHTTPStatusCode());
        // 打印请求的结果
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }
}
```

## 使用`应用商店应用`访问 [修改用户部分信息API](https://open.feishu.cn/document/contact/v3/user/patch) 示例

- 第一步：略，同上

- 第二步：调用服务端接口，该接口是新的接口，可以直接使用SDK。

```java
package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.AppSettings;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.DefaultStore;
import com.larksuite.oapi.core.Domain;
import com.larksuite.oapi.core.api.response.Response;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.service.contact.v3.ContactService;
import com.larksuite.oapi.service.contact.v3.model.User;
import com.larksuite.oapi.service.contact.v3.model.UserPatchResult;

public class ContactSample {
    // 应用商店应用的配置
    // AppID、AppSecret: "开发者后台" -> "凭证与基础信息" -> 应用凭证（App ID、App Secret）
    // VerificationToken、EncryptKey："开发者后台" -> "事件订阅" -> 事件订阅（Verification Token、Encrypt Key）。
    public static final AppSettings appSettings = Config.createIsvAppSettings("AppID", "AppSecret", "VerificationToken", "EncryptKey");

    // 当前访问的是飞书，使用默认存储，更多可选配置，请看：README.zh.md->高级使用->如何构建整体配置（Config）。
    public static final Config config = new Config(Domain.FeiShu, appSettings, new DefaultStore());

    public static void main(String[] args) throws Exception {
        ContactService contactService = new ContactService(config);
        // 用户要更新的信息
        User user = new User();
        user.setName("rename");
        // 封装请求 & 设置企业标识（Tenant Key) & 执行请求 & 返回请求结果
        Response<UserPatchResult> response = contactService.getUsers().patch(user, Request.setTenantKey("Tenant Key"))
                .setUserId("77bbc392").setUserIdType("user_id").execute();
        // 打印请求的RequestID
        System.out.println(response.getRequestID());
        // 打印请求的响应状态吗
        System.out.println(response.getHTTPStatusCode());
        // 打印请求的结果
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }
}
```
