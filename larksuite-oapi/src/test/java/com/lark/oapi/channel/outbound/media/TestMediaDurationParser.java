package com.lark.oapi.channel.outbound.media;

import org.junit.Assert;
import org.junit.Test;

public class TestMediaDurationParser {
    @Test
    public void testParseOpusDurationFromLastOggPage() {
        byte[] data = opusPage(48000L);

        Assert.assertEquals(Integer.valueOf(1000), MediaDurationParser.parseOpusDurationMs(data));
    }

    @Test
    public void testParseMp4VersionZeroDuration() {
        byte[] data = mp4(1000, 2500);

        Assert.assertEquals(Integer.valueOf(2500), MediaDurationParser.parseMp4DurationMs(data));
    }

    @Test
    public void testInvalidFilesReturnNull() {
        Assert.assertNull(MediaDurationParser.parseOpusDurationMs("not ogg".getBytes()));
        Assert.assertNull(MediaDurationParser.parseMp4DurationMs("not mp4".getBytes()));
    }

    static byte[] opusPage(long granule) {
        byte[] data = new byte[32];
        data[0] = 0x4f;
        data[1] = 0x67;
        data[2] = 0x67;
        data[3] = 0x53;
        for (int i = 0; i < 8; i++) {
            data[6 + i] = (byte) ((granule >> (8 * i)) & 0xff);
        }
        return data;
    }

    static byte[] mp4(long timescale, long duration) {
        byte[] mvhdPayload = new byte[20];
        mvhdPayload[0] = 0;
        writeUInt32(mvhdPayload, 12, timescale);
        writeUInt32(mvhdPayload, 16, duration);
        byte[] mvhd = box("mvhd", mvhdPayload);
        return box("moov", mvhd);
    }

    private static byte[] box(String type, byte[] payload) {
        byte[] data = new byte[8 + payload.length];
        writeUInt32(data, 0, data.length);
        byte[] name = type.getBytes(java.nio.charset.StandardCharsets.US_ASCII);
        System.arraycopy(name, 0, data, 4, 4);
        System.arraycopy(payload, 0, data, 8, payload.length);
        return data;
    }

    private static void writeUInt32(byte[] data, int offset, long value) {
        data[offset] = (byte) ((value >> 24) & 0xff);
        data[offset + 1] = (byte) ((value >> 16) & 0xff);
        data[offset + 2] = (byte) ((value >> 8) & 0xff);
        data[offset + 3] = (byte) (value & 0xff);
    }
}
