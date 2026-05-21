package com.lark.oapi.channel.outbound;

import org.junit.Assert;
import org.junit.Test;

public class TestOutboundRouting {
    @Test
    public void testDetectReceiveIdType() {
        Assert.assertEquals(OutboundRouting.ReceiveIdType.CHAT_ID, OutboundRouting.detectReceiveIdType("oc_abcdef"));
        Assert.assertEquals(OutboundRouting.ReceiveIdType.OPEN_ID, OutboundRouting.detectReceiveIdType("ou_12345"));
        Assert.assertEquals(OutboundRouting.ReceiveIdType.UNION_ID, OutboundRouting.detectReceiveIdType("on_xyz"));
        Assert.assertEquals(OutboundRouting.ReceiveIdType.EMAIL, OutboundRouting.detectReceiveIdType("alice@example.com"));
        Assert.assertEquals(OutboundRouting.ReceiveIdType.USER_ID, OutboundRouting.detectReceiveIdType("u_plain123"));
    }

    @Test(expected = RuntimeException.class)
    public void testDetectReceiveIdTypeRejectsEmpty() {
        OutboundRouting.detectReceiveIdType("");
    }
}
