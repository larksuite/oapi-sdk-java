package com.lark.oapi.channel.outbound.media;

import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

final class SsrfGuard {
    private static final List<Cidr> BLOCKED_CIDRS = Arrays.asList(
            cidr("0.0.0.0", 8),
            cidr("10.0.0.0", 8),
            cidr("100.64.0.0", 10),
            cidr("127.0.0.0", 8),
            cidr("169.254.0.0", 16),
            cidr("172.16.0.0", 12),
            cidr("192.0.0.0", 24),
            cidr("192.0.2.0", 24),
            cidr("192.168.0.0", 16),
            cidr("198.18.0.0", 15),
            cidr("198.51.100.0", 24),
            cidr("203.0.113.0", 24),
            cidr("224.0.0.0", 4),
            cidr("240.0.0.0", 4),
            cidr("255.255.255.255", 32),
            cidr("::", 128),
            cidr("::1", 128),
            cidr("::ffff:0:0", 96),
            cidr("64:ff9b::", 96),
            cidr("64:ff9b:1::", 48),
            cidr("100::", 64),
            cidr("2001::", 32),
            cidr("2001:2::", 48),
            cidr("2001:db8::", 32),
            cidr("2002::", 16),
            cidr("fc00::", 7),
            cidr("fe80::", 10),
            cidr("ff00::", 8)
    );

    private SsrfGuard() {
    }

    static void assertAllowed(InetAddress address) {
        for (Cidr cidr : BLOCKED_CIDRS) {
            if (cidr.contains(address)) {
                throw new LarkChannelException(LarkChannelErrorCode.SSRF_BLOCKED,
                        "URL blocked: non-public address " + address.getHostAddress());
            }
        }
    }

    private static Cidr cidr(String address, int prefixLength) {
        try {
            return new Cidr(InetAddress.getByName(address), prefixLength);
        } catch (UnknownHostException e) {
            throw new IllegalStateException(e);
        }
    }

    private static final class Cidr {
        private final BigInteger network;
        private final BigInteger mask;
        private final int length;

        private Cidr(InetAddress address, int prefixLength) {
            byte[] bytes = normalize(address);
            this.length = bytes.length * 8;
            BigInteger allOnes = BigInteger.ONE.shiftLeft(length).subtract(BigInteger.ONE);
            this.mask = allOnes.shiftRight(length - prefixLength).shiftLeft(length - prefixLength);
            this.network = new BigInteger(1, bytes).and(mask);
        }

        private boolean contains(InetAddress address) {
            byte[] bytes = normalize(address);
            return bytes.length * 8 == length && new BigInteger(1, bytes).and(mask).equals(network);
        }

        private static byte[] normalize(InetAddress address) {
            byte[] bytes = address.getAddress();
            if (bytes.length == 4) {
                return bytes;
            }
            return bytes;
        }
    }
}
