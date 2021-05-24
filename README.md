[**飞书，点这里**](README.zh.md) | Larksuite(Overseas)

- 如果使用的是飞书，请看 [**飞书，点这里**](README.zh.md) ，飞书与Larksuite使用的域名不一样，引用的文档地址也是不同的。（If you are using FeiShu, please see [**飞书，点这里**](README.zh.md) , Feishu and larksuite use different domain names and reference different document addresses.)

# LarkSuite open api SDK

## Overview

---

- Larksuite open platform facilitates the integration of enterprise applications and larksuite, making collaboration and
  management more efficient.

- Larksuite development interface SDK, convenient call server API and subscribe server events, such as: Message & group,
  address book, calendar, docs and others can
  visit [larksuite open platform document](https://open.larksuite.cn/document/) ,Take a look at [REFERENCE].

## Problem feedback

---

- If you encounter any problems during usage, please let us know by submitting  [Github Issues](https://github.com/larksuite/oapi-sdk-java/issues). We will deal with these Issues and get back to you as soon as possible.


## Run environment

---

- JDK 1.8+

## Install

---

- If the larksuite-oapi dependency cannot be found and obtained, please add \<repositories\> in \<project\> of pom.xml

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

- The latest release candidate provides more open services API and bug repair.

```shell
<dependency>
    <groupId>com.larksuite.oapi</groupId>
    <artifactId>larksuite-oapi</artifactId>
    <version>1.0.17-rc2</version>
</dependency>
```

- Stable version

```shell
<dependency>
    <groupId>com.larksuite.oapi</groupId>
    <artifactId>larksuite-oapi</artifactId>
    <version>1.0.8</version>
</dependency>
```

## Explanation of terms

- Larksuite: the overseas name of lark, which mainly provides services for overseas enterprises and has an
  independent [domain name address](https://www.larksuite.com/) .
- Development documents: reference to the open interface of the open platform **developers must see, and can use search
  to query documents efficiently** . [more information](https://open.feishu.cn/document/) .
- Developer background: the management background for developers to develop
  applications, [more introduction](https://open.larksuite.cn/app/) .
- Cutome APP: the application can only be installed and used in the
  enterprise，[more introduction](https://open.larksuite.com/document/ukzMxEjL5MTMx4SOzETM/uEjNwYjLxYDM24SM2AjN) .
- Marketplace App：The app will be displayed in [App Directory](https://app.larksuite.com/) Display, each enterprise can
  choose to install.

![App type](doc/app_type.en.png)

## Quick use

---

### Call API

#### Example of using "Custom App" to access [send text message](https://open.larksuite.com/document/uMzMyEjLzMjMx4yMzITM/ugDN0EjL4QDNx4CO0QTM) API

- Since the SDK has encapsulated the app_access_token、tenant_access_token So when calling the business API, you don't need to get the app_access_token、tenant_access_token. If the business interface needs to use user_access_token, which needs to be set（Request.setUserAccessToken("UserAccessToken")), Please refer to README.md -> How to build a request(Request)
- For more use examples, please refer to [ApiSample.java](sample/src/main/java/com/larksuite/oapi/sample/api/ApiSample.java)
- Some of the old API do not have a direct SDK to use. They can use the `native` mode.

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

    // Configuration of "Custom App", parameter description:
    // AppID、AppSecret: "Developer Console" -> "Credentials"（App ID、App Secret）
    // VerificationToken、EncryptKey："Developer Console" -> "Event Subscriptions"（Verification Token、Encrypt Key）
    public static final AppSettings appSettings = Config.createInternalAppSettings("AppID", "AppSecret", "VerificationToken", "EncryptKey");

    // Currently, you are visiting larksuite, More optional configurations are as follows: config.NewConfig()
    public static final Config config = new Config(Domain.LarkSuite, appSettings, new DefaultStore());

    public static void main(String[] args) throws Exception {
        // 发送消息的内容
        Map<String, Object> message = new HashMap<>();
        message.put("user_id", "77bbc392");
        message.put("msg_type", "text");
        Map<String, Object> content = new HashMap<>();
        content.put("text", "java test");
        message.put("content", content);

        // Build request
        Request<Map<String, Object>, Map<String, Object>> request = Request.newRequest("message/v4/send",
                "POST", AccessTokenType.Tenant, message, new HashMap<>());

        // Send request && response of the request = http response body json
        Response<Map<String, Object>> response = Api.send(config, request);
        // Print the requestId of the request
        System.out.println(response.getRequestID());
        // Print the response status of the request
        System.out.println(response.getHTTPStatusCode());
        // Print the result of the request
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }
}
```

### Subscribe to events

- [Subscribe to events](https://open.larksuite.com/document/uMzMyEjLzMjMx4yMzITM/uETM4QjLxEDO04SMxgDN) , to understand
  the process and precautions of subscribing to events.
- For more use examples, please refer to [EventController.java](spring-boot-examples/src/main/java/com/larksuite/oapi/example/EventController.java)（including: use in combination with spring-boot）

#### Example of using "Custom App" to subscribe [App First Enabled](https://open.larksuite.com/document/uMzMyEjLzMjMx4yMzITM/uYjMyYjL2IjM24iNyIjN) event.

- For some old events, there is no SDK that can be used directly. You can use the `native` mode

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

// "Developer Console" -> "Event Subscriptions", setting Request URL: https://domain/webhook/event
// Inherit EventServlet
@WebServlet("/webhook/event")
public class EventController extends EventServlet {

    private static final Logger log = LoggerFactory.getLogger(EventController.class);

    // Provide the config instance through InitConfig.java and inject the config instance through dependency
    public EventController(Config config) {
        super(config);
    }

    @PostConstruct
    public void init() {
        // Set the application event handler to "App First Enabled"
        Event.setTypeHandler(this.getConfig(), "app_open", new DefaultHandler() {
            @Override
            public void Handle(Context context, Map<String, Object> event) throws Exception {
                // Print the request ID of the request
                log.info("requestId:{}", context.getRequestID());
                // Print event
                log.info("event:{}", event);
            }
        });
    }
}
```

### Processing message card callbacks

- [Message Card Development Process](https://open.larksuite.com/document/uMzMyEjLzMjMx4yMzITM/ukzM3QjL5MzN04SOzcDN) , to
  understand the process and precautions of processing message cards
- For more use examples, please refer to [CardController.java](spring-boot-examples/src/main/java/com/larksuite/oapi/example/CardController.java)（including: use in combination with gin）

#### Example of using "Custom App" to handling message card callback.

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

// "Developer Console" -> "Features" -> "Bot", setting Message Card Request URL: https://domain/webhook/card
// Inherit CardServlet
@WebServlet("/webhook/card")
public class CardController extends CardServlet {

    private static final Logger log = LoggerFactory.getLogger(CardController.class);

    // Provide the config instance through InitConfig.java and inject the config instance through dependency
    public CardController(Config config) {
        super(config);
    }

    @PostConstruct
    public void init() {
        // Set the handler of the message card
        Card.setHandler(this.getConfig(), new IHandler() {
            
            // Return value: can be null or JSON string of new message card
            @Override
            public Object handle(Context context, com.larksuite.oapi.core.card.mode.Card card) throws Exception {
                // Print message card
                log.info("card:{}", card);
                log.info("card.getAction:{}", card.getAction());
                return "{\"config\":{\"wide_screen_mode\":true},\"i18n_elements\":{\"zh_cn\":[{\"tag\":\"div\",\"text\":{\"tag\":\"lark_md\",\"content\":\"[飞书](https://www.feishu.cn)整合即时沟通、日历、音视频会议、云文档、云盘、工作台等功能于一体，成就组织和个人，更高效、更愉悦。\"}}]}}";
            }
        });
    }
}

```    
 

## Advanced use

---

### How to build app settings(AppSettings)

```java
package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.AppSettings;
import com.larksuite.oapi.core.Config;

public class Sample {

    // To prevent application information leakage, in the configuration environment variables, the variables (4) are described as follows:
    // APP_ID: "Developer Console" -> "Credentials"（App ID）
    // APP_Secret: "Developer Console" -> "Credentials"（App Secret）
    // VERIFICATION_Token: VerificationToken、EncryptKey："Developer Console" -> "Event Subscriptions"（Verification Token）
    // ENCRYPT_Key: VerificationToken、EncryptKey："Developer Console" -> "Event Subscriptions"（Encrypt Key）
    // The configuration of "Custom App" is obtained through environment variables
    AppSettings appSettings = Config.getInternalAppSettingsByEnv();
    // The configuration of "Marketplace App" is obtained through environment variables
    AppSettings appSettings = Config.getIsvAppSettingsByEnv();

    // Parameter Description:
    // AppID、AppSecret: "Developer Console" -> "Credentials"（App ID、App Secret）
    // VerificationToken、EncryptKey："Developer Console" -> "Event Subscriptions"（Verification Token、Encrypt Key）
    // The configuration of "Custom App"
    AppSettings appSettings = Config.createInternalAppSettings("AppID", "AppSecret", "VerificationToken", "EncryptKey");
    // The configuration of "Marketplace App"
    AppSettings appSettings = Config.createIsvAppSettings("AppID", "AppSecret", "VerificationToken", "EncryptKey");
}

```

### How to build overall configuration(Config)

- Visit Larksuite, Feishu or others
- App settings
- The implementation of store is used to save the access credentials (app/tenant_access_token), temporary voucher (
  app_ticket）
    - Redis is recommended. Please see the example code: [RedisStore.java](sample/src/main/java/com/larksuite/oapi/sample/config/RedisStore.java)
        - It can reduce the times of obtaining access credentials and prevent the frequency limit of calling access
          credentials interface.
        - "Marketplace App", accept open platform distributed `app_ticket` will be saved to the storage, so the
          implementation of the storage interface (store) needs to support distributed storage.
          
```java
package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.AppSettings;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Domain;
import com.larksuite.oapi.core.IStore;

public class Sample {
    AppSettings appSettings = Config.getIsvAppSettingsByEnv();

    // Method 1: it is recommended to use redis to implement the store interface, so as to reduce the times of accessing the access_token interface
    // Parameter Description:
    // domain：domain：URL domain address, value range: constants.DomainLarkSuite / constants.FeiShu 
    // appSettings：AppSetting
    // store: [Store interface](larksuite-oapi/src/main/java/com/larksuite/oapi/core), used to store app_ticket/access_token
    Config config = new Config(Domain domain, AppSettings appSettings, IStore store);


    // Method 2: it is recommended to use redis to implement the store interface, so as to reduce the times of accessing the access_token interface
    // Parameter Description:
    // domain：URL domain name address, for example: "https://open.feishu.cn"
    // appSettings：AppSetting
    // store: [Store interface](larksuite-oapi/src/main/java/com/larksuite/oapi/core), used to store app_ticket/access_token
    Config config = new Config(String domain, AppSettings appSettings, IStore store);
}
```

### How to build a request(Request)

- Some of the old interfaces do not have an SDK that can be used directly. They can use `native` mode. At this time,
  they need to build requests.
- For more examples, see [ApiSample.java](sample/src/main/java/com/larksuite/oapi/sample/api/ApiSample.java)(including: file upload and download)

```java
package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.api.AccessTokenType;
import com.larksuite.oapi.core.api.request.Request;
import com.larksuite.oapi.core.api.request.RequestOptFn;

public class Sample {
    
    // Parameter Description:
    // httpPath：API path（the path after `open-apis/`）, for example: https://domain/open-apis/contact/v3/users/:user_id, then httpPath："contact/v3/users/:user_id"
    // httpMethod: GET/POST/PUT/BATCH/DELETE
    // accessTokenType：What kind of access certificate does the API use and the value range：AccessTokenType.App/AccessTokenType.Tenant/AccessTokenType.User, for example: AccessTokenType.Tenant
    // input：Request body (possibly new FormData() (e.g. file upload)), if the request body (e.g. some get requests) is not needed, it will be transferred to: nil
    // output：Response body (output: = response ["data"])
    // requestOptFns：Extension function, some rarely used parameter encapsulation, as follows:
    // Request.setPathParams(map[string]interface{}{"user_id": 4}): set the URL Path parameter(with: prefix) value, When httpPath="contact/v3/users/:user_id", the requested URL="https://{domain}/open-apis/contact/v3/users/4"
    // Request.setQueryParams(map[string]interface{}{"age":4,"types":[1,2]}): Set the URL query, will append to the url?age=4&types=1&types=2   
    // Request.setResponseStream(), set whether the response is a stream, such as downloading a file, at this time: output type implements java.io.OutputStream interface
    // Request.setNotDataField(), set whether the response does not have a `data` field, business interfaces all have `data `Field, so you don’t need to set 
    // Request.setTenantKey("TenantKey"), as an `app store application`, it means using `tenant_access_token` to access the API, you need to set 
    // Request.setUserAccessToken("UserAccessToken"), which means using` user_access_token` To access the API, you need to set 
    // Request.setTimeout(int time, TimeUnit timeUnit), Set the time for the request to time out
    Request<I, O> req = Request.newRequest(String httpPath, String httpMethod, AccessTokenType accessTokenType, I input, O output, RequestOptFn...requestOptFns)
}
```

### Common methods of context

```java
package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Context;

public class Sample {
    
    Context context = new Context();
    
    // Get the request ID of the request and event subscription for troubleshooting
    String requestId = context.getRequestID();

    // Get the response status code of the request
    int httpStatusCode = context.getHTTPStatusCode();

    // In the handler of event subscription and message card callback, you can Context Get config from
    Config config = Config.ByCtx(Context context);
}

```

### How to send a request

- Since the SDK has encapsulated the app_access_token、tenant_access_token So when calling the business API, you don't need to get the app_access_token、tenant_access_token. If the business interface needs to use user_access_token, which needs to be set（Request.setUserAccessToken("UserAccessToken")), Please refer to README.md -> How to build a request(Request)
- For more use examples, please see: [ApiSample.java](sample/src/main/java/com/larksuite/oapi/sample/api/ApiSample.java)

```java
package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.api.Api;
import com.larksuite.oapi.core.api.response.Response;

public class Sample {
    // Parameter Description:
    // req：Request（Request）
    // Return value Description:
    // Response<O>：Results of the request（= http response body）
    // Exception：Exception in sending request
    Response<O> response = Api.send(Config config, Request <I,O> request) throws Exception;
}
```

### Download File Tool

- Download files via network request
- For more use examples, please see:[sample/tools/FileDownloadSample.java](sample/src/main/java/com/larksuite/oapi/sample/tools/FileDownloadSample.java)

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

## License

---

- Apache-2.0
