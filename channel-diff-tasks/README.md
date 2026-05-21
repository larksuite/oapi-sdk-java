# Java Channel 对齐 NodeJS 实现任务拆分

> 基准：以 NodeJS `channel` 实现为主，对 Java `feat/sup_channel` 分支的 `channel` 模块进行差异拆分。
>
> 状态规则：`✅` 表示当前 Java 已完成或已对齐；空白表示待实现/待补齐。

## 模块文件

| 状态 | 模块 | 文件 | 目标 |
| --- | --- | --- | --- |
| ✅ | 生命周期与连接 | `01-lifecycle-and-connection.md` | 对齐 connect、WS/Webhook、bot identity 和 runtime policy 语义。 |
| ✅ | 事件订阅与错误 | `02-events-and-errors.md` | 对齐事件订阅返回值、单 handler 语义、error 事件和 handler 异常处理。 |
| ✅ | 安全流水线 | `03-safety-pipeline.md` | 对齐 stale、dedup、policy、lock、batch merge、queue 处理。 |
| ✅ | 归一化与模型 | `04-normalization-and-models.md` | 对齐入站模型、mentions、dedup key 和事件归一化字段。 |
| ✅ | 出站发送 | `05-outbound-send.md` | 对齐 text/markdown/post/media/card/share/sticker 的发送语义。 |
|  | 媒体上传与安全 | `06-media-upload-security.md` | 对齐 SSRF、本地路径、URL 限制、音视频时长解析。 |
| ✅ | 流式输出 | `07-streaming.md` | 对齐 Markdown/Card streaming 的 CardKit API、节流队列和异常收尾。 |
| ✅ | 测试与文档 | `08-tests-and-docs.md` | 补齐单测矩阵、集成测试说明、`CHANNEL.md` 与示例。 |

## 建议实施顺序

| 顺序 | 模块 | 原因 |
| --- | --- | --- |
| 1 | `05-outbound-send.md`、`02-events-and-errors.md`、`06-media-upload-security.md` | 先修正发送失败、错误不可观测和安全风险。 |
| 2 | `03-safety-pipeline.md`、`07-streaming.md` | 对齐 Agent 核心体验：连续消息聚合和原生流式输出。 |
| 3 | `04-normalization-and-models.md`、`01-lifecycle-and-connection.md` | 收敛公开模型和生命周期边界语义。 |
| 4 | `08-tests-and-docs.md` | 固化行为，降低回归风险。 |
