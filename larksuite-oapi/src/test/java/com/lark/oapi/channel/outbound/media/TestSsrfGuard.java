package com.lark.oapi.channel.outbound.media;

import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;

import java.net.InetAddress;

import org.junit.Assert;
import org.junit.Test;

public class TestSsrfGuard {
    @Test
    public void testAllowsPublicAddresses() throws Exception {
        SsrfGuard.assertAllowed(InetAddress.getByName("8.8.8.8"));
        SsrfGuard.assertAllowed(InetAddress.getByName("1.1.1.1"));
        SsrfGuard.assertAllowed(InetAddress.getByName("2001:4860:4860::8888"));
    }

    @Test
    public void testBlocksIpv4ReservedRanges() throws Exception {
        assertBlocked("0.0.0.0");
        assertBlocked("10.0.0.1");
        assertBlocked("100.64.0.1");
        assertBlocked("127.0.0.1");
        assertBlocked("169.254.1.1");
        assertBlocked("172.16.0.1");
        assertBlocked("192.0.2.1");
        assertBlocked("192.168.0.1");
        assertBlocked("198.18.0.1");
        assertBlocked("198.51.100.1");
        assertBlocked("203.0.113.1");
        assertBlocked("224.0.0.1");
        assertBlocked("240.0.0.1");
        assertBlocked("255.255.255.255");
    }

    @Test
    public void testBlocksIpv6ReservedRanges() throws Exception {
        assertBlocked("::");
        assertBlocked("::1");
        assertBlocked("64:ff9b:1::1");
        assertBlocked("100::1");
        assertBlocked("2001::1");
        assertBlocked("2001:2::1");
        assertBlocked("2001:db8::1");
        assertBlocked("2002::1");
        assertBlocked("fc00::1");
        assertBlocked("fe80::1");
        assertBlocked("ff00::1");
    }

    @Test
    public void testIpv4EmbeddedIpv6DelegatesToEmbeddedAddress() throws Exception {
        assertBlocked("::ffff:127.0.0.1");
        assertBlocked("::7f00:1");
        assertBlocked("64:ff9b::a00:1");
        SsrfGuard.assertAllowed(InetAddress.getByName("64:ff9b::808:808"));
    }

    @Test
    public void testAllowlistedHostStillReturnsPinnedAddress() throws Exception {
        SsrfGuard.Validation validation = SsrfGuard.assertPublicUrl(
                new java.net.URL("http://127.0.0.1/resource"),
                java.util.Collections.singletonList("127.0.0.1"));

        Assert.assertEquals("127.0.0.1", validation.getOriginalHost());
        Assert.assertEquals(InetAddress.getByName("127.0.0.1"), validation.getResolvedAddress());
    }

    private void assertBlocked(String address) throws Exception {
        try {
            SsrfGuard.assertAllowed(InetAddress.getByName(address));
            Assert.fail("expected ssrf block for " + address);
        } catch (LarkChannelException e) {
            Assert.assertEquals(LarkChannelErrorCode.SSRF_BLOCKED.getValue(), e.getCode());
        }
    }
}
