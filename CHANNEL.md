# Java Channel 使用指南

`LarkChannel` 是 Java SDK 面向 Agent / Bot 场景提供的高层会话通道封装。它把飞书/Lark 的长连接事件、Webhook 事件、消息归一化、发送回复、流式输出、资源上传下载、反应表情和安全策略组合成一个统一入口，让 Agent 可以专注于理解上下文并生成响应。

## 内部职责分层

`LarkChannel` 与 NodeJS Channel 保持一致的职责分区，主类只作为公开门面和生命周期编排入口：

| 分区 | 主要 API / 文件 | 说明 |
| --- | --- | --- |
| lifecycle | `LarkChannel.connect` / `disconnect` | 获取机器人身份、启动或关闭 WebSocket、释放安全流水线 |
| event subscription | `LarkChannel.on`、`ChannelEventHandler`、`ChannelSubscription`、`ChannelEventBus` | 注册、批量注册和取消事件监听 |
| outbound | `OutboundSender` | 发送新消息和流式输出 |
| low-level | `ChannelLowLevelApi` | 编辑、更新卡片、撤回、下载资源、表情反应和 `getChatInfo` 等直接 API 操作 |
| runtime config | `ChannelRuntimeConfig` | 运行时更新和读取安全策略 |
| internals: bot identity & dispatch wiring | `BotIdentityResolver`、`ChannelEventDispatcherFactory`、`ChannelInboundProcessor` | 解析机器人身份、创建 Webhook dispatcher、处理入站事件归一化和安全策略 |

## 适用场景

- 在飞书/Lark 中接入 AI Agent、客服机器人、知识库问答机器人或自动化助手。
- 同时处理单聊、群聊、卡片回调、表情反应、机器人进群和文档评论等事件。
- 需要对消息做去重、过期过滤、群聊白名单、单聊白名单、必须 @ 机器人等安全控制。
- 需要发送文本、Markdown、富文本、图片、文件、音频、视频、卡片、群名片、个人名片和贴纸。
- 需要边生成边更新飞书消息，提供类似流式回答的体验。

## Agent 如何介入 Channel

推荐把 Channel 放在 Agent 的 I/O 边界层：

1. `LarkChannel` 负责连接飞书/Lark、接收事件、归一化消息、执行安全策略。
2. 业务侧的 Agent handler 只读取 `NormalizedMessage`，把 `content`、`resources`、`mentions`、`chatId` 等字段转成模型上下文。
3. Agent 生成新结果后，优先通过 `channel.send(...)` 或 `channel.stream(...)` 回写到会话。
4. 如果结果需要覆盖已有消息或已有卡片，再基于已有 `messageId` 使用 `channel.editMessage(...)` 或 `channel.updateCard(...)`。
5. 需要读取图片/文件时，通过 `channel.downloadResource(fileKey, type)` 拿到 `byte[]` 后交给多模态或文件解析链路。
6. 需要状态反馈时，通过 `channel.addReaction(...)`、`channel.removeReaction(...)` 或交互卡片处理 `cardAction`。

最小接入示例：

```java
import com.lark.oapi.channel.LarkChannel;
import com.lark.oapi.channel.ChannelEventHandler;
import com.lark.oapi.channel.LarkChannelFactory;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.model.NormalizedMessage;
import com.lark.oapi.channel.model.SendInput;
import com.lark.oapi.channel.model.SendOptions;

public class AgentBot {
    public static void main(String[] args) throws Exception {
        LarkChannel channel = LarkChannelFactory.createLarkChannel(
                LarkChannelOptions.newBuilder(System.getenv("APP_ID"), System.getenv("APP_SECRET"))
                        .transport("websocket")
                        .build()
        );

        channel.on("message", new ChannelEventHandler<NormalizedMessage>() {
            @Override
            public void handle(NormalizedMessage message) {
                try {
                    String answer = callAgent(message.getContent());
                    channel.send(
                            message.getChatId(),
                            SendInput.markdown(answer),
                            SendOptions.newBuilder().replyTo(message.getMessageId()).build()
                    );
                } catch (Exception e) {
                    channel.send(
                            message.getChatId(),
                            SendInput.text("处理失败，请稍后重试。"),
                            SendOptions.newBuilder().replyTo(message.getMessageId()).build()
                    );
                }
            }
        });

        channel.connect().get();
        Thread.currentThread().join();
    }

    private static String callAgent(String userInput) {
        return "收到：" + userInput;
    }
}
```

## 安装与初始化

在业务项目中引入 SDK：

```xml
<dependency>
    <groupId>com.larksuite.oapi</groupId>
    <artifactId>oapi-sdk</artifactId>
    <version>2.6.1</version>
</dependency>
```

创建 Channel：

```java
LarkChannel channel = LarkChannelFactory.createLarkChannel(
        LarkChannelOptions.newBuilder("cli_xxx", "app_secret_xxx")
                .transport("websocket")
                .build()
);
```

`connect()` 会获取机器人身份并启动 WebSocket 长连接：

```java
BotIdentity identity = channel.connect().get();
System.out.println(identity.getOpenId());
```

退出应用时调用：

```java
channel.disconnect().get();
```

## 传输模式

### WebSocket

默认使用 `websocket`，适合本地开发、Agent 服务和不方便暴露公网回调地址的场景：

```java
LarkChannelOptions.newBuilder(appId, appSecret)
        .transport("websocket")
        .build();
```

WebSocket 断线重连时会触发：

- `reconnecting`
- `reconnected`

### HTTP 配置

`LarkChannelOptions` 支持以下 HTTP 相关配置：

- `httpTransport(IHttpTransport)`：配置 raw `Client` 使用的 HTTP transport，等价于 NodeJS Channel 中 `httpInstance` 更接近的能力，适合替换底层 HTTP 客户端、代理、统一拦截器等场景。
- `httpInstance(RequestOptions)`：配置单次 raw request 的请求选项，目前用于 `connect()` 拉取机器人身份等低层请求，不是底层 HTTP transport。
- `source(String)`：拼装到 raw `Client` 的 User-Agent 中，格式为 `oapi-sdk-java/v2.0.0 source/<sanitized>`；空值或清理后为空的值只保留基础 User-Agent。

```java
LarkChannel channel = LarkChannelFactory.createLarkChannel(
        LarkChannelOptions.newBuilder(appId, appSecret)
                .httpTransport(customTransport)
                .source("cursor bot")
                .build()
);
```

### Webhook

如果业务已有 HTTP 服务，也可以使用 SDK 事件分发器：

```java
LarkChannelOptions.WebhookOptions webhook = new LarkChannelOptions.WebhookOptions();
webhook.setVerificationToken("verification_token");
webhook.setEncryptKey("encrypt_key");

LarkChannel channel = LarkChannelFactory.createLarkChannel(
        LarkChannelOptions.newBuilder(appId, appSecret)
                .transport("webhook")
                .webhook(webhook)
                .build()
);

EventDispatcher dispatcher = channel.createWebhookDispatcher();
```

将 `dispatcher` 接到现有 HTTP 事件入口即可复用同一套 Channel handler。

## 事件监听

注册单个事件：

```java
ChannelSubscription subscription = channel.on("message",
        new ChannelEventHandler<NormalizedMessage>() {
            @Override
            public void handle(NormalizedMessage message) {
                System.out.println(message.getContent());
            }
        });

subscription.unsubscribe();
```

支持事件：

| 事件名 | 事件对象 | 说明 |
| --- | --- | --- |
| `message` | `NormalizedMessage` | 普通消息，已归一化文本、资源、@ 信息、回复关系等字段 |
| `cardAction` | `CardActionEvent` | 交互卡片按钮、选择器等动作回调 |
| `reaction` | `ReactionEvent` | 消息表情新增或删除 |
| `botAdded` | `BotAddedEvent` | 机器人被加入群聊 |
| `comment` | `CommentEvent` | 云文档评论新增事件 |
| `reject` | `RejectEvent` | 消息被安全策略拒绝 |
| `error` | `Object` | 预留错误事件 |
| `reconnecting` | `Object` | WebSocket 正在重连 |
| `reconnected` | `Object` | WebSocket 重连成功 |

`NormalizedMessage` 常用字段：

| 字段 | 说明 |
| --- | --- |
| `messageId` | 当前消息 ID |
| `chatId` | 会话 ID，可直接用于 `send` |
| `chatType` | 单聊或群聊类型 |
| `senderId` / `senderName` | 发送人信息 |
| `content` | 归一化后的文本内容 |
| `rawContentType` | 原始消息类型 |
| `resources` | 图片、文件、音频、视频等资源描述 |
| `mentions` | @ 用户列表 |
| `mentionedBot` | 是否 @ 当前机器人 |
| `mentionAll` | 是否 @ 所有人 |
| `rootId` / `threadId` / `replyToMessageId` | 回复与话题上下文 |
| `raw` | 原始事件，需设置 `includeRawInMessage(true)` 才会携带 |

## 消息发送

`send(to, input)` 会根据 `to` 自动识别接收者类型：

| `to` 形式 | 识别为 |
| --- | --- |
| `oc_...` | `chat_id` |
| `ou_...` | `open_id` |
| `on_...` | `union_id` |
| 包含 `@` | `email` |
| 其他 | `user_id` |

发送文本和 Markdown：

```java
SendResult text = channel.send("oc_xxx", SendInput.text("hello")).get();

SendResult markdown = channel.send(
        "oc_xxx",
        SendInput.markdown("# 标题\n\n- 第一项\n- 第二项")
).get();
```

回复消息和 @ 用户：

```java
SendOptions options = SendOptions.newBuilder()
        .replyTo("om_xxx")
        .mentions(java.util.Arrays.asList("ou_user_open_id"))
        .build();

channel.send("oc_xxx", SendInput.text("已收到"), options).get();
```

支持的 `SendInput`：

| 方法 | 说明 |
| --- | --- |
| `SendInput.text(text)` | 文本 |
| `SendInput.markdown(markdown)` | Markdown，SDK 转为飞书富文本发送 |
| `SendInput.post(post)` | 原生富文本对象 |
| `SendInput.image(source)` | 图片，支持本地路径、`File`、`byte[]`、`InputStream`、HTTP(S) URL |
| `SendInput.file(source, fileName)` | 文件 |
| `SendInput.audio(source, duration)` | 音频 |
| `SendInput.video(source, duration, coverImageKey)` | 视频 |
| `SendInput.card(card)` | 交互卡片 |
| `SendInput.shareChat(chatId)` | 群名片 |
| `SendInput.shareUser(userId)` | 个人名片 |
| `SendInput.sticker(fileKey)` | 表情贴纸 |

## 流式输出

Markdown 流式输出适合 Agent 边生成边回复：

```java
channel.stream("oc_xxx", StreamInput.markdown(controller -> {
    controller.append("正在分析问题...\n\n");
    controller.append("结论 1\n");
    controller.append("结论 2\n");
})).get();
```

卡片流式输出适合进度条、工具调用状态和多阶段任务：

```java
Map<String, Object> initialCard = new java.util.LinkedHashMap<String, Object>();
initialCard.put("type", "template");
initialCard.put("data", new java.util.LinkedHashMap<String, Object>());

channel.stream("oc_xxx", StreamInput.card(initialCard, controller -> {
    Map<String, Object> next = new java.util.LinkedHashMap<String, Object>(controller.getCurrent());
    next.put("status", "done");
    controller.update(next);
})).get();
```

可通过 `LarkChannelOptions.OutboundConfig` 调整流式节流：

```java
LarkChannelOptions.OutboundConfig outbound = new LarkChannelOptions.OutboundConfig();
outbound.setStreamThrottleMs(100);
outbound.setStreamThrottleChars(50);
outbound.setStreamInitialText("Thinking...");
```

## 编辑、撤回和卡片更新

```java
channel.editMessage("om_xxx", "新的文本").get();
channel.updateCard("om_card_xxx", card).get();
channel.recallMessage("om_xxx").get();
```

说明：

- `editMessage` 使用消息更新接口，适合文本/富文本消息。
- `updateCard` 使用卡片更新接口，适合 interactive 卡片。
- `recallMessage` 撤回已发送消息。

## 资源上传与下载

发送图片或文件时，Channel 会先上传资源，再发送消息：

```java
channel.send("oc_xxx", SendInput.image("/tmp/a.png")).get();
channel.send("oc_xxx", SendInput.file(fileBytes, "report.pdf")).get();
```

收到资源消息时，可以从 `NormalizedMessage.getResources()` 读取 `fileKey`：

```java
channel.on("message", new ChannelEventHandler<NormalizedMessage>() {
    @Override
    public void handle(NormalizedMessage message) {
        for (ResourceDescriptor resource : message.getResources()) {
            byte[] bytes = channel.downloadResource(resource.getFileKey(), resource.getType()).join();
            System.out.println("downloaded bytes: " + bytes.length);
        }
    }
});
```

安全限制：

- 本地文件默认禁止读取 `/etc/`、`/proc/`、`/sys/`、`/dev/`、`/private/etc/` 等敏感路径。
- 可通过 `outbound.allowedFileDirs` 限定允许上传的本地目录。
- HTTP(S) URL 默认启用 SSRF 防护，会阻止私网、回环、链路本地、多播地址。
- 可通过 `outbound.ssrfAllowlist` 放行可信域名，或在受控环境关闭 `ssrfGuardEnabled`。

## 表情反应

```java
String reactionId = channel.addReaction("om_xxx", "OK").get();
channel.removeReaction("om_xxx", reactionId).get();

boolean removed = channel.removeReactionByEmoji("om_xxx", "OK").get();
```

`removeReactionByEmoji` 会查找当前机器人添加的对应 emoji 并删除，找不到时返回 `false`。

## 安全策略

默认策略偏向 Agent 场景：

- 群聊中要求 @ 机器人。
- 不响应 @ 所有人，除非显式开启。
- 单聊默认开放。
- 对消息做去重、过期过滤和按会话串行处理。

配置示例：

```java
LarkChannelOptions.PolicyConfig policy = new LarkChannelOptions.PolicyConfig();
policy.setGroupAllowlist("oc_allowed_group");
policy.setDmMode("allowlist");
policy.setDmAllowlist("ou_allowed_user");
policy.setRequireMention(true);
policy.setRespondToMentionAll(false);

LarkChannel channel = LarkChannelFactory.createLarkChannel(
        LarkChannelOptions.newBuilder(appId, appSecret)
                .policy(policy)
                .build()
);
```

运行时更新策略：

```java
channel.updatePolicy(policy);
LarkChannelOptions.PolicyConfig current = channel.getPolicy();
```

被策略拒绝的事件会触发 `reject`：

```java
channel.on("reject", new ChannelEventHandler<RejectEvent>() {
    @Override
    public void handle(RejectEvent event) {
        System.out.println(event.getReason().getValue());
    }
});
```

拒绝原因：

| 原因 | 说明 |
| --- | --- |
| `group_not_allowed` | 群聊不在白名单 |
| `sender_not_allowed` | 单聊发送人不在白名单 |
| `no_mention` | 群聊未 @ 机器人 |
| `dm_disabled` | 单聊已关闭 |
| `mention_all_blocked` | 命中 @ 所有人拦截 |

## 完整示例

仓库提供了可运行示例：

```bash
export APP_ID=cli_xxx
export APP_SECRET=app_secret_xxx
export CHANNEL_TRANSPORT=websocket
export CHANNEL_RECEIVE_ID=oc_xxx
export CHANNEL_KEEP_ALIVE_SECONDS=60

mvn -pl sample -DskipTests exec:java \
  -Dexec.mainClass=com.lark.oapi.sample.channel.ChannelSample
```

可选环境变量：

| 变量 | 说明 |
| --- | --- |
| `CHANNEL_TRANSPORT` | `websocket` 或 `webhook`，默认 `websocket` |
| `CHANNEL_RECEIVE_ID` | 用于主动发送测试消息的接收者 |
| `CHANNEL_REPLY_TO` | 回复测试目标消息 ID |
| `CHANNEL_MENTION_OPEN_ID` | @ 测试目标用户 open_id |
| `CHANNEL_KEEP_ALIVE_SECONDS` | WebSocket 示例保持运行时间 |

示例源码位于 `sample/src/main/java/com/lark/oapi/sample/channel/ChannelSample.java`。

## 应用配置建议

在开发者后台确认：

- 应用已启用机器人能力，并已安装到目标租户。
- 如果使用 WebSocket，已开启长连接事件订阅。
- 如果使用 Webhook，已配置请求地址、Verification Token 和 Encrypt Key。
- 订阅需要的事件，例如消息接收、卡片回调、表情反应、机器人进群、文档评论。
- 为消息发送、编辑、撤回、上传下载文件、添加/删除表情等能力申请对应权限。

## 测试状态

Channel 相关自动化测试覆盖连接、事件归一化、消息发送路由、Markdown 转换、流式输出、上传下载、策略安全和部分回归场景。当前测试计划和覆盖状态见 `channel-test-plan-status.md`。

可执行：

```bash
mvn -pl larksuite-oapi -DskipTests=false -DfailIfNoTests=false \
  -Dtest=TestLarkChannel,TestNormalizeAndSafety,TestNormalize,TestNormalizeConverters,TestNormalizeEventNormalizers,TestNormalizeMentions,TestNormalizeMergeForward,TestOutboundMarkdown,TestOutboundRouting,TestOutboundSenderFallback,TestOutboundStreaming,TestOutboundUploader test
```
