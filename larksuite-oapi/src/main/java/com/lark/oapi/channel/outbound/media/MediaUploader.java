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
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class MediaUploader {
    private static final long MAX_URL_BYTES = 50L * 1024L * 1024L;
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
                return uploadFile(materialized, "opus", chooseName(fileName, "voice.opus"),
                        resolveDuration(kind, materialized, durationMs), "audio");
            }
            if ("video".equals(kind)) {
                return uploadFile(materialized, "mp4", chooseName(fileName, "video.mp4"),
                        resolveDuration(kind, materialized, durationMs), "video");
            }
            return uploadFile(materialized, inferFileType(fileName), chooseName(fileName, "upload.bin"), null, "file");
        } finally {
            if (temporary && materialized != null) {
                deleteTemporary(materialized);
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
                List<Path> allowed = new ArrayList<>();
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
            return fetchPinned(url, 0);
        } catch (LarkChannelException e) {
            throw e;
        } catch (Exception e) {
            throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED, "fetch source URL failed", null, e);
        }
    }

    private byte[] fetchPinned(URL url, int redirects) throws Exception {
        if (redirects > 5) {
            throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED, "too many redirects while fetching URL");
        }
        SsrfGuard.Validation validation = validateUrl(url);
        int port = url.getPort() >= 0 ? url.getPort() : url.getDefaultPort();
        Socket socket = openSocket(url, validation.getResolvedAddress(), validation.getOriginalHost(), port);
        try {
            socket.setSoTimeout(15000);
            OutputStream output = socket.getOutputStream();
            output.write(buildGetRequest(url, validation.getOriginalHost()).getBytes("ISO-8859-1"));
            output.flush();
            InputStream input = socket.getInputStream();
            int status = parseStatus(readLine(input));
            Headers headers = readHeaders(input);
            String location = headers.get("location");
            if (status >= 300 && status < 400 && location != null && !location.isEmpty()) {
                socket.close();
                return fetchPinned(new URL(url, location), redirects + 1);
            }
            if ("chunked".equalsIgnoreCase(headers.get("transfer-encoding"))) {
                return readChunked(input, MAX_URL_BYTES);
            }
            return readAll(input, MAX_URL_BYTES);
        } finally {
            socket.close();
        }
    }

    private SsrfGuard.Validation validateUrl(URL url) throws Exception {
        if (config != null && !config.isSsrfGuardEnabled()) {
            String host = stripBrackets(url.getHost());
            InetAddress[] addresses = InetAddress.getAllByName(host);
            if (addresses.length == 0) {
                throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED,
                        "URL host has no DNS records: " + host);
            }
            return new SsrfGuard.Validation(host, addresses[0]);
        }
        List<String> allowlist = config == null ? null : config.getSsrfAllowlist();
        return SsrfGuard.assertPublicUrl(url, allowlist);
    }

    private Socket openSocket(URL url, InetAddress address, String originalHost, int port) throws Exception {
        Socket raw = new Socket();
        raw.connect(new InetSocketAddress(address, port), 15000);
        if (!"https".equalsIgnoreCase(url.getProtocol())) {
            return raw;
        }
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket ssl = (SSLSocket) factory.createSocket(raw, originalHost, port, true);
        ssl.startHandshake();
        SSLSession session = ssl.getSession();
        if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(originalHost, session)) {
            throw new LarkChannelException(LarkChannelErrorCode.SSRF_BLOCKED,
                    "URL blocked: TLS hostname verification failed for " + originalHost);
        }
        return ssl;
    }

    private String buildGetRequest(URL url, String originalHost) {
        String path = url.getFile();
        if (path == null || path.isEmpty()) {
            path = "/";
        }
        return "GET " + path + " HTTP/1.1\r\n"
                + "Host: " + hostHeader(url, originalHost) + "\r\n"
                + "User-Agent: larksuite-oapi-java-channel\r\n"
                + "Connection: close\r\n"
                + "\r\n";
    }

    private String hostHeader(URL url, String originalHost) {
        String host = originalHost.indexOf(':') >= 0 ? "[" + originalHost + "]" : originalHost;
        int port = url.getPort();
        if (port < 0 || port == url.getDefaultPort()) {
            return host;
        }
        return host + ":" + port;
    }

    private String stripBrackets(String host) {
        if (host != null && host.startsWith("[") && host.endsWith("]")) {
            return host.substring(1, host.length() - 1);
        }
        return host;
    }

    private int parseStatus(String statusLine) {
        if (statusLine == null || !statusLine.startsWith("HTTP/")) {
            throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED,
                    "invalid HTTP response while fetching URL");
        }
        String[] parts = statusLine.split(" ", 3);
        if (parts.length < 2) {
            throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED,
                    "invalid HTTP status while fetching URL");
        }
        return Integer.parseInt(parts[1]);
    }

    private Headers readHeaders(InputStream input) throws Exception {
        Headers headers = new Headers();
        String line;
        while ((line = readLine(input)) != null && !line.isEmpty()) {
            int index = line.indexOf(':');
            if (index > 0) {
                headers.add(line.substring(0, index).trim(), line.substring(index + 1).trim());
            }
        }
        return headers;
    }

    private String readLine(InputStream input) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int ch;
        while ((ch = input.read()) >= 0) {
            if (ch == '\n') {
                break;
            }
            if (ch != '\r') {
                output.write(ch);
            }
        }
        if (ch < 0 && output.size() == 0) {
            return null;
        }
        return output.toString("ISO-8859-1");
    }

    private File writeTemp(byte[] data, String fileName) {
        try {
            String suffix = suffix(fileName);
            File temp = File.createTempFile("channel-upload-", suffix);
            try (FileOutputStream output = new FileOutputStream(temp)) {
                output.write(data);
            }
            return temp;
        } catch (Exception e) {
            throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED, "failed to materialize upload source", null, e);
        }
    }

    private byte[] readAll(InputStream input) {
        return readAll(input, -1L);
    }

    private byte[] readAll(InputStream input, long maxBytes) {
        try {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            long total = 0L;
            int read;
            while ((read = input.read(buffer)) >= 0) {
                total += read;
                if (maxBytes > 0L && total > maxBytes) {
                    throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED,
                            "source URL exceeds max size: " + maxBytes + " bytes");
                }
                output.write(buffer, 0, read);
            }
            return output.toByteArray();
        } catch (LarkChannelException e) {
            throw e;
        } catch (Exception e) {
            throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED, "failed to read upload source", null, e);
        }
    }

    private byte[] readChunked(InputStream input, long maxBytes) {
        try {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            long total = 0L;
            while (true) {
                String sizeLine = readLine(input);
                if (sizeLine == null) {
                    throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED,
                            "unexpected EOF in chunked response");
                }
                int semicolon = sizeLine.indexOf(';');
                String sizeText = semicolon >= 0 ? sizeLine.substring(0, semicolon) : sizeLine;
                int size = Integer.parseInt(sizeText.trim(), 16);
                if (size == 0) {
                    while (true) {
                        String trailer = readLine(input);
                        if (trailer == null || trailer.isEmpty()) {
                            break;
                        }
                    }
                    return output.toByteArray();
                }
                total += size;
                if (maxBytes > 0L && total > maxBytes) {
                    throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED,
                            "source URL exceeds max size: " + maxBytes + " bytes");
                }
                readExactly(input, output, size);
                readLine(input);
            }
        } catch (LarkChannelException e) {
            throw e;
        } catch (Exception e) {
            throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED,
                    "failed to read chunked upload source", null, e);
        }
    }

    private void readExactly(InputStream input, ByteArrayOutputStream output, int size) throws Exception {
        byte[] buffer = new byte[4096];
        int remaining = size;
        while (remaining > 0) {
            int read = input.read(buffer, 0, Math.min(buffer.length, remaining));
            if (read < 0) {
                throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED,
                        "unexpected EOF in chunked response");
            }
            output.write(buffer, 0, read);
            remaining -= read;
        }
    }

    private Integer resolveDuration(String kind, File file, Integer explicitDurationMs) {
        if (explicitDurationMs != null && explicitDurationMs.intValue() > 0) {
            return explicitDurationMs;
        }
        try {
            byte[] data = Files.readAllBytes(file.toPath());
            Integer parsed = "audio".equals(kind)
                    ? MediaDurationParser.parseOpusDurationMs(data)
                    : MediaDurationParser.parseMp4DurationMs(data);
            if (parsed != null) {
                return parsed;
            }
            throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED,
                    "duration could not be determined for " + kind + "; pass it explicitly");
        } catch (LarkChannelException e) {
            throw e;
        } catch (Exception e) {
            throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED,
                    "duration could not be determined for " + kind + "; pass it explicitly", null, e);
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

    private void deleteTemporary(File file) {
        if (!file.delete()) {
            file.deleteOnExit();
        }
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

    private static final class Headers {
        private final java.util.Map<String, String> values = new java.util.HashMap<String, String>();

        private void add(String name, String value) {
            values.put(name.toLowerCase(), value);
        }

        private String get(String name) {
            return values.get(name.toLowerCase());
        }
    }
}
