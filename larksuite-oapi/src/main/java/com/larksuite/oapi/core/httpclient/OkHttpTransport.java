package com.larksuite.oapi.core.httpclient;

import com.larksuite.oapi.core.Constants;
import com.larksuite.oapi.core.request.FormData;
import com.larksuite.oapi.core.request.FormDataFile;
import com.larksuite.oapi.core.request.RawRequest;
import com.larksuite.oapi.core.response.RawResponse;
import com.larksuite.oapi.core.utils.IOs;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.core.utils.Strings;
import com.larksuite.oapi.okhttp3_14.*;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class OkHttpTransport implements IHttpTransport {
    private OkHttpClient okHttpClient;

    public OkHttpTransport(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    private RequestBody buildReqBody(RawRequest request) {
        if (request == null || request.getBody() == null) {
            return null;
        }

        Object body = request.getBody();
        if (body instanceof FormData) {
            String contentType = "multipart/form-data;charset=" + StandardCharsets.UTF_8;
            MultipartBody.Builder builder = new MultipartBody.Builder()
                    .setType(MediaType.parse(contentType));

            for (Map.Entry<String, Object> entry : ((FormData) body).getParams().entrySet()) {
                builder.addFormDataPart(entry.getKey(), (String) entry.getValue());
            }

            for (FormDataFile file : ((FormData) body).getFiles()) {
                final File finalFile = file.getFile();
                builder.addFormDataPart(file.getFieldName(),
                        Strings.isEmpty(file.getFileName()) ? "unknown" : file.getFileName()
                        , RequestBody.create(MediaType.parse("application/octet-stream"), finalFile));
            }

            return builder.build();
        }

        return RequestBody.create(MediaType.parse(Constants.DEFAULT_CONTENT_TYPE)
                , Jsons.LONG_TO_STR_GSON.toJson(body).getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public RawResponse execute(RawRequest request) throws Exception {
        // 转换为okhttp的request
        RequestBody body = buildReqBody(request);
        com.larksuite.oapi.okhttp3_14.Request.Builder builder = new com.larksuite.oapi.okhttp3_14.Request.Builder().url(request.getReqUrl()).method(request.getHttpMethod(), body);

        // 设置请求header
        for (Map.Entry<String, List<String>> entry : request.getHeaders().entrySet()) {
            for (String value : entry.getValue()) {
                builder.header(entry.getKey(), value);
            }
        }

        // 执行请求
        Response response = okHttpClient.newCall(builder.build()).execute();

        // 转换结果为通用结果
        RawResponse rawResponse = new RawResponse();
        rawResponse.setStatusCode(response.code());
        rawResponse.setHeaders(response.headers().toMultimap());
        if (request.isSupportDownLoad()) {
            rawResponse.setBody(Objects.requireNonNull(IOs.readAll(response.body().byteStream())));
        } else {
            rawResponse.setBody(Objects.requireNonNull(response.body()).bytes());

        }
        return rawResponse;

    }
}
