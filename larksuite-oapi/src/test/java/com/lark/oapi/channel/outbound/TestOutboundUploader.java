package com.lark.oapi.channel.outbound;

import com.lark.oapi.Client;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;
import com.lark.oapi.channel.model.SendInput;
import java.io.File;
import java.io.FileOutputStream;
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

    private OutboundSender createSender(OutboundTestSupport.StubMessage message, OutboundTestSupport.StubImage image,
                                        OutboundTestSupport.StubFile file, LarkChannelOptions options) throws Exception {
        if (options == null) {
            options = OutboundTestSupport.options();
        }
        Client client = OutboundTestSupport.createClient(message, new OutboundTestSupport.StubMessageReaction(), image, file);
        return new OutboundSender(client, options);
    }
}
