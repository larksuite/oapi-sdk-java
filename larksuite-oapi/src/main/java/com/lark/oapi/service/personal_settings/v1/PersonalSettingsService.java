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

package com.lark.oapi.service.personal_settings.v1;

import com.lark.oapi.core.Config;
import com.lark.oapi.core.Transport;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.token.AccessTokenType;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.core.utils.Sets;
import com.lark.oapi.core.utils.UnmarshalRespUtil;
import com.lark.oapi.service.personal_settings.v1.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

public class PersonalSettingsService {
    private static final Logger log = LoggerFactory.getLogger(PersonalSettingsService.class);
    private final SystemStatus systemStatus; // 系统状态

    public PersonalSettingsService(Config config) {
        this.systemStatus = new SystemStatus(config);
    }

    /**
     * 系统状态
     *
     * @return
     */
    public SystemStatus systemStatus() {
        return systemStatus;
    }

    public static class SystemStatus {
        private final Config config;

        public SystemStatus(Config config) {
            this.config = config;
        }

        /**
         * 批量关闭系统状态，批量关闭用户系统状态可用
         * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/batch_close">https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/batch_close</a> ;
         * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/BatchCloseSystemStatusSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/BatchCloseSystemStatusSample.java</a> ;
         */
        public BatchCloseSystemStatusResp batchClose(BatchCloseSystemStatusReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/personal_settings/v1/system_statuses/:system_status_id/batch_close"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            BatchCloseSystemStatusResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, BatchCloseSystemStatusResp.class);
            if (resp == null) {
                log.error(String.format(
                        "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/personal_settings/v1/system_statuses/:system_status_id/batch_close"
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
         * 批量关闭系统状态，批量关闭用户系统状态可用
         * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/batch_close">https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/batch_close</a> ;
         * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/BatchCloseSystemStatusSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/BatchCloseSystemStatusSample.java</a> ;
         */
        public BatchCloseSystemStatusResp batchClose(BatchCloseSystemStatusReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/personal_settings/v1/system_statuses/:system_status_id/batch_close"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            BatchCloseSystemStatusResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, BatchCloseSystemStatusResp.class);
            if (resp == null) {
                log.error(String.format(
                        "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/personal_settings/v1/system_statuses/:system_status_id/batch_close"
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
         * 批量开启系统状态，批量开启用户系统状态可用
         * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/batch_open">https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/batch_open</a> ;
         * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/BatchOpenSystemStatusSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/BatchOpenSystemStatusSample.java</a> ;
         */
        public BatchOpenSystemStatusResp batchOpen(BatchOpenSystemStatusReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/personal_settings/v1/system_statuses/:system_status_id/batch_open"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            BatchOpenSystemStatusResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, BatchOpenSystemStatusResp.class);
            if (resp == null) {
                log.error(String.format(
                        "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/personal_settings/v1/system_statuses/:system_status_id/batch_open"
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
         * 批量开启系统状态，批量开启用户系统状态可用
         * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/batch_open">https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/batch_open</a> ;
         * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/BatchOpenSystemStatusSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/BatchOpenSystemStatusSample.java</a> ;
         */
        public BatchOpenSystemStatusResp batchOpen(BatchOpenSystemStatusReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/personal_settings/v1/system_statuses/:system_status_id/batch_open"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            BatchOpenSystemStatusResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, BatchOpenSystemStatusResp.class);
            if (resp == null) {
                log.error(String.format(
                        "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/personal_settings/v1/system_statuses/:system_status_id/batch_open"
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
         * 创建系统状态，创建租户维度的系统状态。
         * <p> 注意事项:;- 操作的数据为租户维度数据，请小心操作。;- 每个租户最多创建10个系统状态。 ;
         * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/create">https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/create</a> ;
         * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/CreateSystemStatusSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/CreateSystemStatusSample.java</a> ;
         */
        public CreateSystemStatusResp create(CreateSystemStatusReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/personal_settings/v1/system_statuses"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            CreateSystemStatusResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, CreateSystemStatusResp.class);
            if (resp == null) {
                log.error(String.format(
                        "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/personal_settings/v1/system_statuses"
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
         * 创建系统状态，创建租户维度的系统状态。
         * <p> 注意事项:;- 操作的数据为租户维度数据，请小心操作。;- 每个租户最多创建10个系统状态。 ;
         * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/create">https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/create</a> ;
         * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/CreateSystemStatusSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/CreateSystemStatusSample.java</a> ;
         */
        public CreateSystemStatusResp create(CreateSystemStatusReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/personal_settings/v1/system_statuses"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            CreateSystemStatusResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, CreateSystemStatusResp.class);
            if (resp == null) {
                log.error(String.format(
                        "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/personal_settings/v1/system_statuses"
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
         * 删除系统状态，删除租户维度的系统状态。
         * <p> 注意事项：;- 操作的数据为租户维度数据，请小心操作。 ;- 删除系统状态后，并不影响正在使用该状态用户下系统状态的客户端展示。 ;
         * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/delete">https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/delete</a> ;
         * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/DeleteSystemStatusSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/DeleteSystemStatusSample.java</a> ;
         */
        public DeleteSystemStatusResp delete(DeleteSystemStatusReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "DELETE"
                    , "/open-apis/personal_settings/v1/system_statuses/:system_status_id"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            DeleteSystemStatusResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, DeleteSystemStatusResp.class);
            if (resp == null) {
                log.error(String.format(
                        "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/personal_settings/v1/system_statuses/:system_status_id"
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
         * 删除系统状态，删除租户维度的系统状态。
         * <p> 注意事项：;- 操作的数据为租户维度数据，请小心操作。 ;- 删除系统状态后，并不影响正在使用该状态用户下系统状态的客户端展示。 ;
         * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/delete">https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/delete</a> ;
         * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/DeleteSystemStatusSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/DeleteSystemStatusSample.java</a> ;
         */
        public DeleteSystemStatusResp delete(DeleteSystemStatusReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "DELETE"
                    , "/open-apis/personal_settings/v1/system_statuses/:system_status_id"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            DeleteSystemStatusResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, DeleteSystemStatusResp.class);
            if (resp == null) {
                log.error(String.format(
                        "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/personal_settings/v1/system_statuses/:system_status_id"
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
         * 获取系统状态，获取租户下所有系统状态
         * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/list">https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/list</a> ;
         * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/ListSystemStatusSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/ListSystemStatusSample.java</a> ;
         */
        public ListSystemStatusResp list(ListSystemStatusReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
                    , "/open-apis/personal_settings/v1/system_statuses"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            ListSystemStatusResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ListSystemStatusResp.class);
            if (resp == null) {
                log.error(String.format(
                        "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/personal_settings/v1/system_statuses"
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
         * 获取系统状态，获取租户下所有系统状态
         * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/list">https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/list</a> ;
         * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/ListSystemStatusSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/ListSystemStatusSample.java</a> ;
         */
        public ListSystemStatusResp list(ListSystemStatusReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
                    , "/open-apis/personal_settings/v1/system_statuses"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            ListSystemStatusResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ListSystemStatusResp.class);
            if (resp == null) {
                log.error(String.format(
                        "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/personal_settings/v1/system_statuses"
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
         * 修改系统状态，修改租户维度系统状态。
         * <p> 注意事项：;- 操作的数据为租户维度数据，请小心操作。 ;- 修改系统状态后，并不影响正在使用的用户。该用户的系统状态可用时间到期后，再次被开启可用的时候，用户客户端才会同步到更新后的系统状态。 ;
         * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/patch">https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/patch</a> ;
         * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/PatchSystemStatusSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/PatchSystemStatusSample.java</a> ;
         */
        public PatchSystemStatusResp patch(PatchSystemStatusReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "PATCH"
                    , "/open-apis/personal_settings/v1/system_statuses/:system_status_id"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            PatchSystemStatusResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, PatchSystemStatusResp.class);
            if (resp == null) {
                log.error(String.format(
                        "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/personal_settings/v1/system_statuses/:system_status_id"
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
         * 修改系统状态，修改租户维度系统状态。
         * <p> 注意事项：;- 操作的数据为租户维度数据，请小心操作。 ;- 修改系统状态后，并不影响正在使用的用户。该用户的系统状态可用时间到期后，再次被开启可用的时候，用户客户端才会同步到更新后的系统状态。 ;
         * <p> 官网API文档链接:<a href="https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/patch">https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/personal_settings-v1/system_status/patch</a> ;
         * <p> 使用Demo链接: <a href="https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/PatchSystemStatusSample.java">https://github.com/larksuite/oapi-sdk-java/tree/v2_main/sample/src/main/java/com/lark/oapi/sample/apiall/personal_settingsv1/PatchSystemStatusSample.java</a> ;
         */
        public PatchSystemStatusResp patch(PatchSystemStatusReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "PATCH"
                    , "/open-apis/personal_settings/v1/system_statuses/:system_status_id"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            PatchSystemStatusResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, PatchSystemStatusResp.class);
            if (resp == null) {
                log.error(String.format(
                        "%s,callError,req=%s,respHeader=%s,respStatusCode=%s,respBody=%s,", "/open-apis/personal_settings/v1/system_statuses/:system_status_id"
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

}