package com.lark.oapi.channel.outbound.media;

import com.lark.oapi.Client;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;
import com.lark.oapi.service.im.v1.model.CreateFileReq;
import com.lark.oapi.service.im.v1.model.CreateFileReqBody;
import com.lark.oapi.service.im.v1.model.CreateFileResp;
import com.lark.oapi.service.im.v1.model.CreateImageReq;
import com.lark.oapi.service.im.v1.model.CreateImageReqBody;
import com.lark.oapi.service.im.v1.model.CreateImageResp;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MediaUploader {
    private static final List<String> POSIX_BLOCKED_PREFIXES =
            Arrays.asList("/etc/", "/proc/", "/sys/", "/dev/", "/private/etc/");

    private final Client client;
    private final LarkChannelOptions.OutboundConfig config;

    public MediaUploader(Client client, LarkChannelOptions.OutboundConfig config) {
        this.client = client;
        this.config = config;
    }

    public UploadResult upload(String kind, Object source, String fileName, Integer durationMs) {
        File materialized = null;
        boolean temporary = false;
        try {
            SourceFile resolved = toFile(source, fileName);
            materialized = resolved.file;
            temporary = resolved.temporary;
            if ("image".equals(kind)) {
                return uploadImage(materialized);
            }
            if ("audio".equals(kind)) {
                return uploadFile(materialized, "opus", chooseName(fileName, "voice.opus"), durationMs, "audio");
            }
            if ("video".equals(kind)) {
                return uploadFile(materialized, "mp4", chooseName(fileName, "video.mp4"), durationMs, "video");
            }
            return uploadFile(materialized, inferFileType(fileName), chooseName(fileName, "upload.bin"), null, "file");
        } finally {
            if (temporary && materialized != null) {
                materialized.delete();
            }
        }
    }

    private UploadResult uploadImage(File file) {
        try {
            CreateImageResp response = client.im().image().create(CreateImageReq.newBuilder()
                    .createImageReqBody(CreateImageReqBody.newBuilder()
                            .imageType("message")
                            .image(file)
                            .build())
                    .build());
            String key = response != null && response.getData() != null ? response.getData().getImageKey() : null;
            if (key == null || key.isEmpty()) {
                throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED, "image_key missing in upload response");
            }
            return new UploadResult("image", key, null);
        } catch (Exception e) {
            throw wrap("image upload failed", e);
        }
    }

    private UploadResult uploadFile(File file, String fileType, String fileName, Integer durationMs, String kind) {
        try {
            CreateFileReqBody.Builder body = CreateFileReqBody.newBuilder()
                    .fileType(fileType)
                    .fileName(fileName)
                    .file(file);
            if (durationMs != null) {
                body.duration(durationMs);
            }
            CreateFileResp response = client.im().file().create(CreateFileReq.newBuilder()
                    .createFileReqBody(body.build())
                    .build());
            String key = response != null && response.getData() != null ? response.getData().getFileKey() : null;
            if (key == null || key.isEmpty()) {
                throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED, "file_key missing in upload response");
            }
            return new UploadResult(kind, key, durationMs);
        } catch (Exception e) {
            throw wrap("file upload failed", e);
        }
    }

    private SourceFile toFile(Object source, String fileName) {
        if (source instanceof File) {
            File file = ((File) source).getAbsoluteFile();
            validateLocalFile(file.toPath());
            return new SourceFile(file, false);
        }
        if (source instanceof byte[]) {
            return new SourceFile(writeTemp((byte[]) source, fileName), true);
        }
        if (source instanceof InputStream) {
            return new SourceFile(writeTemp(readAll((InputStream) source), fileName), true);
        }
        if (!(source instanceof String)) {
            throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED, "unsupported media source type");
        }
        String value = (String) source;
        if (value.matches("^https?://.*")) {
            return new SourceFile(writeTemp(fetchUrl(value), fileName), true);
        }
        Path resolved = Paths.get(value).toAbsolutePath().normalize();
        validateLocalFile(resolved);
        return new SourceFile(resolved.toFile(), false);
    }

    private void validateLocalFile(Path path) {
        assertNotBlocked(path);
        try {
            Path realPath = path.toRealPath();
            assertNotBlocked(realPath);
            if (config != null && config.getAllowedFileDirs() != null && !config.getAllowedFileDirs().isEmpty()) {
                List<Path> allowed = new ArrayList<Path>();
                for (String dir : config.getAllowedFileDirs()) {
                    Path resolved = Paths.get(dir).toAbsolutePath().normalize();
                    try {
                        allowed.add(resolved.toRealPath());
                    } catch (Exception ignored) {
                        allowed.add(resolved);
                    }
                }
                boolean inAllowed = false;
                for (Path dir : allowed) {
                    if (realPath.equals(dir) || realPath.startsWith(dir)) {
                        inAllowed = true;
                        break;
                    }
                }
                if (!inAllowed) {
                    throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED,
                            "file path is outside allowed directories: " + realPath);
                }
            }
            if (!Files.isRegularFile(realPath) || !Files.isReadable(realPath)) {
                throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED,
                        "source is neither an http(s) URL nor a readable local file: " + path);
            }
        } catch (LarkChannelException e) {
            throw e;
        } catch (Exception e) {
            throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED,
                    "source is neither an http(s) URL nor a readable local file: " + path, null, e);
        }
    }

    private void assertNotBlocked(Path path) {
        String normalized = path.toString().replace('\\', '/');
        if (File.separatorChar == '\\') {
            return;
        }
        for (String prefix : POSIX_BLOCKED_PREFIXES) {
            String exact = prefix.substring(0, prefix.length() - 1);
            if (normalized.equals(exact) || normalized.startsWith(prefix)) {
                throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED,
                        "file path is not allowed: " + normalized);
            }
        }
    }

    private byte[] fetchUrl(String source) {
        try {
            URL url = new URL(source);
            assertPublicHost(url.getHost());
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(15000);
            return readAll(connection.getInputStream());
        } catch (LarkChannelException e) {
            throw e;
        } catch (Exception e) {
            throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED, "fetch source URL failed", null, e);
        }
    }

    private void assertPublicHost(String host) throws Exception {
        if (config != null && !config.isSsrfGuardEnabled()) {
            return;
        }
        if (host == null || host.isEmpty()) {
            throw new LarkChannelException(LarkChannelErrorCode.SSRF_BLOCKED, "URL blocked: empty host");
        }
        if (config != null && config.getSsrfAllowlist() != null && config.getSsrfAllowlist().contains(host)) {
            return;
        }
        InetAddress[] addresses = InetAddress.getAllByName(host);
        for (InetAddress address : addresses) {
            if (address.isAnyLocalAddress() || address.isLoopbackAddress() || address.isLinkLocalAddress()
                    || address.isSiteLocalAddress() || address.isMulticastAddress()) {
                throw new LarkChannelException(LarkChannelErrorCode.SSRF_BLOCKED, "URL blocked: private address");
            }
        }
    }

    private File writeTemp(byte[] data, String fileName) {
        try {
            String suffix = suffix(fileName);
            File temp = File.createTempFile("channel-upload-", suffix);
            FileOutputStream output = new FileOutputStream(temp);
            try {
                output.write(data);
            } finally {
                output.close();
            }
            return temp;
        } catch (Exception e) {
            throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED, "failed to materialize upload source", null, e);
        }
    }

    private byte[] readAll(InputStream input) {
        try {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int read;
            while ((read = input.read(buffer)) >= 0) {
                output.write(buffer, 0, read);
            }
            return output.toByteArray();
        } catch (Exception e) {
            throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED, "failed to read upload source", null, e);
        }
    }

    private String inferFileType(String fileName) {
        String name = chooseName(fileName, "upload.bin").toLowerCase();
        if (name.endsWith(".pdf")) {
            return "pdf";
        }
        if (name.endsWith(".doc") || name.endsWith(".docx")) {
            return "doc";
        }
        if (name.endsWith(".xls") || name.endsWith(".xlsx")) {
            return "xls";
        }
        if (name.endsWith(".ppt") || name.endsWith(".pptx")) {
            return "ppt";
        }
        if (name.endsWith(".mp4")) {
            return "mp4";
        }
        if (name.endsWith(".opus")) {
            return "opus";
        }
        return "stream";
    }

    private String chooseName(String fileName, String fallback) {
        return fileName == null || fileName.isEmpty() ? fallback : fileName;
    }

    private String suffix(String fileName) {
        String chosen = chooseName(fileName, ".bin");
        int index = chosen.lastIndexOf('.');
        return index >= 0 ? chosen.substring(index) : ".bin";
    }

    private LarkChannelException wrap(String message, Exception e) {
        if (e instanceof LarkChannelException) {
            return (LarkChannelException) e;
        }
        return new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED, message, null, e);
    }

    private static final class SourceFile {
        private final File file;
        private final boolean temporary;

        private SourceFile(File file, boolean temporary) {
            this.file = file;
            this.temporary = temporary;
        }
    }
}
