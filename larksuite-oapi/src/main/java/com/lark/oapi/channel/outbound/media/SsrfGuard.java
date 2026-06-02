package com.lark.oapi.channel.outbound.media;

import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URL;
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

    static Validation assertPublicUrl(URL url, List<String> allowlist) {
        String protocol = url.getProtocol();
        if (!"http".equalsIgnoreCase(protocol) && !"https".equalsIgnoreCase(protocol)) {
            throw new LarkChannelException(LarkChannelErrorCode.SSRF_BLOCKED,
                    "URL blocked: protocol " + protocol);
        }
        String host = normalizeHost(url.getHost());
        if (host == null || host.isEmpty()) {
            throw new LarkChannelException(LarkChannelErrorCode.SSRF_BLOCKED, "URL blocked: empty host");
        }
        boolean allowlisted = allowlist != null && allowlist.contains(host);
        try {
            InetAddress[] addresses = InetAddress.getAllByName(host);
            if (addresses.length == 0) {
                throw new LarkChannelException(LarkChannelErrorCode.SSRF_BLOCKED,
                        "URL blocked: no DNS records for " + host);
            }
            if (!allowlisted) {
                for (InetAddress address : addresses) {
                    assertAllowed(address);
                }
            }
            return new Validation(host, addresses[0]);
        } catch (LarkChannelException e) {
            throw e;
        } catch (Exception e) {
            throw new LarkChannelException(LarkChannelErrorCode.SSRF_BLOCKED,
                    "URL blocked: " + e.getMessage(), null, e);
        }
    }

    static void assertAllowed(InetAddress address) {
        byte[] embeddedIpv4 = embeddedIpv4(address);
        if (embeddedIpv4 != null) {
            assertAllowed(toInetAddress(embeddedIpv4));
            return;
        }
        for (Cidr cidr : BLOCKED_CIDRS) {
            if (cidr.contains(address)) {
                throw new LarkChannelException(LarkChannelErrorCode.SSRF_BLOCKED,
                        "URL blocked: non-public address " + address.getHostAddress());
            }
        }
    }

    private static String normalizeHost(String host) {
        if (host != null && host.startsWith("[") && host.endsWith("]")) {
            return host.substring(1, host.length() - 1);
        }
        return host;
    }

    private static InetAddress toInetAddress(byte[] bytes) {
        try {
            return InetAddress.getByAddress(bytes);
        } catch (UnknownHostException e) {
            throw new IllegalStateException(e);
        }
    }

    private static byte[] embeddedIpv4(InetAddress address) {
        byte[] bytes = address.getAddress();
        if (bytes.length != 16) {
            return null;
        }
        if (matchesPrefix(bytes, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0xff, 0xff}, 12)
                || matchesPrefix(bytes, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 12)
                || matchesPrefix(bytes, new int[]{0x00, 0x64, 0xff, 0x9b, 0, 0, 0, 0, 0, 0, 0, 0}, 12)) {
            return new byte[]{bytes[12], bytes[13], bytes[14], bytes[15]};
        }
        return null;
    }

    private static boolean matchesPrefix(byte[] bytes, int[] prefix, int length) {
        for (int i = 0; i < length; i++) {
            if ((bytes[i] & 0xff) != prefix[i]) {
                return false;
            }
        }
        return true;
    }

    private static Cidr cidr(String address, int prefixLength) {
        try {
            return new Cidr(InetAddress.getByName(address), prefixLength);
        } catch (UnknownHostException e) {
            throw new IllegalStateException(e);
        }
    }

    static final class Validation {
        private final String originalHost;
        private final InetAddress resolvedAddress;

        Validation(String originalHost, InetAddress resolvedAddress) {
            this.originalHost = originalHost;
            this.resolvedAddress = resolvedAddress;
        }

        String getOriginalHost() {
            return originalHost;
        }

        InetAddress getResolvedAddress() {
            return resolvedAddress;
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

        private static byte[] normalize(InetAddress address) {
            byte[] bytes = address.getAddress();
            if (bytes.length == 4) {
                return bytes;
            }
            return bytes;
        }

        private boolean contains(InetAddress address) {
            byte[] bytes = normalize(address);
            return bytes.length * 8 == length && new BigInteger(1, bytes).and(mask).equals(network);
        }
    }
}
