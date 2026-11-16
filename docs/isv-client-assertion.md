# 商店应用 ClientAssertion 认证

商店应用需要由平台开放 ClientAssertion 认证能力；当前服务端支持范围为字节内部场景。目标租户需要安装应用并授予相应权限。SDK 复用已有 Provider，不生成或保存私钥。

TAT 使用 JSON 请求调用 `/oauth/v3/token`，参数为 `client_credentials`、`client_id`、`client_assertion_type`、`client_assertion` 和 `tenant_key`。缓存按应用、租户和 OAuth 端点隔离；有效期和缓存失败处理沿用当前语言 SDK 的既有行为。

UAT 继续使用现有授权码兑换与刷新方法，分别使用 `authorization_code` 和 `refresh_token`，不传 `tenant_key`。使用 UAT 调用业务接口时显式传入用户 Token，不触发 TAT 兑换。

自建应用的 jwt-bearer、AppSecret 接入、Provider 优先级、请求重试和 TargetInfo 代理方式保持原样。无密钥 ISV 自动取 Token 不经过 AppTicket 或 AppAccessToken。

```java
Client client = Client.newBuilder(appId, "")
        .marketplaceApp()
        .clientAssertionProvider(provider)
        .build();
RequestOptions options = RequestOptions.newBuilder()
        .tenantKey(tenantKey)
        .build();
```

`provider` 实现现有 `ClientAssertionProvider`。调用生成的服务方法时传入上述 `options`。用户授权码兑换和刷新继续使用 `client.accessToken().retrieveByAuthorizationCode(...)` 与 `client.accessToken().refresh(...)`；业务调用通过 `RequestOptions.newBuilder().userAccessToken(userAccessToken).build()` 显式传入 UAT。

自定义业务域名时配置现有 OAuth 基址选项；Provider 的 aud 仍为真实 OAuth host。请勿在日志中记录 Assertion、Token、授权码或 RefreshToken。
