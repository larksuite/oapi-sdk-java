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

package com.lark.oapi.service.application.v6.resource;

import com.lark.oapi.core.token.AccessTokenType;
import com.lark.oapi.core.Transport;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.utils.UnmarshalRespUtil;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.core.utils.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

import com.lark.oapi.core.Config;
import com.lark.oapi.core.request.RequestOptions;

import java.io.ByteArrayOutputStream;

import com.lark.oapi.service.application.v6.model.*;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Scope {
    private static final Logger log = LoggerFactory.getLogger(Scope.class);
    private final Config config;

    public Scope(Config config) {
        this.config = config;
    }


    /**
     * ，
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=apply&project=application&resource=scope&version=v6">https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=apply&project=application&resource=scope&version=v6</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/applicationv6/ApplyScopeSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/applicationv6/ApplyScopeSample.java</a> ;
     */
    public ApplyScopeResp apply(RequestOptions reqOptions) throws Exception {
        // 请求参数选项
        if (reqOptions == null) {
            reqOptions = new RequestOptions();
        }

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                , "/open-apis/application/v6/scopes/apply"
                , Sets.newHashSet(AccessTokenType.Tenant)
                , null);

        // 反序列化
        ApplyScopeResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ApplyScopeResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/application/v6/scopes/apply"
                    , Jsons.DEFAULT.toJson(httpResponse.getHeaders()),
                    httpResponse.getStatusCode(), new String(httpResponse.getBody(),
                            StandardCharsets.UTF_8)));

            throw new IllegalArgumentException("The result returned by the server is illegal");
        }

        resp.setRawResponse(httpResponse);
        return resp;
    }

    /**
     * ，
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=apply&project=application&resource=scope&version=v6">https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=apply&project=application&resource=scope&version=v6</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/applicationv6/ApplyScopeSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/applicationv6/ApplyScopeSample.java</a> ;
     */
    public ApplyScopeResp apply() throws Exception {
        // 请求参数选项
        RequestOptions reqOptions = new RequestOptions();

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                , "/open-apis/application/v6/scopes/apply"
                , Sets.newHashSet(AccessTokenType.Tenant)
                , null);

        // 反序列化
        ApplyScopeResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ApplyScopeResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/application/v6/scopes/apply"
                    , Jsons.DEFAULT.toJson(httpResponse.getHeaders()),
                    httpResponse.getStatusCode(), new String(httpResponse.getBody(),
                            StandardCharsets.UTF_8)));

            throw new IllegalArgumentException("The result returned by the server is illegal");
        }

        resp.setRawResponse(httpResponse);
        return resp;
    }

    /**
     * ，
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=list&project=application&resource=scope&version=v6">https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=list&project=application&resource=scope&version=v6</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/applicationv6/ListScopeSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/applicationv6/ListScopeSample.java</a> ;
     */
    public ListScopeResp list(RequestOptions reqOptions) throws Exception {
        // 请求参数选项
        if (reqOptions == null) {
            reqOptions = new RequestOptions();
        }

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
                , "/open-apis/application/v6/scopes"
                , Sets.newHashSet(AccessTokenType.Tenant)
                , null);

        // 反序列化
        ListScopeResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ListScopeResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/application/v6/scopes"
                    , Jsons.DEFAULT.toJson(httpResponse.getHeaders()),
                    httpResponse.getStatusCode(), new String(httpResponse.getBody(),
                            StandardCharsets.UTF_8)));

            throw new IllegalArgumentException("The result returned by the server is illegal");
        }

        resp.setRawResponse(httpResponse);
        return resp;
    }

    /**
     * ，
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=list&project=application&resource=scope&version=v6">https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=list&project=application&resource=scope&version=v6</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/applicationv6/ListScopeSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/applicationv6/ListScopeSample.java</a> ;
     */
    public ListScopeResp list() throws Exception {
        // 请求参数选项
        RequestOptions reqOptions = new RequestOptions();

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
                , "/open-apis/application/v6/scopes"
                , Sets.newHashSet(AccessTokenType.Tenant)
                , null);

        // 反序列化
        ListScopeResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ListScopeResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/application/v6/scopes"
                    , Jsons.DEFAULT.toJson(httpResponse.getHeaders()),
                    httpResponse.getStatusCode(), new String(httpResponse.getBody(),
                            StandardCharsets.UTF_8)));

            throw new IllegalArgumentException("The result returned by the server is illegal");
        }

        resp.setRawResponse(httpResponse);
        return resp;
    }
}