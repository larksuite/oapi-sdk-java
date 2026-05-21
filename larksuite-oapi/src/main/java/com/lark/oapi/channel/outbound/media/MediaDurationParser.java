package com.lark.oapi.channel.outbound.media;

final class MediaDurationParser {
    private MediaDurationParser() {
    }

    static Integer parseOpusDurationMs(byte[] data) {
        if (data == null || data.length < 27) {
            return null;
        }
        for (int i = data.length - 27; i >= 0; i--) {
            if (data[i] == 0x4f && data[i + 1] == 0x67 && data[i + 2] == 0x67 && data[i + 3] == 0x53) {
                long granule = readLongLe(data, i + 6);
                if (granule < 0L) {
                    return null;
                }
                return Integer.valueOf((int) Math.round(granule / 48.0d));
            }
        }
        return null;
    }

    static Integer parseMp4DurationMs(byte[] data) {
        if (data == null || data.length < 16) {
            return null;
        }
        Range moov = findBoxPayload(data, 0, data.length, "moov");
        if (moov == null) {
            return null;
        }
        Range mvhd = findBoxPayload(data, moov.start, moov.end, "mvhd");
        if (mvhd == null || mvhd.start + 4 > data.length) {
            return null;
        }

        int version = data[mvhd.start] & 0xff;
        int base = mvhd.start + 4;
        long timescale;
        long duration;
        if (version == 1) {
            if (base + 28 > data.length) {
                return null;
            }
            timescale = readUInt32Be(data, base + 16);
            duration = readLongBe(data, base + 20);
        } else {
            if (base + 16 > data.length) {
                return null;
            }
            timescale = readUInt32Be(data, base + 8);
            duration = readUInt32Be(data, base + 12);
        }
        if (timescale <= 0L || duration < 0L) {
            return null;
        }
        double ms = (duration * 1000.0d) / timescale;
        if (Double.isInfinite(ms) || Double.isNaN(ms) || ms > Integer.MAX_VALUE) {
            return null;
        }
        return Integer.valueOf((int) Math.round(ms));
    }

    private static Range findBoxPayload(byte[] data, int begin, int end, String name) {
        int pos = begin;
        while (pos + 8 <= end && pos + 8 <= data.length) {
            long size = readUInt32Be(data, pos);
            String type = new String(data, pos + 4, 4, java.nio.charset.StandardCharsets.US_ASCII);
            long boxEnd = size == 1L ? pos + readLongBe(data, pos + 8) : size == 0L ? end : pos + size;
            if (boxEnd <= pos || boxEnd > end || boxEnd > data.length) {
                return null;
            }
            if (name.equals(type)) {
                int payloadStart = size == 1L ? pos + 16 : pos + 8;
                if (payloadStart > boxEnd) {
                    return null;
                }
                return new Range(payloadStart, (int) boxEnd);
            }
            pos = (int) boxEnd;
        }
        return null;
    }

    private static long readUInt32Be(byte[] data, int offset) {
        return ((long) data[offset] & 0xffL) << 24
                | ((long) data[offset + 1] & 0xffL) << 16
                | ((long) data[offset + 2] & 0xffL) << 8
                | ((long) data[offset + 3] & 0xffL);
    }

    private static long readLongBe(byte[] data, int offset) {
        long value = 0L;
        for (int i = 0; i < 8; i++) {
            value = (value << 8) | ((long) data[offset + i] & 0xffL);
        }
        return value;
    }

    private static long readLongLe(byte[] data, int offset) {
        long value = 0L;
        for (int i = 7; i >= 0; i--) {
            value = (value << 8) | ((long) data[offset + i] & 0xffL);
        }
        return value;
    }

    private static final class Range {
        private final int start;
        private final int end;

        private Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
