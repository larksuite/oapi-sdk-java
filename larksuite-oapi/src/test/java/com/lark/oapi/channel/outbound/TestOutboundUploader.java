package com.lark.oapi.channel.outbound;

import com.lark.oapi.Client;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;
import com.lark.oapi.channel.model.SendInput;
import com.lark.oapi.channel.model.SendOptions;
import com.lark.oapi.service.im.v1.model.ReplyMessageResp;
import com.lark.oapi.service.im.v1.model.ReplyMessageRespBody;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ByteArrayInputStream;
import org.junit.Assert;
import org.junit.Test;

public class TestOutboundUploader {
    @Test
    public void testImageUploadFromBytes() throws Exception {
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        message.createResp = OutboundTestSupport.okCreate("om_image");
        OutboundTestSupport.StubImage image = new OutboundTestSupport.StubImage();
        image.createResp = OutboundTestSupport.okImage("img_v3_1");
        OutboundSender sender = createSender(message, image, new OutboundTestSupport.StubFile(), null);

        sender.send("oc_abc", SendInput.image("hello".getBytes("UTF-8")), null);

        Assert.assertNotNull(image.createReq);
        Assert.assertNotNull(image.createReq.getCreateImageReqBody().getImage());
        Assert.assertEquals("img_v3_1", image.createResp.getData().getImageKey());
        Assert.assertTrue(message.createReq.getCreateMessageReqBody().getContent().contains("img_v3_1"));
    }

    @Test
    public void testFileUploadFromLocalPath() throws Exception {
        File temp = File.createTempFile("channel-upload-test", ".pdf");
        FileOutputStream output = new FileOutputStream(temp);
        try {
            output.write("payload".getBytes("UTF-8"));
        } finally {
            output.close();
        }
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        message.createResp = OutboundTestSupport.okCreate("om_file");
        OutboundTestSupport.StubFile file = new OutboundTestSupport.StubFile();
        file.createResp = OutboundTestSupport.okFile("file_v3_1");
        OutboundSender sender = createSender(message, new OutboundTestSupport.StubImage(), file, null);

        sender.send("oc_abc", SendInput.file(temp.getAbsolutePath(), "spec.pdf"), null);

        Assert.assertNotNull(file.createReq);
        Assert.assertEquals("spec.pdf", file.createReq.getCreateFileReqBody().getFileName());
        Assert.assertTrue(message.createReq.getCreateMessageReqBody().getContent().contains("file_v3_1"));
        temp.delete();
    }

    @Test
    public void testImageUploadCanReplyToMessage() throws Exception {
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        ReplyMessageResp replyResp = new ReplyMessageResp();
        ReplyMessageRespBody body = new ReplyMessageRespBody();
        body.setMessageId("om_image_reply");
        replyResp.setData(body);
        message.replyResp = replyResp;
        OutboundTestSupport.StubImage image = new OutboundTestSupport.StubImage();
        image.createResp = OutboundTestSupport.okImage("img_reply");
        OutboundSender sender = createSender(message, image, new OutboundTestSupport.StubFile(), null);

        sender.send("oc_abc", SendInput.image("hello".getBytes("UTF-8")),
                SendOptions.newBuilder().replyTo("om_parent").build());

        Assert.assertNotNull(image.createReq);
        Assert.assertNotNull(message.replyReq);
        Assert.assertEquals("om_parent", message.replyReq.getMessageId());
        Assert.assertEquals("image", message.replyReq.getReplyMessageReqBody().getMsgType());
        Assert.assertTrue(message.replyReq.getReplyMessageReqBody().getContent().contains("img_reply"));
    }

    @Test
    public void testVideoSendsAsMediaMessageWithoutFileName() throws Exception {
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        message.createResp = OutboundTestSupport.okCreate("om_video");
        OutboundTestSupport.StubFile file = new OutboundTestSupport.StubFile();
        file.createResp = OutboundTestSupport.okFile("file_video");
        OutboundSender sender = createSender(message, new OutboundTestSupport.StubImage(), file, null);

        sender.send("oc_abc", SendInput.video("payload".getBytes("UTF-8"), 1200, "img_cover"), null);

        Assert.assertEquals("media", message.createReq.getCreateMessageReqBody().getMsgType());
        String content = message.createReq.getCreateMessageReqBody().getContent();
        Assert.assertTrue(content.contains("file_video"));
        Assert.assertTrue(content.contains("img_cover"));
        Assert.assertFalse(content.contains("file_name"));
    }

    @Test
    public void testAudioSendsOpusWithDuration() throws Exception {
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        message.createResp = OutboundTestSupport.okCreate("om_audio");
        OutboundTestSupport.StubFile file = new OutboundTestSupport.StubFile();
        file.createResp = OutboundTestSupport.okFile("file_audio");
        OutboundSender sender = createSender(message, new OutboundTestSupport.StubImage(), file, null);

        sender.send("oc_abc", SendInput.audio("voice".getBytes("UTF-8"), 2400), null);

        Assert.assertEquals("opus", file.createReq.getCreateFileReqBody().getFileType());
        Assert.assertEquals("voice.opus", file.createReq.getCreateFileReqBody().getFileName());
        Assert.assertEquals(Integer.valueOf(2400), file.createReq.getCreateFileReqBody().getDuration());
        Assert.assertEquals("audio", message.createReq.getCreateMessageReqBody().getMsgType());
        Assert.assertTrue(message.createReq.getCreateMessageReqBody().getContent().contains("file_audio"));
        Assert.assertTrue(message.createReq.getCreateMessageReqBody().getContent().contains("2400"));
    }

    @Test
    public void testImageUploadSupportsCommonLocalFormats() throws Exception {
        String[] suffixes = new String[] {".png", ".jpg", ".gif"};
        for (String suffix : suffixes) {
            File temp = writeTemp("channel-image-format", suffix, "image-bytes");
            OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
            message.createResp = OutboundTestSupport.okCreate("om_image_" + suffix.substring(1));
            OutboundTestSupport.StubImage image = new OutboundTestSupport.StubImage();
            image.createResp = OutboundTestSupport.okImage("img_" + suffix.substring(1));
            OutboundSender sender = createSender(message, image, new OutboundTestSupport.StubFile(), null);

            sender.send("oc_abc", SendInput.image(temp.getAbsolutePath()), null);

            Assert.assertNotNull(image.createReq.getCreateImageReqBody().getImage());
            Assert.assertEquals("image", message.createReq.getCreateMessageReqBody().getMsgType());
            Assert.assertTrue(message.createReq.getCreateMessageReqBody().getContent().contains("img_" + suffix.substring(1)));
            temp.delete();
        }
    }

    @Test
    public void testFileUploadInfersSupportedFileTypes() throws Exception {
        assertFileUploadType("report.pdf", "pdf");
        assertFileUploadType("doc.docx", "doc");
        assertFileUploadType("sheet.xlsx", "xls");
        assertFileUploadType("slides.pptx", "ppt");
        assertFileUploadType("archive.bin", "stream");
    }

    @Test
    public void testFileUploadFromInputStreamMaterializesName() throws Exception {
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        message.createResp = OutboundTestSupport.okCreate("om_stream_file");
        OutboundTestSupport.StubFile file = new OutboundTestSupport.StubFile();
        file.createResp = OutboundTestSupport.okFile("file_stream");
        OutboundSender sender = createSender(message, new OutboundTestSupport.StubImage(), file, null);

        sender.send("oc_abc", SendInput.file(new ByteArrayInputStream("payload".getBytes("UTF-8")), "stream.txt"), null);

        Assert.assertEquals("stream.txt", file.createReq.getCreateFileReqBody().getFileName());
        Assert.assertEquals("stream", file.createReq.getCreateFileReqBody().getFileType());
        Assert.assertTrue(message.createReq.getCreateMessageReqBody().getContent().contains("file_stream"));
    }

    @Test
    public void testBlockedLocalFilePathRejected() throws Exception {
        OutboundSender sender = createSender(new OutboundTestSupport.StubMessage(),
                new OutboundTestSupport.StubImage(), new OutboundTestSupport.StubFile(), null);

        try {
            sender.send("oc_abc", SendInput.image("/etc/passwd"), null);
            Assert.fail("expected upload_failed");
        } catch (LarkChannelException e) {
            Assert.assertEquals(LarkChannelErrorCode.UPLOAD_FAILED.getValue(), e.getCode());
        }
    }

    @Test
    public void testAllowedFileDirsRestrictScope() throws Exception {
        File allowed = new File(System.getProperty("java.io.tmpdir"), "channel-allowed-" + System.nanoTime());
        File outside = new File(System.getProperty("java.io.tmpdir"), "channel-outside-" + System.nanoTime());
        allowed.mkdirs();
        outside.mkdirs();
        File target = new File(outside, "blocked.bin");
        FileOutputStream output = new FileOutputStream(target);
        try {
            output.write(1);
        } finally {
            output.close();
        }
        LarkChannelOptions options = OutboundTestSupport.options();
        options.getOutbound().setAllowedFileDirs(java.util.Collections.singletonList(allowed.getAbsolutePath()));
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        OutboundTestSupport.StubImage image = new OutboundTestSupport.StubImage();
        image.createResp = OutboundTestSupport.okImage("img_v3_1");
        Client client = OutboundTestSupport.createClient(message, new OutboundTestSupport.StubMessageReaction(), image,
                new OutboundTestSupport.StubFile());
        OutboundSender sender = new OutboundSender(client, options);

        try {
            sender.send("oc_abc", SendInput.image(target.getAbsolutePath()), null);
            Assert.fail("expected upload_failed");
        } catch (LarkChannelException e) {
            Assert.assertEquals(LarkChannelErrorCode.UPLOAD_FAILED.getValue(), e.getCode());
        } finally {
            target.delete();
            allowed.delete();
            outside.delete();
        }
    }

    @Test
    public void testUrlSsrfGuardRejectsReservedRanges() throws Exception {
        OutboundSender sender = createSender(new OutboundTestSupport.StubMessage(),
                new OutboundTestSupport.StubImage(), new OutboundTestSupport.StubFile(), null);

        assertSsrfBlocked(sender, "http://127.0.0.1/payload.png");
        assertSsrfBlocked(sender, "http://100.64.0.1/payload.png");
        assertSsrfBlocked(sender, "http://[::1]/payload.png");
    }

    private void assertSsrfBlocked(OutboundSender sender, String url) {
        try {
            sender.send("oc_abc", SendInput.image(url), null);
            Assert.fail("expected ssrf_blocked");
        } catch (LarkChannelException e) {
            Assert.assertEquals(LarkChannelErrorCode.SSRF_BLOCKED.getValue(), e.getCode());
        }
    }

    private void assertFileUploadType(String fileName, String fileType) throws Exception {
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        message.createResp = OutboundTestSupport.okCreate("om_file_type");
        OutboundTestSupport.StubFile file = new OutboundTestSupport.StubFile();
        file.createResp = OutboundTestSupport.okFile("file_type");
        OutboundSender sender = createSender(message, new OutboundTestSupport.StubImage(), file, null);

        sender.send("oc_abc", SendInput.file("payload".getBytes("UTF-8"), fileName), null);

        Assert.assertEquals(fileName, file.createReq.getCreateFileReqBody().getFileName());
        Assert.assertEquals(fileType, file.createReq.getCreateFileReqBody().getFileType());
    }

    private File writeTemp(String prefix, String suffix, String content) throws Exception {
        File temp = File.createTempFile(prefix, suffix);
        FileOutputStream output = new FileOutputStream(temp);
        try {
            output.write(content.getBytes("UTF-8"));
        } finally {
            output.close();
        }
        return temp;
    }

    private OutboundSender createSender(OutboundTestSupport.StubMessage message, OutboundTestSupport.StubImage image,
                                        OutboundTestSupport.StubFile file, LarkChannelOptions options) throws Exception {
        if (options == null) {
            options = OutboundTestSupport.options();
        }
        Client client = OutboundTestSupport.createClient(message, new OutboundTestSupport.StubMessageReaction(), image, file);
        return new OutboundSender(client, options);
    }
}
