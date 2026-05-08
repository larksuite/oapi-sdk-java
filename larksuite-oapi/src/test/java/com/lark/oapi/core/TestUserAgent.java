package com.lark.oapi.core;

import org.junit.Assert;
import org.junit.Test;

public class TestUserAgent {
    @Test
    public void testBuildReturnsBaseWhenSourceMissing() {
        Assert.assertEquals("oapi-sdk-java/v2.0.0", UserAgent.build(null));
        Assert.assertEquals("oapi-sdk-java/v2.0.0", UserAgent.build(""));
    }

    @Test
    public void testBuildAppendsSanitizedSourceToken() {
        Assert.assertEquals("oapi-sdk-java/v2.0.0 source/cursor-bot", UserAgent.build("cursor bot"));
        Assert.assertEquals("oapi-sdk-java/v2.0.0 source/a.b_c-1", UserAgent.build("a.b_c-1"));
    }

    @Test
    public void testBuildReturnsBaseWhenSourceHasNoValidTokenChars() {
        Assert.assertEquals("oapi-sdk-java/v2.0.0", UserAgent.build("!!!"));
    }
}
