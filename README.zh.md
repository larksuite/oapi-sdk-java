[**README of Larksuite(Overseas)**](README.md) | 飞书


# 飞书开放接口SDK

## 概述

---

- 飞书开放平台，便于企业应用与飞书集成，让协同与管理更加高效，[概述](https://open.feishu.cn/document/uQjL04CN/ucDOz4yN4MjL3gzM)

- 飞书开发接口SDK，便捷调用服务端API与订阅服务端事件，例如：消息&群组、通讯录、日历、视频会议、云文档、 OKR等具体可以访问 [飞书开放平台文档](https://open.feishu.cn/document/) 看看【服务端
  API】。

## 问题反馈

--- 

- 如有任何SDK使用相关问题，请提交 [Github Issues](https://github.com/larksuite/oapi-sdk-java/issues), 我们会在收到 Issues 的第一时间处理，并尽快给您答复。


## 运行环境

---

- JDK 1.8及以上

## 安装方法

---

- 如果增加的 larksuite-oapi 依赖，无法发现获取，请在 pom.xml 的 \<project\> 里增加 \<repositories\>

```xml
<project>
    <repositories>
        <repository>
            <id>Central Repository</id>
            <url>https://repo1.maven.org/maven2/</url>
        </repository>
    </repositories>
    <dependencies>
        ...
    </dependencies>
</project>
```

- 最新的发布候选版本，提供更多[开放服务 API](/larksuite-oapi/src/main/java/com/larksuite/oapi/service) 以及 Bug 修复

```shell
<dependency>
    <groupId>com.larksuite.oapi</groupId>
    <artifactId>larksuite-oapi</artifactId>
    <version>1.0.18-rc3</version>
</dependency>
```

- 稳定版本

```shell
<dependency>
    <groupId>com.larksuite.oapi</groupId>
    <artifactId>larksuite-oapi</artifactId>
    <version>1.0.18-rc3</version>
</dependency>
```

## 术语解释

- 飞书（FeiShu）：Lark在中国的称呼，主要为国内的企业提供服务，拥有独立的[域名地址](https://www.feishu.cn)。
- 开发文档：开放平台的开放接口的参考，**开发者必看，可以使用搜索功能，高效的查询文档**。[更多介绍说明](https://open.feishu.cn/document/) 。
- 开发者后台：开发者开发应用的管理后台，[更多介绍说明](https://open.feishu.cn/app/) 。
- 企业自建应用：应用仅仅可在本企业内安装使用，[更多介绍说明](https://open.feishu.cn/document/uQjL04CN/ukzM04SOzQjL5MDN) 。
- 应用商店应用：应用会在 [应用目录](https://app.feishu.cn/?lang=zh-CN)
  展示，各个企业可以选择安装，[更多介绍说明](https://open.feishu.cn/document/uQjL04CN/ugTO5UjL4kTO14CO5kTN) 。

![App type](doc/app_type.zh.png)

## 快速使用

---

### 调用服务端API

- **必看** [如何调用服务端API](https://open.feishu.cn/document/ukTMukTMukTM/uYTM5UjL2ETO14iNxkTN/guide-to-use-server-api)
  ，了解调用服务端API的过程及注意事项。
    - 由于SDK已经封装了app_access_token、tenant_access_token的获取，所以在调业务API的时候，不需要去获取app_access_token、tenant_access_token。如果业务接口需要使用user_access_token，需要进行设置（Request.setUserAccessToken("UserAccessToken")），具体请看 README.zh.md -> 如何构建请求（Request）
- 更多使用示例，请看[ApiSample.java](sample/src/main/java/com/larksuite/oapi/sample/api/ApiSample.java)  

#### 使用`企业自建应用`访问 发送文本消息API 示例

- 有些老版接口，没有直接可以使用的SDK，可以使用`原生`模式。

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

    // 企业自建应用的配置
    // AppID、AppSecret: "开发者后台" -> "凭证与基础信息" -> 应用凭证（App ID、App Secret）
    // VerificationToken、EncryptKey："开发者后台" -> "事件订阅" -> 事件订阅（Verification Token、Encrypt Key）。
    public static final AppSettings appSettings = Config.createInternalAppSettings("AppID", "AppSecret", "VerificationToken", "EncryptKey");

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

        // 构建请求
        Request<Map<String, Object>, Map<String, Object>> request = Request.newRequest("message/v4/send",
                "POST", AccessTokenType.Tenant, message, new HashMap<>());

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

#### 使用`企业自建应用`访问 修改用户部分信息API 示例

- 该接口是新的接口（请看"README.zh.md -> 已生成SDK的业务服务"），可以直接使用SDK。

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
    // 企业自建应用的配置
    // AppID、AppSecret: "开发者后台" -> "凭证与基础信息" -> 应用凭证（App ID、App Secret）
    // VerificationToken、EncryptKey："开发者后台" -> "事件订阅" -> 事件订阅（Verification Token、Encrypt Key）。
    public static final AppSettings appSettings = Config.createInternalAppSettings("AppID", "AppSecret", "VerificationToken", "EncryptKey");

    // 当前访问的是飞书，使用默认存储，更多可选配置，请看：README.zh.md->高级使用->如何构建整体配置（Config）。
    public static final Config config = new Config(Domain.FeiShu, appSettings, new DefaultStore());

    public static void main(String[] args) throws Exception {
        ContactService contactService = new ContactService(config);
        // 用户要更新的信息
        User user = new User();
        user.setName("rename");
        // 封装请求 & 执行请求 & 返回请求结果
        Response<UserPatchResult> response = contactService.getUsers().patch(user)
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

#### [使用`应用商店应用`调用 服务端API 示例](doc/ISV.APP.README.zh.md)

### 订阅服务端事件

- **必看** [订阅事件概述](https://open.feishu.cn/document/ukTMukTMukTM/uUTNz4SN1MjL1UzM) ，了解订阅事件的过程及注意事项。
- 更多使用示例，请看[EventController.java](spring-boot-examples/src/main/java/com/larksuite/oapi/example/EventController.java)
  （含：结合spring-boot的使用）

#### 使用`企业自建应用` 订阅 [首次启用应用事件](https://open.feishu.cn/document/ukTMukTMukTM/uQTNxYjL0UTM24CN1EjN) 示例

- 有些老的事件，没有直接可以使用的SDK，可以使用`原生`模式

```java
package com.larksuite.oapi.example;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.event.DefaultHandler;
import com.larksuite.oapi.core.event.Event;
import com.larksuite.oapi.core.event.EventServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.servlet.annotation.WebServlet;
import java.util.Map;

// "开发者后台" -> "事件订阅" ，设置请求网址 URL：https://domain/webhook/event
// 继承EventServlet
@WebServlet("/webhook/event")
public class EventController extends EventServlet {

    private static final Logger log = LoggerFactory.getLogger(EventController.class);

    // 通过InitConfig.java提供Config实例，依赖注入Config实例
    public EventController(Config config) {
        super(config);
    }

    @PostConstruct
    public void init() {
        // 设置首次启用应用事件处理者
        Event.setTypeHandler(this.getConfig(), "app_open", new DefaultHandler() {
            @Override
            public void Handle(Context context, Map<String, Object> event) throws Exception {
                // 打印请求的Request ID
                log.info("requestId:{}", context.getRequestID());
                // 打印事件
                log.info("event:{}", event);
            }
        });
    }
}
```

#### 使用`企业自建应用`订阅 [用户数据变更事件](https://open.feishu.cn/document/ukTMukTMukTM/uITNxYjLyUTM24iM1EjN#70402aa) 示例

- 该接口是新的事件（请看"README.zh.md -> 已生成SDK的业务服务"），可以直接使用SDK

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

    // 通过InitConfig.java提供Config实例，依赖注入Config实例
    public EventController(Config config) {
        super(config);
    }

    @PostConstruct
    public void init() {
        ContactService contactService = new ContactService(this.getConfig());
        // 设置用户数据变更事件处理者
        contactService.setUserUpdatedEventHandler(new ContactService.UserUpdatedEventHandler() {
            @Override
            public void Handle(Context context, UserUpdatedEvent event) throws Exception {
                // 打印请求的Request ID
                log.info("requestId:{}", context.getRequestID());
                // 打印事件
                log.info("event:{}", event);
            }
        });
    }
}

```

### 处理消息卡片回调

- **必看** [消息卡片开发流程](https://open.feishu.cn/document/ukTMukTMukTM/uAzMxEjLwMTMx4CMzETM) ，了解订阅事件的过程及注意事项
- 更多使用示例，请看：请看[CardController.java](spring-boot-examples/src/main/java/com/larksuite/oapi/example/CardController.java)
  （含：结合spring-boot的使用）

#### 使用`企业自建应用`处理消息卡片回调示例

```java
package com.larksuite.oapi.example;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.card.Card;
import com.larksuite.oapi.core.card.CardServlet;
import com.larksuite.oapi.core.card.IHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.servlet.annotation.WebServlet;

// 设置 "开发者后台" -> "应用功能" -> "机器人" 消息卡片请求网址：https://domain/webhook/card
// 继承CardServlet
@WebServlet("/webhook/card")
public class CardController extends CardServlet {

    private static final Logger log = LoggerFactory.getLogger(CardController.class);

    // 通过InitConfig.java提供Config实例，依赖注入Config实例
    public CardController(Config config) {
        super(config);
    }

    @PostConstruct
    public void init() {
        // 设置消息卡片的处理者
        Card.setHandler(this.getConfig(), new IHandler() {

            // 返回值：可以为null、新的消息卡片的Json字符串
            @Override
            public Object handle(Context context, com.larksuite.oapi.core.card.mode.Card card) throws Exception {
                // 打印消息卡片
                log.info("card:{}", card);
                log.info("card.getAction:{}", card.getAction());
                return "{\"config\":{\"wide_screen_mode\":true},\"i18n_elements\":{\"zh_cn\":[{\"tag\":\"div\",\"text\":{\"tag\":\"lark_md\",\"content\":\"[飞书](https://www.feishu.cn)整合即时沟通、日历、音视频会议、云文档、云盘、工作台等功能于一体，成就组织和个人，更高效、更愉悦。\"}}]}}";
            }
        });
    }
}

```    

## 高级使用

---

### 如何构建应用配置（AppSettings）

```java
package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.AppSettings;
import com.larksuite.oapi.core.Config;

public class Sample {

    // 防止应用信息泄漏，配置环境变量中，变量（4个）说明：
    // APP_ID："开发者后台" -> "凭证与基础信息" -> 应用凭证 App ID
    // APP_SECRET："开发者后台" -> "凭证与基础信息" -> 应用凭证 App Secret
    // VERIFICATION_TOKEN："开发者后台" -> "事件订阅" -> 事件订阅 Verification Token
    // ENCRYPT_KEY："开发者后台" -> "事件订阅" -> 事件订阅 Encrypt Key
    // 企业自建应用的配置，通过环境变量获取应用配置
    AppSettings appSettings = Config.getInternalAppSettingsByEnv();
    // 应用商店应用的配置，通过环境变量获取应用配置
    AppSettings appSettings = Config.getIsvAppSettingsByEnv();

    // 参数说明：
    // AppID、AppSecret: "开发者后台" -> "凭证与基础信息" -> 应用凭证（App ID、App Secret）
    // VerificationToken、EncryptKey："开发者后台" -> "事件订阅" -> 事件订阅（Verification Token、Encrypt Key）
    // 企业自建应用的配置
    AppSettings appSettings = Config.createInternalAppSettings("AppID", "AppSecret", "VerificationToken", "EncryptKey");
    // 应用商店应用的配置
    AppSettings appSettings = Config.createIsvAppSettings("AppID", "AppSecret", "VerificationToken", "EncryptKey");
}

```

### 如何构建整体配置（Config）

- 访问 飞书、LarkSuite或者其他
- 应用的配置
- 存储接口（Store）的实现，用于保存访问凭证（app/tenant_access_token）、临时凭证(app_ticket）
    - 推荐使用Redis实现，请看示例代码：[RedisStore.java](sample/src/main/java/com/larksuite/oapi/sample/config/RedisStore.java)
        - 减少获取 访问凭证 的次数，防止调用访问凭证 接口被限频。
        - 应用商品应用，接受开放平台下发的app_ticket，会保存到存储中，所以存储接口（Store）的实现的实现需要支持分布式存储。

```java
package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.AppSettings;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Domain;
import com.larksuite.oapi.core.IStore;

public class Sample {
    AppSettings appSettings = Config.getIsvAppSettingsByEnv();

    // 方法一，推荐使用Redis实现存储接口（Store），减少访问获取AccessToken接口的次数
    // 参数说明：
    // domain：URL域名枚举，值范围：Domain.FeiShu / Domain.LarkSuite
    // appSettings：应用配置
    // store: [存储接口](larksuite-oapi/src/main/java/com/larksuite/oapi/core)，用来存储 app_ticket/access_token
    Config config = new Config(Domain domain, AppSettings appSettings, IStore store);


    // 方法二，推荐使用Redis实现存储接口（Store），减少访问获取AccessToken接口的次数
    // 参数说明：
    // domain：URL域名地址，例如："https://open.feishu.cn"
    // appSettings：应用配置
    // store: [存储接口](larksuite-oapi/src/main/java/com/larksuite/oapi/core)，用来存储 app_ticket/access_token
    Config config = new Config(String domain, AppSettings appSettings, IStore store);
}
```

### 如何构建请求（Request）

- 有些老版接口，没有直接可以使用的SDK，可以使用原生模式，这时需要构建请求。
- 更多示例，请看：[ApiSample.java](sample/src/main/java/com/larksuite/oapi/sample/api/ApiSample.java)（含：文件的上传与下载）

```java
package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.api.AccessTokenType;
import com.larksuite.oapi.core.api.request.Request;
import com.larksuite.oapi.core.api.request.RequestOptFn;

public class Sample {
    
    // 参数说明：
    // httpPath：API路径（`open-apis/`之后的路径），例如：https://domain/open-apis/contact/v3/users/:user_id，则 httpPath："contact/v3/users/:user_id"
    // httpMethod: GET/POST/PUT/BATCH/DELETE
    // accessTokenType：API使用哪种访问凭证枚举，取值范围：AccessTokenType.App/AccessTokenType.Tenant/AccessTokenType.User，例如：AccessTokenType.Tenant
    // input：请求体（可能是 new FormData()（文件上传））,如果不需要请求体（例如一些GET请求），则传：null
    // output：响应体（output := response["data"])
    // requestOptFns：扩展函数，一些不常用的参数封装，如下：
    // Request.setPathParams(map[string]object{"user_id": 4})：设置URL Path参数（有:前缀）值，当httpPath="contact/v3/users/:user_id"时，请求的URL="https://{domain}/open-apis/contact/v3/users/4"
    // Request.setQueryParams(map[string]object{"age":4,"types":[1,2]})：设置 URL query，会在url追加?age=4&types=1&types=2
    // Request.setResponseStream()，设置响应的是否是流，例如下载文件，这时：output的类型需要实现 java.io.OutputStream 接口
    // Request.setNotDataField(),设置响应的是否 没有`data`字段，业务接口都是有`data`字段，所以不需要设置
    // Request.setTenantKey("TenantKey")，以`应用商店应用`身份，表示使用`tenant_access_token`访问API，需要设置
    // Request.setUserAccessToken("UserAccessToken")，表示使用`user_access_token`访问API，需要设置
    // Request.setTimeout(int time, TimeUnit timeUnit)，设置请求超时的时间
    Request<I, O> req = Request.newRequest(String httpPath, String httpMethod, AccessTokenType accessTokenType,
            I input, O output, RequestOptFn...requestOptFns)
}
```

### Context的常用方法

```java
package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Context;

public class Sample {
    // 在事件订阅与消息卡片回调的处理者中，可以从core.Context中获取 Config
    Config config = Config.ByCtx(Context context);
}

```

### 如何发送请求

- 更多示例，请看：[ApiSample.java](sample/src/main/java/com/larksuite/oapi/sample/api/ApiSample.java)（含：文件的上传与下载）
- 由于SDK已经封装了app_access_token、tenant_access_token的获取，所以在调业务API的时候，不需要去获取app_access_token、tenant_access_token。如果业务接口需要使用user_access_token，需要进行设置（Request.setUserAccessToken("UserAccessToken")），具体请看 README.zh.md -> 如何构建请求（Request）

```java
package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.api.Api;
import com.larksuite.oapi.core.api.response.Response;

public class Sample {
    // 参数说明：
    // req：请求（Request）
    // 返回值说明：
    // Response<O>：请求的结果（= http response body）
    // Exception：发送请求出现的异常
    Response<O> response = Api.send(Config config, Request <I,O> request) throws Exception;
}
```

### 下载文件工具

- 通过网络请求下载文件
- 更多使用示例，请看：[sample/tools/FileDownloadSample.java](sample/src/main/java/com/larksuite/oapi/sample/tools/FileDownloadSample.java)

```java
import com.larksuite.oapi.core.api.tools.Files;

/**
* @param url File net url
* @return InputStream must close!!!!
* @throws IOException IO exception
*/
public static InputStream DownloadFileToStream(String url) throws IOException {}

/**
* @param url File net url
* @return File bytes
* @throws IOException IO exception
*/
public static byte[] DownloadFile(String url) throws IOException {
}

```

## 已生成SDK的业务服务

---

|业务域|版本|路径|代码示例|
|---|---|---|----|
|[用户身份验证](https://open.feishu.cn/document/ukTMukTMukTM/uETOwYjLxkDM24SM5AjN)|v1|[service/authen](larksuite-oapi/src/main/java/com/larksuite/oapi/service/authen)|[sample/api/AuthenSample.java](sample/src/main/java/com/larksuite/oapi/sample/api/AuthenSample.java)|
|[通讯录](https://open.feishu.cn/document/ukTMukTMukTM/uETNz4SM1MjLxUzM/v3/introduction)|v3|[service/contact](larksuite-oapi/src/main/java/com/larksuite/oapi/service/contact)|[sample/api/ContactSample.java](sample/src/main/java/com/larksuite/oapi/sample/api/ContactSample.java)|
|[日历](https://open.feishu.cn/document/ukTMukTMukTM/uETM3YjLxEzN24SMxcjN)|v4|[service/calendar](larksuite-oapi/src/main/java/com/larksuite/oapi/service/calendar)|[sample/api/CalendarSample.java](sample/src/main/java/com/larksuite/oapi/sample/api/CalendarSample.java)|
|[消息与群组](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/im-v1/message/create)|v1|[service/im](larksuite-oapi/src/main/java/com/larksuite/oapi/service/im)||

## License

---

- Apache-2.0

## 联系我们

---

- 飞书：[服务端SDK](https://open.feishu.cn/document/ukTMukTMukTM/uETO1YjLxkTN24SM5UjN) 页面右上角【这篇文档是否对你有帮助？】提交反馈


