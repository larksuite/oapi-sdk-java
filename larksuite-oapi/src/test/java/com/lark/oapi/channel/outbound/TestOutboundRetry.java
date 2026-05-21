package com.lark.oapi.channel.outbound;

import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Assert;
import org.junit.Test;

public class TestOutboundRetry {
    @Test
    public void testRetryableErrorRetriesUntilSuccess() {
        LarkChannelOptions.RetryConfig retry = new LarkChannelOptions.RetryConfig();
        retry.setMaxAttempts(3);
        retry.setBaseDelayMs(0L);
        final AtomicInteger attempts = new AtomicInteger();

        String result = OutboundRetry.retry(attempt -> {
            attempts.incrementAndGet();
            if (attempt < 3) {
                throw new LarkChannelException(LarkChannelErrorCode.RATE_LIMITED, "429");
            }
            return "ok";
        }, retry);

        Assert.assertEquals("ok", result);
        Assert.assertEquals(3, attempts.get());
    }

    @Test
    public void testNonRetryableErrorStopsImmediately() {
        LarkChannelOptions.RetryConfig retry = new LarkChannelOptions.RetryConfig();
        retry.setMaxAttempts(3);
        retry.setBaseDelayMs(0L);
        final AtomicInteger attempts = new AtomicInteger();

        try {
            OutboundRetry.retry(attempt -> {
                attempts.incrementAndGet();
                throw new LarkChannelException(LarkChannelErrorCode.FORMAT_ERROR, "bad post");
            }, retry);
            Assert.fail("expected format error");
        } catch (LarkChannelException e) {
            Assert.assertEquals(LarkChannelErrorCode.FORMAT_ERROR.getValue(), e.getCode());
        }

        Assert.assertEquals(1, attempts.get());
    }

    @Test
    public void testMaxAttemptsExhaustionThrowsLastClassifiedError() {
        LarkChannelOptions.RetryConfig retry = new LarkChannelOptions.RetryConfig();
        retry.setMaxAttempts(2);
        retry.setBaseDelayMs(0L);
        final AtomicInteger attempts = new AtomicInteger();

        try {
            OutboundRetry.retry(attempt -> {
                attempts.incrementAndGet();
                throw new RuntimeException("429 too many requests");
            }, retry);
            Assert.fail("expected rate limited");
        } catch (LarkChannelException e) {
            Assert.assertEquals(LarkChannelErrorCode.RATE_LIMITED.getValue(), e.getCode());
            Assert.assertTrue(e.getCause() instanceof RuntimeException);
        }

        Assert.assertEquals(2, attempts.get());
    }

    @Test
    public void testAttemptNumberIncreases() {
        LarkChannelOptions.RetryConfig retry = new LarkChannelOptions.RetryConfig();
        retry.setMaxAttempts(3);
        retry.setBaseDelayMs(0L);
        final List<Integer> attempts = new ArrayList<Integer>();

        OutboundRetry.retry(attempt -> {
            attempts.add(attempt);
            if (attempt < 2) {
                throw new LarkChannelException(LarkChannelErrorCode.UNKNOWN, "temporary");
            }
            return "ok";
        }, retry);

        Assert.assertEquals(Arrays.asList(1, 2), attempts);
    }
}
