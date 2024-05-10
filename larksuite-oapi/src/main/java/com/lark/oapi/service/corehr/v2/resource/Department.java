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

package com.lark.oapi.service.corehr.v2.resource;

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

import com.lark.oapi.service.corehr.v2.model.*;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Department {
    private static final Logger log = LoggerFactory.getLogger(Department.class);
    private final Config config;

    public Department(Config config) {
        this.config = config;
    }


    /**
     * ，
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=batch_get&project=corehr&resource=department&version=v2">https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=batch_get&project=corehr&resource=department&version=v2</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/corehrv2/BatchGetDepartmentSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/corehrv2/BatchGetDepartmentSample.java</a> ;
     */
    public BatchGetDepartmentResp batchGet(BatchGetDepartmentReq req, RequestOptions reqOptions) throws Exception {
        // 请求参数选项
        if (reqOptions == null) {
            reqOptions = new RequestOptions();
        }

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                , "/open-apis/corehr/v2/departments/batch_get"
                , Sets.newHashSet(AccessTokenType.Tenant)
                , req);

        // 反序列化
        BatchGetDepartmentResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, BatchGetDepartmentResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/corehr/v2/departments/batch_get"
                    , Jsons.DEFAULT.toJson(req), Jsons.DEFAULT.toJson(httpResponse.getHeaders()),
                    httpResponse.getStatusCode(), new String(httpResponse.getBody(),
                            StandardCharsets.UTF_8)));
            throw new IllegalArgumentException("The result returned by the server is illegal");
        }

        resp.setRawResponse(httpResponse);
        resp.setRequest(req);

        return resp;
    }

    /**
     * ，
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=batch_get&project=corehr&resource=department&version=v2">https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=batch_get&project=corehr&resource=department&version=v2</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/corehrv2/BatchGetDepartmentSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/corehrv2/BatchGetDepartmentSample.java</a> ;
     */
    public BatchGetDepartmentResp batchGet(BatchGetDepartmentReq req) throws Exception {
        // 请求参数选项
        RequestOptions reqOptions = new RequestOptions();

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                , "/open-apis/corehr/v2/departments/batch_get"
                , Sets.newHashSet(AccessTokenType.Tenant)
                , req);

        // 反序列化
        BatchGetDepartmentResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, BatchGetDepartmentResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/corehr/v2/departments/batch_get"
                    , Jsons.DEFAULT.toJson(req), Jsons.DEFAULT.toJson(httpResponse.getHeaders()),
                    httpResponse.getStatusCode(), new String(httpResponse.getBody(),
                            StandardCharsets.UTF_8)));
            throw new IllegalArgumentException("The result returned by the server is illegal");
        }

        resp.setRawResponse(httpResponse);
        resp.setRequest(req);

        return resp;
    }

    /**
     * ，
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=parents&project=corehr&resource=department&version=v2">https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=parents&project=corehr&resource=department&version=v2</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/corehrv2/ParentsDepartmentSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/corehrv2/ParentsDepartmentSample.java</a> ;
     */
    public ParentsDepartmentResp parents(ParentsDepartmentReq req, RequestOptions reqOptions) throws Exception {
        // 请求参数选项
        if (reqOptions == null) {
            reqOptions = new RequestOptions();
        }

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                , "/open-apis/corehr/v2/departments/parents"
                , Sets.newHashSet(AccessTokenType.Tenant)
                , req);

        // 反序列化
        ParentsDepartmentResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ParentsDepartmentResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/corehr/v2/departments/parents"
                    , Jsons.DEFAULT.toJson(req), Jsons.DEFAULT.toJson(httpResponse.getHeaders()),
                    httpResponse.getStatusCode(), new String(httpResponse.getBody(),
                            StandardCharsets.UTF_8)));
            throw new IllegalArgumentException("The result returned by the server is illegal");
        }

        resp.setRawResponse(httpResponse);
        resp.setRequest(req);

        return resp;
    }

    /**
     * ，
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=parents&project=corehr&resource=department&version=v2">https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=parents&project=corehr&resource=department&version=v2</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/corehrv2/ParentsDepartmentSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/corehrv2/ParentsDepartmentSample.java</a> ;
     */
    public ParentsDepartmentResp parents(ParentsDepartmentReq req) throws Exception {
        // 请求参数选项
        RequestOptions reqOptions = new RequestOptions();

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                , "/open-apis/corehr/v2/departments/parents"
                , Sets.newHashSet(AccessTokenType.Tenant)
                , req);

        // 反序列化
        ParentsDepartmentResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ParentsDepartmentResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/corehr/v2/departments/parents"
                    , Jsons.DEFAULT.toJson(req), Jsons.DEFAULT.toJson(httpResponse.getHeaders()),
                    httpResponse.getStatusCode(), new String(httpResponse.getBody(),
                            StandardCharsets.UTF_8)));
            throw new IllegalArgumentException("The result returned by the server is illegal");
        }

        resp.setRawResponse(httpResponse);
        resp.setRequest(req);

        return resp;
    }

    /**
     * ，查询任意日期部门信息
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=query_timeline&project=corehr&resource=department&version=v2">https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=query_timeline&project=corehr&resource=department&version=v2</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/corehrv2/QueryTimelineDepartmentSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/corehrv2/QueryTimelineDepartmentSample.java</a> ;
     */
    public QueryTimelineDepartmentResp queryTimeline(QueryTimelineDepartmentReq req, RequestOptions reqOptions) throws Exception {
        // 请求参数选项
        if (reqOptions == null) {
            reqOptions = new RequestOptions();
        }

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                , "/open-apis/corehr/v2/departments/query_timeline"
                , Sets.newHashSet(AccessTokenType.Tenant)
                , req);

        // 反序列化
        QueryTimelineDepartmentResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, QueryTimelineDepartmentResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/corehr/v2/departments/query_timeline"
                    , Jsons.DEFAULT.toJson(req), Jsons.DEFAULT.toJson(httpResponse.getHeaders()),
                    httpResponse.getStatusCode(), new String(httpResponse.getBody(),
                            StandardCharsets.UTF_8)));
            throw new IllegalArgumentException("The result returned by the server is illegal");
        }

        resp.setRawResponse(httpResponse);
        resp.setRequest(req);

        return resp;
    }

    /**
     * ，查询任意日期部门信息
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=query_timeline&project=corehr&resource=department&version=v2">https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=query_timeline&project=corehr&resource=department&version=v2</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/corehrv2/QueryTimelineDepartmentSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/corehrv2/QueryTimelineDepartmentSample.java</a> ;
     */
    public QueryTimelineDepartmentResp queryTimeline(QueryTimelineDepartmentReq req) throws Exception {
        // 请求参数选项
        RequestOptions reqOptions = new RequestOptions();

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                , "/open-apis/corehr/v2/departments/query_timeline"
                , Sets.newHashSet(AccessTokenType.Tenant)
                , req);

        // 反序列化
        QueryTimelineDepartmentResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, QueryTimelineDepartmentResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/corehr/v2/departments/query_timeline"
                    , Jsons.DEFAULT.toJson(req), Jsons.DEFAULT.toJson(httpResponse.getHeaders()),
                    httpResponse.getStatusCode(), new String(httpResponse.getBody(),
                            StandardCharsets.UTF_8)));
            throw new IllegalArgumentException("The result returned by the server is illegal");
        }

        resp.setRawResponse(httpResponse);
        resp.setRequest(req);

        return resp;
    }

    /**
     * ，根据部门 ID，上级部门查询部门列表
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=search&project=corehr&resource=department&version=v2">https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=search&project=corehr&resource=department&version=v2</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/corehrv2/SearchDepartmentSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/corehrv2/SearchDepartmentSample.java</a> ;
     */
    public SearchDepartmentResp search(SearchDepartmentReq req, RequestOptions reqOptions) throws Exception {
        // 请求参数选项
        if (reqOptions == null) {
            reqOptions = new RequestOptions();
        }

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                , "/open-apis/corehr/v2/departments/search"
                , Sets.newHashSet(AccessTokenType.Tenant)
                , req);

        // 反序列化
        SearchDepartmentResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, SearchDepartmentResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/corehr/v2/departments/search"
                    , Jsons.DEFAULT.toJson(req), Jsons.DEFAULT.toJson(httpResponse.getHeaders()),
                    httpResponse.getStatusCode(), new String(httpResponse.getBody(),
                            StandardCharsets.UTF_8)));
            throw new IllegalArgumentException("The result returned by the server is illegal");
        }

        resp.setRawResponse(httpResponse);
        resp.setRequest(req);

        return resp;
    }

    /**
     * ，根据部门 ID，上级部门查询部门列表
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=search&project=corehr&resource=department&version=v2">https://open.feishu.cn/api-explorer?from=op_doc_tab&apiName=search&project=corehr&resource=department&version=v2</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/corehrv2/SearchDepartmentSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/corehrv2/SearchDepartmentSample.java</a> ;
     */
    public SearchDepartmentResp search(SearchDepartmentReq req) throws Exception {
        // 请求参数选项
        RequestOptions reqOptions = new RequestOptions();

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                , "/open-apis/corehr/v2/departments/search"
                , Sets.newHashSet(AccessTokenType.Tenant)
                , req);

        // 反序列化
        SearchDepartmentResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, SearchDepartmentResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/corehr/v2/departments/search"
                    , Jsons.DEFAULT.toJson(req), Jsons.DEFAULT.toJson(httpResponse.getHeaders()),
                    httpResponse.getStatusCode(), new String(httpResponse.getBody(),
                            StandardCharsets.UTF_8)));
            throw new IllegalArgumentException("The result returned by the server is illegal");
        }

        resp.setRawResponse(httpResponse);
        resp.setRequest(req);

        return resp;
    }
}
