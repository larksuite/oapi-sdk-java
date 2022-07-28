// Code generated by lark suite oapi sdk gen
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

package com.lark.oapi.service.ehr.v1;

import com.lark.oapi.core.Config;
import com.lark.oapi.core.Transport;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.token.AccessTokenType;
import com.lark.oapi.core.utils.Sets;
import com.lark.oapi.core.utils.UnmarshalRespUtil;
import com.lark.oapi.service.ehr.v1.model.GetAttachmentReq;
import com.lark.oapi.service.ehr.v1.model.GetAttachmentResp;
import com.lark.oapi.service.ehr.v1.model.ListEmployeeReq;
import com.lark.oapi.service.ehr.v1.model.ListEmployeeResp;
import java.io.ByteArrayOutputStream;

public class EhrService {

  private final Attachment attachment;
  private final Employee employee;

  public EhrService(Config config) {
    this.attachment = new Attachment(config);
    this.employee = new Employee(config);
  }

  public Attachment attachment() {
    return attachment;
  }

  public Employee employee() {
    return employee;
  }

  public static class Attachment {

    private final Config config;

    public Attachment(Config config) {
      this.config = config;
    }

    public GetAttachmentResp get(GetAttachmentReq req, RequestOptions reqOptions) throws Exception {
      // 请求参数选项
      if (reqOptions == null) {
        reqOptions = new RequestOptions();
      }

      Boolean customSupportLong2Str = reqOptions.isSupportLong2String();
      reqOptions.setSupportLong2String(true);
      if (customSupportLong2Str != null) {
        reqOptions.setSupportLong2String(customSupportLong2Str);
      }
      reqOptions.setSupportDownLoad(true);

      // 发起请求
      RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
          , "/open-apis/ehr/v1/attachments/:token"
          , Sets.newHashSet(AccessTokenType.Tenant)
          , req);

      if (httpResponse.getStatusCode() == 200) {
        GetAttachmentResp resp = new GetAttachmentResp();
        resp.setRawResponse(httpResponse);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(httpResponse.getBody());
        resp.setData(outputStream);
        resp.setFileName(httpResponse.getFileName());
        return resp;
      }
      // 反序列化
      GetAttachmentResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse,
          GetAttachmentResp.class);
      resp.setRawResponse(httpResponse);
      resp.setRequest(req);

      return resp;
    }

    public GetAttachmentResp get(GetAttachmentReq req) throws Exception {
      // 请求参数选项
      RequestOptions reqOptions = new RequestOptions();
      reqOptions.setSupportLong2String(true);
      reqOptions.setSupportDownLoad(true);

      // 发起请求
      RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
          , "/open-apis/ehr/v1/attachments/:token"
          , Sets.newHashSet(AccessTokenType.Tenant)
          , req);

      // 下载请求，返回流
      if (httpResponse.getStatusCode() == 200) {
        GetAttachmentResp resp = new GetAttachmentResp();
        resp.setRawResponse(httpResponse);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(httpResponse.getBody());
        resp.setData(outputStream);
        resp.setFileName(httpResponse.getFileName());
        return resp;
      }
      // 反序列化
      GetAttachmentResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse,
          GetAttachmentResp.class);
      resp.setRawResponse(httpResponse);
      resp.setRequest(req);

      return resp;
    }
  }

  public static class Employee {

    private final Config config;

    public Employee(Config config) {
      this.config = config;
    }

    public ListEmployeeResp list(ListEmployeeReq req, RequestOptions reqOptions) throws Exception {
      // 请求参数选项
      if (reqOptions == null) {
        reqOptions = new RequestOptions();
      }

      Boolean customSupportLong2Str = reqOptions.isSupportLong2String();
      reqOptions.setSupportLong2String(true);
      if (customSupportLong2Str != null) {
        reqOptions.setSupportLong2String(customSupportLong2Str);
      }

      // 发起请求
      RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
          , "/open-apis/ehr/v1/employees"
          , Sets.newHashSet(AccessTokenType.Tenant)
          , req);

      // 反序列化
      ListEmployeeResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ListEmployeeResp.class);
      resp.setRawResponse(httpResponse);
      resp.setRequest(req);

      return resp;
    }

    public ListEmployeeResp list(ListEmployeeReq req) throws Exception {
      // 请求参数选项
      RequestOptions reqOptions = new RequestOptions();
      reqOptions.setSupportLong2String(true);

      // 发起请求
      RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
          , "/open-apis/ehr/v1/employees"
          , Sets.newHashSet(AccessTokenType.Tenant)
          , req);

      // 反序列化
      ListEmployeeResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ListEmployeeResp.class);
      resp.setRawResponse(httpResponse);
      resp.setRequest(req);

      return resp;
    }
  }

}