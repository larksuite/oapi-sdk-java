package com.lark.oapi.channel.outbound;

import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;
import org.junit.Assert;
import org.junit.Test;

public class TestOutboundErrors {
    @Test
    public void testClassifyFeishuBusinessAndHttpCodes() {
        assertCode(LarkChannelErrorCode.TARGET_REVOKED, "230020 message not found");
        assertCode(LarkChannelErrorCode.TARGET_REVOKED, "http 404");
        assertCode(LarkChannelErrorCode.PERMISSION_DENIED, "99991401 permission denied");
        assertCode(LarkChannelErrorCode.PERMISSION_DENIED, "http 403");
        assertCode(LarkChannelErrorCode.FORMAT_ERROR, "230002 invalid post");
        assertCode(LarkChannelErrorCode.RATE_LIMITED, "http 429");
        assertCode(LarkChannelErrorCode.SSRF_BLOCKED, "ssrf blocked");
        assertCode(LarkChannelErrorCode.SEND_TIMEOUT, "ETIMEDOUT");
        assertCode(LarkChannelErrorCode.UNKNOWN, "unexpected response");
    }

    @Test
    public void testClassifyPreservesExistingChannelException() {
        LarkChannelException original = new LarkChannelException(LarkChannelErrorCode.FORMAT_ERROR, "bad format");

        LarkChannelException classified = OutboundErrors.classifyError(original);

        Assert.assertSame(original, classified);
    }

    @Test
    public void testClassifyWrapsCauseAndUsesOverrideMessage() {
        RuntimeException cause = new RuntimeException("http 429");

        LarkChannelException classified = OutboundErrors.classifyError(cause, "send failed");

        Assert.assertEquals(LarkChannelErrorCode.RATE_LIMITED.getValue(), classified.getCode());
        Assert.assertEquals("send failed", classified.getMessage());
        Assert.assertSame(cause, classified.getCause());
    }

    @Test
    public void testRetryableBuckets() {
        Assert.assertTrue(OutboundErrors.isRetryable(
                new LarkChannelException(LarkChannelErrorCode.RATE_LIMITED, "rate limited")));
        Assert.assertTrue(OutboundErrors.isRetryable(
                new LarkChannelException(LarkChannelErrorCode.UNKNOWN, "unknown")));
        Assert.assertFalse(OutboundErrors.isRetryable(
                new LarkChannelException(LarkChannelErrorCode.FORMAT_ERROR, "bad post")));
    }

    private void assertCode(LarkChannelErrorCode expected, String message) {
        LarkChannelException classified = OutboundErrors.classifyError(new RuntimeException(message));
        Assert.assertEquals(expected.getValue(), classified.getCode());
    }
}
