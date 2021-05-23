package com.larksuite.oapi.core.api.handler.subhandler;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Constants;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.api.handler.SubHandler;
import com.larksuite.oapi.core.api.request.FormData;
import com.larksuite.oapi.core.api.request.FormDataFile;
import com.larksuite.oapi.core.api.request.Request;
import com.larksuite.oapi.core.utils.Strings;
import com.larksuite.oapi.okhttp3_14.MediaType;
import com.larksuite.oapi.okhttp3_14.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Set;

import static com.larksuite.oapi.core.Constants.DEFAULT_CONTENT_TYPE;

public class BuildSubHandler implements SubHandler {

    private static final String DEFAULT_FILE_MIME_TYPE = "application/octet-stream";
    private static final Logger log = LoggerFactory.getLogger(BuildSubHandler.class);

    private String getTextEntry(String fieldName, Object fieldValue) {
        StringBuilder entry = new StringBuilder();
        entry.append("Content-Disposition: form-data; name=\"");
        entry.append(fieldName);
        entry.append("\"\r\n\r\n");
        entry.append(fieldValue.toString());
        return entry.toString();
    }

    private String getFileEntry(String fieldName, String fileName, String mimeType) {
        StringBuilder entry = new StringBuilder();
        entry.append("Content-Disposition: form-data; name=\"");
        entry.append(fieldName);
        entry.append("\"; filename=\"");
        entry.append(Strings.isEmpty(fileName) ? "unknown" : fileName);
        entry.append("\"\r\nContent-Type: ");
        if (Strings.isEmpty(mimeType)) {
            mimeType = DEFAULT_FILE_MIME_TYPE;
        }
        entry.append(mimeType);
        entry.append("\r\n\r\n");
        return entry.toString();
    }

    private void saveFormData(Request req, FormData formData, String boundary) throws IOException {
        File temp = File.createTempFile("larksuiteoapisdk-", ".tmp");
        try (FileOutputStream out = new FileOutputStream(temp)) {
            byte[] firstEntryBoundaryBytes = ("--" + boundary + "\r\n").getBytes(StandardCharsets.UTF_8);
            byte[] entryBoundaryBytes = ("\r\n--" + boundary + "\r\n").getBytes(StandardCharsets.UTF_8);
            Set<Map.Entry<String, Object>> textEntrySet = formData.getParams().entrySet();
            int i = 0;
            for (Map.Entry<String, Object> entry : textEntrySet) {
                String textEntry = getTextEntry(entry.getKey(), entry.getValue());
                if (i == 0) {
                    out.write(firstEntryBoundaryBytes);
                } else {
                    out.write(entryBoundaryBytes);
                }
                out.write(textEntry.getBytes(StandardCharsets.UTF_8));
                i++;
            }
            for (FormDataFile file : formData.getFiles()) {
                String fileEntry = getFileEntry(file.getFieldName(), file.getName(), file.getType());
                if (i == 0) {
                    out.write(firstEntryBoundaryBytes);
                } else {
                    out.write(entryBoundaryBytes);
                }
                out.write(fileEntry.getBytes(StandardCharsets.UTF_8));
                file.write(out);
                i++;
            }
            byte[] endBoundaryBytes = ("\r\n--" + boundary + "--\r\n").getBytes(StandardCharsets.UTF_8);
            out.write(endBoundaryBytes);
        }
        req.setRequestBodyFilePath(temp.getAbsolutePath());
    }

    @Override
    public <I, O> void handle(Context ctx, Request<I, O> req) throws Exception {
        Config conf = Config.ByCtx(ctx);
        if (!req.isRetry()) {
            if (req.getInput() != null) {
                if (req.getInput() instanceof FormData) {
                    String boundary = String.valueOf(System.nanoTime());
                    req.setContentType("multipart/form-data;charset=" + StandardCharsets.UTF_8 + ";boundary=" + boundary);
                    saveFormData(req, (FormData) req.getInput(), boundary);
                    log.debug("[build]request:{}, body:formdata:{}", req.toString(), req.getRequestBodyFilePath());
                } else {
                    req.setContentType(DEFAULT_CONTENT_TYPE);
                    String body = req.getGson().toJson(req.getInput());
                    req.setRequestBody(body.getBytes(StandardCharsets.UTF_8));
                    log.debug("[build]request:{}, body:{}", req.toString(), body);
                }
            }
        }
        RequestBody body = null;
        if (req.getRequestBody() != null) {
            body = RequestBody.create(MediaType.parse(req.getContentType()), req.getRequestBody());
        }
        if (req.getRequestBodyFilePath() != null) {
            body = RequestBody.create(MediaType.parse(req.getContentType()), new File(req.getRequestBodyFilePath()));
        }
        com.larksuite.oapi.okhttp3_14.Request.Builder builder = new com.larksuite.oapi.okhttp3_14.Request.Builder().url(req.url()).method(req.getHttpMethod(), body);
        builder.header("User-Agent", "oapi-sdk-java/" + Constants.VERSION);
        req.setHttpRequestBuilder(builder);
    }
}
