# Java SDK ClientAssertion 修改与 E2E 测试报告

## 1. 结论

本轮 Java SDK `codex/keyless-logic` 分支修改后，ClientAssertion 相关本地回归、完整模块测试和真实 live E2E 均通过。

结论：通过。

理由：

- ClientAssertion tenant token cache 已改为可在 Provider 执行前计算的方案 B，cache hit 时不会调用 Provider，也不会发起 token exchange。
- AppSecret 与 ClientAssertion cache namespace 已隔离，避免旧 AppSecret cache 命中 ClientAssertion 链路。
- 新增负向用例覆盖 V3 token API 业务错误、缺失 access token、Provider 抛错、不应重试、日志敏感字段省略、WS 7102 包装。
- 真实 live E2E 覆盖 AppSecret、ZTI、GDPR 三种链路，包含 OAuth authorization code、refresh token、UAT 调用、tenant token 发消息和 WebSocket endpoint/connect，结果全部通过。
- 本轮执行中未将原始 AppSecret、ClientAssertion、authorization code、access token、refresh token 写入代码、报告或命令行参数。

## 2. 本轮修改摘要

### 2.1 Cache Key 方案

采用方案 B，并保留旧逻辑已有的 `tenant_key` 维度，避免 ISV 多租户场景串用 tenant token。

- AppSecret tenant token key：
  - `tenant_token:app_secret:{app_id}:{tenant_key}`
- ClientAssertion tenant token key：
  - `tenant_token:client_assertion:{app_id}:{tenant_key}:{aud}`

行为变化：

- ClientAssertion 模式下先通过 SDK 配置推导 `aud`，再查 cache。
- cache hit 时直接返回 tenant token，不执行 `ClientAssertionProvider.retrieveToken(aud)`。
- cache miss 时才执行 Provider，并按 `TargetInfo` 决定是否走 proxy。
- `TargetInfo` 不再参与 cache key，符合“不要让 Provider 先执行”的要求。

### 2.2 安全与错误语义

- debug 请求日志中，敏感 header 和 body 字段直接省略：
  - `Authorization`
  - `client_assertion`
  - `client_secret`
  - `refresh_token`
  - `access_token`
  - `tenant_access_token`
  - `app_access_token`
- OAuth V3 token response 按 root `code` 判断业务成功失败：
  - HTTP 200 但 `code != 0` 抛 `AccessTokenError`
  - `code == 0` 但缺少 `access_token` 抛 `AccessTokenError`
- Transport 不再对 ClientAssertion Provider retrieve 失败做内部重试。
- WebSocket Provider retrieve 失败包装为 `ClientException(7102, ...)`。

## 3. 新增/调整测试

### 3.1 Cache 测试

- `appSecretTenantTokenUsesModeSpecificCacheKey`
  - 验证 AppSecret 使用 `tenant_token:app_secret:{app_id}:{tenant_key}`。
- `clientAssertionCacheHitUsesModeSpecificKeyBeforeProviderAndAvoidsTransport`
  - 验证 ClientAssertion cache hit 时 Provider 调用次数为 0，Transport 不发请求。
- `legacyAppSecretCacheDoesNotBypassClientAssertionProvider`
  - 验证 AppSecret 旧 namespace 不会绕过 ClientAssertion Provider。
- `targetInfoDoesNotChangeClientAssertionCacheKey`
  - 验证 cache key 不依赖 Provider 返回的 `TargetInfo`。

### 3.2 负向测试

- `v3BusinessErrorWithHttp200ThrowsAccessTokenError`
  - HTTP 200 但 V3 `code != 0` 必须抛错。
- `v3SuccessCodeWithoutAccessTokenThrowsAccessTokenError`
  - V3 `code == 0` 但缺少 `access_token` 必须抛错。
- `providerRetrieveFailureDoesNotRetryInsideTransport`
  - Provider retrieve 失败不在 Transport 内部重试。
- `debugRequestLogOmitsSensitiveHeadersAndBody`
  - debug log 不出现 raw assertion、secret、token。
- `providerRetrieveFailureIsWrappedWith7102`
  - WS Provider 抛错时包装为 7102。

## 4. 验证记录

### 4.1 RED 验证

命令：

```bash
mvn -pl larksuite-oapi -DskipTests=false -Dmaven.test.skip=false -Dtest=TestClientAssertionTokenManager test
```

修改测试后、实现前，结果符合预期失败：

- Tests run: 10
- Failures: 3
- Errors: 1
- Skipped: 0

失败原因与预期一致：

- 旧实现仍使用 `tenant_access_token-ca-...` key。
- cache hit 前仍执行 Provider。
- `TargetInfo` 仍参与 cache key。
- 命中方案 B cache 时仍继续走 token exchange，导致空响应错误。

### 4.2 TokenManager 定向回归

命令：

```bash
mvn -pl larksuite-oapi -DskipTests=false -Dmaven.test.skip=false -Dtest=TestClientAssertionTokenManager test
```

结果：

- Tests run: 11
- Failures: 0
- Errors: 0
- Skipped: 0

### 4.3 ClientAssertion 相关定向回归

命令：

```bash
mvn -pl larksuite-oapi -DskipTests=false -Dmaven.test.skip=false -Dtest=TestClientAssertionTokenManager,TestTransportClientAssertion,TestAccessToken,TestClientAssertionWsClient test
```

结果：

- Tests run: 37
- Failures: 0
- Errors: 0
- Skipped: 0

### 4.4 完整模块测试

命令：

```bash
mvn -pl larksuite-oapi -DskipTests=false -Dmaven.test.skip=false test
```

结果：

- Tests run: 225
- Failures: 0
- Errors: 0
- Skipped: 4

Skipped 原因：

- `TestLarkChannelIntegration` 2 个用例：
  - 需要显式设置 `LARK_CHANNEL_IT_ENABLED=true`、`LARK_CHANNEL_IT_APP_ID`、`LARK_CHANNEL_IT_APP_SECRET`。
  - 属于真实 Feishu channel integration 测试，默认不在模块测试中启用。
- `TestClientAssertionLiveE2E` 2 个用例：
  - 完整模块测试未注入 live E2E 环境，因此被 `LARK_CLIENT_ASSERTION_E2E=1` 门控跳过。
  - 下方已通过单独 live E2E 命令完整执行，未跳过。

### 4.5 完整 Live E2E

命令：

```bash
bash -lc 'set +x
IFS= read -rs LARK_ZTI_CLIENT_ASSERTION
printf "\n"
export LARK_ZTI_CLIENT_ASSERTION
mvn -pl larksuite-oapi -DskipTests=false -Dmaven.test.skip=false \
  -Dlark.e2e.envFile=/Users/bytedance/Documents/oapi_sdk/oapi-sdk-python/.env.e2e \
  -Dtest=TestClientAssertionLiveE2E test'
```

说明：

- ZTI ClientAssertion 通过 stdin 注入，不进入命令行参数。
- `.env.e2e` 提供 AppID、AppSecret、GDPR assertion、Proxy、OAuth redirect、scope、open_id 等环境。
- 真实 OAuth 授权通过浏览器完成。

结果：

- Tests run: 2
- Failures: 0
- Errors: 0
- Skipped: 0
- Total time: 02:38 min
- Finished at: 2026-06-10T20:18:12+08:00

通过的 live case：

| Case | 覆盖点 | 结果 |
| --- | --- | --- |
| `OAUTH-APPSECRET` | AppSecret authorization code 换 UAT、refresh、UAT basic_batch | PASS |
| `ZTI-03/04/05/06` | ZTI ClientAssertion authorization code、refresh、UAT basic_batch | PASS |
| `GDPR-03/04/05` | GDPR ClientAssertion + Proxy authorization code、refresh、UAT basic_batch | PASS |
| `SECRET-02` | AppSecret tenant token 发 IM 消息 | PASS |
| `ZTI-02` | ZTI ClientAssertion tenant token 发 IM 消息 | PASS |
| `GDPR-TAT` | GDPR ClientAssertion + Proxy tenant token 发 IM 消息 | PASS |
| `ENV-05` | Provider 优先于 AppSecret | PASS |
| `SECRET-04` | AppSecret WS endpoint/connect | PASS |
| `WS-01/WS-03-ZTI` | ZTI WS endpoint/connect | PASS |
| `WS-02/WS-03-GDPR` | GDPR WS endpoint/connect | PASS |

## 5. 结论依据

本轮可以给出“通过”结论，是因为：

- 本地测试覆盖了本轮改动的关键分支和负向语义，且先观察到 RED，再通过实现修复变为 GREEN。
- 完整模块测试通过，说明改动没有破坏现有 SDK 单测、Channel、事件、WS 和 E2E harness 的默认测试面。
- live E2E 真实命中了飞书线上 OAuth/OpenAPI/WS 链路，并覆盖 AppSecret、ZTI、GDPR 三种凭证路径。
- ZTI live case 已使用本轮用户更新后的 ClientAssertion，上一轮过期错误不再出现。
- 敏感信息处理通过单测断言，且执行过程中没有把原始凭证写入报告或仓库文件。

## 6. 备注

- Maven 仍提示 `gson` 依赖重复声明 warning：`com.google.code.gson:gson` 存在 `${gson.version}` 与 `2.9.0` 两处声明。本轮未修改依赖管理，建议后续单独清理。
- `rg` 扫描 JWT 模式时命中仓库既有 Javadoc/sample 示例 page_token，不是本轮新增的 ZTI ClientAssertion。
