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

package com.lark.oapi.service.mdm.v1.resource;

import com.lark.oapi.core.Config;
import com.lark.oapi.core.Transport;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.token.AccessTokenType;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.core.utils.Sets;
import com.lark.oapi.core.utils.UnmarshalRespUtil;
import com.lark.oapi.service.mdm.v1.model.BindUserAuthDataRelationReq;
import com.lark.oapi.service.mdm.v1.model.BindUserAuthDataRelationResp;
import com.lark.oapi.service.mdm.v1.model.UnbindUserAuthDataRelationReq;
import com.lark.oapi.service.mdm.v1.model.UnbindUserAuthDataRelationResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

public class UserAuthDataRelation {
    private static final Logger log = LoggerFactory.getLogger(UserAuthDataRelation.class);
    private final Config config;

    public UserAuthDataRelation(Config config) {
        this.config = config;
    }


    /**
     * 用户数据维度绑定，通过该接口，可为指定应用下的用户绑定一类数据维度，支持批量给多个用户同时增量授权。
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/mdm-v1/user_auth_data_relation/bind">https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/mdm-v1/user_auth_data_relation/bind</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/mdmv1/BindUserAuthDataRelationSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/mdmv1/BindUserAuthDataRelationSample.java</a> ;
     */
    public BindUserAuthDataRelationResp bind(BindUserAuthDataRelationReq req, RequestOptions reqOptions) throws Exception {
        // 请求参数选项
        if (reqOptions == null) {
            reqOptions = new RequestOptions();
        }

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                , "/open-apis/mdm/v1/user_auth_data_relations/bind"
                , Sets.newHashSet(AccessTokenType.Tenant)
                , req);

        // 反序列化
        BindUserAuthDataRelationResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, BindUserAuthDataRelationResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/mdm/v1/user_auth_data_relations/bind"
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
     * 用户数据维度绑定，通过该接口，可为指定应用下的用户绑定一类数据维度，支持批量给多个用户同时增量授权。
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/mdm-v1/user_auth_data_relation/bind">https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/mdm-v1/user_auth_data_relation/bind</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/mdmv1/BindUserAuthDataRelationSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/mdmv1/BindUserAuthDataRelationSample.java</a> ;
     */
    public BindUserAuthDataRelationResp bind(BindUserAuthDataRelationReq req) throws Exception {
        // 请求参数选项
        RequestOptions reqOptions = new RequestOptions();

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                , "/open-apis/mdm/v1/user_auth_data_relations/bind"
                , Sets.newHashSet(AccessTokenType.Tenant)
                , req);

        // 反序列化
        BindUserAuthDataRelationResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, BindUserAuthDataRelationResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/mdm/v1/user_auth_data_relations/bind"
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
     * 用户数据维度解绑，通过该接口，可为指定应用下的指定用户解除一类数据维度。
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/mdm-v1/user_auth_data_relation/unbind">https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/mdm-v1/user_auth_data_relation/unbind</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/mdmv1/UnbindUserAuthDataRelationSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/mdmv1/UnbindUserAuthDataRelationSample.java</a> ;
     */
    public UnbindUserAuthDataRelationResp unbind(UnbindUserAuthDataRelationReq req, RequestOptions reqOptions) throws Exception {
        // 请求参数选项
        if (reqOptions == null) {
            reqOptions = new RequestOptions();
        }

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                , "/open-apis/mdm/v1/user_auth_data_relations/unbind"
                , Sets.newHashSet(AccessTokenType.Tenant)
                , req);

        // 反序列化
        UnbindUserAuthDataRelationResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, UnbindUserAuthDataRelationResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/mdm/v1/user_auth_data_relations/unbind"
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
     * 用户数据维度解绑，通过该接口，可为指定应用下的指定用户解除一类数据维度。
     * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/mdm-v1/user_auth_data_relation/unbind">https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/mdm-v1/user_auth_data_relation/unbind</a> ;
     * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/mdmv1/UnbindUserAuthDataRelationSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/mdmv1/UnbindUserAuthDataRelationSample.java</a> ;
     */
    public UnbindUserAuthDataRelationResp unbind(UnbindUserAuthDataRelationReq req) throws Exception {
        // 请求参数选项
        RequestOptions reqOptions = new RequestOptions();

        // 发起请求
        RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                , "/open-apis/mdm/v1/user_auth_data_relations/unbind"
                , Sets.newHashSet(AccessTokenType.Tenant)
                , req);

        // 反序列化
        UnbindUserAuthDataRelationResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, UnbindUserAuthDataRelationResp.class);
        if (resp == null) {
            log.error(String.format(
                    "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/mdm/v1/user_auth_data_relations/unbind"
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
