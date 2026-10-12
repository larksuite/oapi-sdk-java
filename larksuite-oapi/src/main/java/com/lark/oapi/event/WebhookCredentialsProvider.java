package com.lark.oapi.event;

/**
 * Supplies one immutable credentials snapshot per HTTP webhook. Implementations
 * must be thread safe and prompt; external I/O requires caller-owned timeouts.
 * The SDK does not retry, poll remotely, or invoke this on trusted WebSocket dispatch.
 */
@FunctionalInterface
public interface WebhookCredentialsProvider {
  /**
   * Returns current credentials, with empty strings explicitly meaning unconfigured.
   *
   * @return non-null credentials containing non-null strings
   * @throws Exception if credentials cannot be obtained; the request is rejected
   */
  WebhookCredentials getCredentials() throws Exception;
}
