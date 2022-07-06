// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.admin.v1;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Transport;
import com.larksuite.oapi.core.request.RequestOptions;
import com.larksuite.oapi.core.response.RawResponse;
import com.larksuite.oapi.core.token.AccessTokenType;
import com.larksuite.oapi.core.utils.Sets;
import com.larksuite.oapi.core.utils.UnmarshalRespUtil;
import com.larksuite.oapi.service.admin.v1.model.*;

public class AdminService {
    private final AdminDeptStat adminDeptStat;
    private final AdminUserStat adminUserStat;
    private final Password password;

    public AdminService(Config config) {
        this.adminDeptStat = new AdminDeptStat(config);
        this.adminUserStat = new AdminUserStat(config);
        this.password = new Password(config);
    }

    public AdminDeptStat adminDeptStat() {
        return adminDeptStat;
    }

    public AdminUserStat adminUserStat() {
        return adminUserStat;
    }

    public Password password() {
        return password;
    }

    public static class AdminDeptStat {
        private final Config config;

        public AdminDeptStat(Config config) {
            this.config = config;
        }

        public ListAdminDeptStatResp list(ListAdminDeptStatReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
                    , "/open-apis/admin/v1/admin_dept_stats"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            ListAdminDeptStatResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ListAdminDeptStatResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public ListAdminDeptStatResp list(ListAdminDeptStatReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
                    , "/open-apis/admin/v1/admin_dept_stats"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            ListAdminDeptStatResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ListAdminDeptStatResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }
    }

    public static class AdminUserStat {
        private final Config config;

        public AdminUserStat(Config config) {
            this.config = config;
        }

        public ListAdminUserStatResp list(ListAdminUserStatReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
                    , "/open-apis/admin/v1/admin_user_stats"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            ListAdminUserStatResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ListAdminUserStatResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public ListAdminUserStatResp list(ListAdminUserStatReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
                    , "/open-apis/admin/v1/admin_user_stats"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            ListAdminUserStatResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ListAdminUserStatResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }
    }

    public static class Password {
        private final Config config;

        public Password(Config config) {
            this.config = config;
        }

        public ResetPasswordResp reset(ResetPasswordReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/admin/v1/password/reset"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            ResetPasswordResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ResetPasswordResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public ResetPasswordResp reset(ResetPasswordReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/admin/v1/password/reset"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            ResetPasswordResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ResetPasswordResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }
    }

}