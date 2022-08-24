/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lark.oapi.core.httpclient;

import com.lark.oapi.core.Constants;
import com.lark.oapi.core.request.FormData;
import com.lark.oapi.core.request.FormDataFile;
import com.lark.oapi.core.request.RawRequest;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.utils.IOs;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.okhttp.MediaType;
import com.lark.oapi.okhttp.MultipartBody;
import com.lark.oapi.okhttp.OkHttpClient;
import com.lark.oapi.okhttp.Request;
import com.lark.oapi.okhttp.RequestBody;
import com.lark.oapi.okhttp.Response;
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

    if (request.isSupportLong2String()) {
      return RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
          , Jsons.LONG_TO_STR.toJson(body).getBytes(StandardCharsets.UTF_8));
    } else {
      return RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
          , Jsons.DEFAULT.toJson(body).getBytes(StandardCharsets.UTF_8));
    }

  }

  @Override
  public RawResponse execute(RawRequest request) throws Exception {
    // 转换为okhttp的request
    RequestBody body = buildReqBody(request);
    Request.Builder builder = new Request.Builder().url(request.getReqUrl())
        .method(request.getHttpMethod(), body);

    // 设置请求header
    for (Map.Entry<String, List<String>> entry : request.getHeaders().entrySet()) {
      for (String value : entry.getValue()) {
        builder.header(entry.getKey(), value);
      }
    }

    if (!(request.getBody() instanceof FormData)) {
      builder.header("content-type", "application/json; charset=utf-8");
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
