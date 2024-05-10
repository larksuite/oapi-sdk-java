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

package com.lark.oapi.service.wiki.v2.resource;

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

import com.lark.oapi.service.wiki.v2.model.*;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class SpaceMember {
    private static final Logger log = LoggerFactory.getLogger(SpaceMember.class);
    private final Config config;

    public SpaceMember(Config config) {
        this.config = config;
    }


    /**
     * 添加知识空间成员，添加知识空间成员或管理员。
     * <p> 知识空间具有[类型](https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/wiki-overview)和[可见性](https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/wiki-overview)的概念。不同的类型或可见性可以对本操作做出限制：;- 可见性限制：公开知识空间（visibility为public）对租户所有用户可见，因此不支持再添加成员，但可以添加管理员。;- 类型限制：个人知识空间 （type为person）为个人管理的知识空间，不支持添加其他管理员（包括应用/机器人）。但可以添加成员。;;;知识空间权限要求，当前使用的 access token 所代表的应用或用户拥有：;- 为知识空间管理员 ;
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/wiki-v2/space-member/create">https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/wiki-v2/space-member/create</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/wikiv2/CreateSpaceMemberSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/wikiv2/CreateSpaceMemberSample.java</a> ;
     */
    public CreateSpaceMemberResp create(CreateSpaceMemberReq req, RequestOptions reqOptions) throws Exception {
        // 请求参数选项
        if (reqOptions == null) {
            reqOptions = new RequestOptions();
        }

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                , "/open-apis/wiki/v2/spaces/:space_id/members"
                , Sets.newHashSet(AccessTokenType.User, AccessTokenType.Tenant)
                , req);

        // 反序列化
        CreateSpaceMemberResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, CreateSpaceMemberResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/wiki/v2/spaces/:space_id/members"
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
     * 添加知识空间成员，添加知识空间成员或管理员。
     * <p> 知识空间具有[类型](https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/wiki-overview)和[可见性](https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/wiki-overview)的概念。不同的类型或可见性可以对本操作做出限制：;- 可见性限制：公开知识空间（visibility为public）对租户所有用户可见，因此不支持再添加成员，但可以添加管理员。;- 类型限制：个人知识空间 （type为person）为个人管理的知识空间，不支持添加其他管理员（包括应用/机器人）。但可以添加成员。;;;知识空间权限要求，当前使用的 access token 所代表的应用或用户拥有：;- 为知识空间管理员 ;
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/wiki-v2/space-member/create">https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/wiki-v2/space-member/create</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/wikiv2/CreateSpaceMemberSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/wikiv2/CreateSpaceMemberSample.java</a> ;
     */
    public CreateSpaceMemberResp create(CreateSpaceMemberReq req) throws Exception {
        // 请求参数选项
        RequestOptions reqOptions = new RequestOptions();

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                , "/open-apis/wiki/v2/spaces/:space_id/members"
                , Sets.newHashSet(AccessTokenType.User, AccessTokenType.Tenant)
                , req);

        // 反序列化
        CreateSpaceMemberResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, CreateSpaceMemberResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/wiki/v2/spaces/:space_id/members"
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
     * 删除知识空间成员，此接口用于删除知识空间成员或管理员。
     * <p> 知识空间具有[类型](https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/wiki-overview)和[可见性](https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/wiki-overview)的概念。不同的类型或可见性可以对本操作做出限制：;- 可见性限制：公开知识空间（visibility为public）对租户所有用户可见，因此不支持再删除成员，但可以删除管理员。;- 类型限制：个人知识空间 （type为person）为个人管理的知识空间，不支持删除管理员。但可以删除成员。;;;知识空间权限要求，当前使用的 access token 所代表的应用或用户拥有：;- 为知识空间管理员 ;
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/wiki-v2/space-member/delete">https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/wiki-v2/space-member/delete</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/wikiv2/DeleteSpaceMemberSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/wikiv2/DeleteSpaceMemberSample.java</a> ;
     */
    public DeleteSpaceMemberResp delete(DeleteSpaceMemberReq req, RequestOptions reqOptions) throws Exception {
        // 请求参数选项
        if (reqOptions == null) {
            reqOptions = new RequestOptions();
        }

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "DELETE"
                , "/open-apis/wiki/v2/spaces/:space_id/members/:member_id"
                , Sets.newHashSet(AccessTokenType.Tenant, AccessTokenType.User)
                , req);

        // 反序列化
        DeleteSpaceMemberResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, DeleteSpaceMemberResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/wiki/v2/spaces/:space_id/members/:member_id"
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
     * 删除知识空间成员，此接口用于删除知识空间成员或管理员。
     * <p> 知识空间具有[类型](https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/wiki-overview)和[可见性](https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/wiki-overview)的概念。不同的类型或可见性可以对本操作做出限制：;- 可见性限制：公开知识空间（visibility为public）对租户所有用户可见，因此不支持再删除成员，但可以删除管理员。;- 类型限制：个人知识空间 （type为person）为个人管理的知识空间，不支持删除管理员。但可以删除成员。;;;知识空间权限要求，当前使用的 access token 所代表的应用或用户拥有：;- 为知识空间管理员 ;
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/wiki-v2/space-member/delete">https://open.feishu.cn/document/ukTMukTMukTM/uUDN04SN0QjL1QDN/wiki-v2/space-member/delete</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/wikiv2/DeleteSpaceMemberSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/wikiv2/DeleteSpaceMemberSample.java</a> ;
     */
    public DeleteSpaceMemberResp delete(DeleteSpaceMemberReq req) throws Exception {
        // 请求参数选项
        RequestOptions reqOptions = new RequestOptions();

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "DELETE"
                , "/open-apis/wiki/v2/spaces/:space_id/members/:member_id"
                , Sets.newHashSet(AccessTokenType.Tenant, AccessTokenType.User)
                , req);

        // 反序列化
        DeleteSpaceMemberResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, DeleteSpaceMemberResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/wiki/v2/spaces/:space_id/members/:member_id"
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
