// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.approval.v4;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Transport;
import com.larksuite.oapi.core.request.RequestOptions;
import com.larksuite.oapi.core.response.RawResponse;
import com.larksuite.oapi.core.token.AccessTokenType;
import com.larksuite.oapi.core.utils.Sets;
import com.larksuite.oapi.core.utils.UnmarshalRespUtil;
import com.larksuite.oapi.event.IEventHandler;
import com.larksuite.oapi.service.approval.v4.model.*;

public class ApprovalService {
    private final Approval approval;
    private final ExternalApproval externalApproval;
    private final ExternalInstance externalInstance;
    private final Instance instance;
    private final Task task;

    public ApprovalService(Config config) {
        this.approval = new Approval(config);
        this.externalApproval = new ExternalApproval(config);
        this.externalInstance = new ExternalInstance(config);
        this.instance = new Instance(config);
        this.task = new Task(config);
    }

    public Approval approval() {
        return approval;
    }

    public ExternalApproval externalApproval() {
        return externalApproval;
    }

    public ExternalInstance externalInstance() {
        return externalInstance;
    }

    public Instance instance() {
        return instance;
    }

    public Task task() {
        return task;
    }

    public static class Approval {
        private final Config config;

        public Approval(Config config) {
            this.config = config;
        }

        public CreateApprovalResp create(CreateApprovalReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/approvals"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            CreateApprovalResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, CreateApprovalResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public CreateApprovalResp create(CreateApprovalReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/approvals"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            CreateApprovalResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, CreateApprovalResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public GetApprovalResp get(GetApprovalReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
                    , "/open-apis/approval/v4/approvals/:approval_code"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            GetApprovalResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, GetApprovalResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public GetApprovalResp get(GetApprovalReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
                    , "/open-apis/approval/v4/approvals/:approval_code"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            GetApprovalResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, GetApprovalResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }
    }

    public static class ExternalApproval {
        private final Config config;

        public ExternalApproval(Config config) {
            this.config = config;
        }

        public CreateExternalApprovalResp create(CreateExternalApprovalReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/external_approvals"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            CreateExternalApprovalResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, CreateExternalApprovalResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public CreateExternalApprovalResp create(CreateExternalApprovalReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/external_approvals"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            CreateExternalApprovalResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, CreateExternalApprovalResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }
    }

    public static class ExternalInstance {
        private final Config config;

        public ExternalInstance(Config config) {
            this.config = config;
        }

        public CheckExternalInstanceResp check(CheckExternalInstanceReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/external_instances/check"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            CheckExternalInstanceResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, CheckExternalInstanceResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public CheckExternalInstanceResp check(CheckExternalInstanceReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/external_instances/check"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            CheckExternalInstanceResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, CheckExternalInstanceResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public CreateExternalInstanceResp create(CreateExternalInstanceReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/external_instances"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            CreateExternalInstanceResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, CreateExternalInstanceResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public CreateExternalInstanceResp create(CreateExternalInstanceReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/external_instances"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            CreateExternalInstanceResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, CreateExternalInstanceResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }
    }

    public static class Instance {
        private final Config config;

        public Instance(Config config) {
            this.config = config;
        }

        public AddSignInstanceResp addSign(AddSignInstanceReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/instances/add_sign"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            AddSignInstanceResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, AddSignInstanceResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public AddSignInstanceResp addSign(AddSignInstanceReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/instances/add_sign"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            AddSignInstanceResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, AddSignInstanceResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public CancelInstanceResp cancel(CancelInstanceReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/instances/cancel"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            CancelInstanceResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, CancelInstanceResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public CancelInstanceResp cancel(CancelInstanceReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/instances/cancel"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            CancelInstanceResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, CancelInstanceResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public CcInstanceResp cc(CcInstanceReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/instances/cc"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            CcInstanceResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, CcInstanceResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public CcInstanceResp cc(CcInstanceReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/instances/cc"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            CcInstanceResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, CcInstanceResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public CreateInstanceResp create(CreateInstanceReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/instances"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            CreateInstanceResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, CreateInstanceResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public CreateInstanceResp create(CreateInstanceReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/instances"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            CreateInstanceResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, CreateInstanceResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public GetInstanceResp get(GetInstanceReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
                    , "/open-apis/approval/v4/instances/:instance_id"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            GetInstanceResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, GetInstanceResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public GetInstanceResp get(GetInstanceReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
                    , "/open-apis/approval/v4/instances/:instance_id"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            GetInstanceResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, GetInstanceResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public ListInstanceResp list(ListInstanceReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
                    , "/open-apis/approval/v4/instances"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            ListInstanceResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ListInstanceResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public ListInstanceResp list(ListInstanceReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
                    , "/open-apis/approval/v4/instances"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            ListInstanceResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ListInstanceResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public PreviewInstanceResp preview(PreviewInstanceReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/instances/preview"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            PreviewInstanceResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, PreviewInstanceResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public PreviewInstanceResp preview(PreviewInstanceReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/instances/preview"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            PreviewInstanceResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, PreviewInstanceResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }
    }

    public static class Task {
        private final Config config;

        public Task(Config config) {
            this.config = config;
        }

        public ApproveTaskResp approve(ApproveTaskReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/tasks/approve"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            ApproveTaskResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ApproveTaskResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public ApproveTaskResp approve(ApproveTaskReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/tasks/approve"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            ApproveTaskResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, ApproveTaskResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public QueryTaskResp query(QueryTaskReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
                    , "/open-apis/approval/v4/tasks/query"
                    , Sets.newHashSet(AccessTokenType.Tenant, AccessTokenType.User)
                    , req);

            // 反序列化
            QueryTaskResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, QueryTaskResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public QueryTaskResp query(QueryTaskReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "GET"
                    , "/open-apis/approval/v4/tasks/query"
                    , Sets.newHashSet(AccessTokenType.Tenant, AccessTokenType.User)
                    , req);

            // 反序列化
            QueryTaskResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, QueryTaskResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public RejectTaskResp reject(RejectTaskReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/tasks/reject"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            RejectTaskResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, RejectTaskResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public RejectTaskResp reject(RejectTaskReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/tasks/reject"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            RejectTaskResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, RejectTaskResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public TransferTaskResp transfer(TransferTaskReq req, RequestOptions reqOptions) throws Exception {
            // 请求参数选项
            if (reqOptions == null) {
                reqOptions = new RequestOptions();
            }

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/tasks/transfer"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            TransferTaskResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, TransferTaskResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }

        public TransferTaskResp transfer(TransferTaskReq req) throws Exception {
            // 请求参数选项
            RequestOptions reqOptions = new RequestOptions();

            // 发起请求
            RawResponse httpResponse = Transport.send(config, reqOptions, "POST"
                    , "/open-apis/approval/v4/tasks/transfer"
                    , Sets.newHashSet(AccessTokenType.Tenant)
                    , req);

            // 反序列化
            TransferTaskResp resp = UnmarshalRespUtil.unmarshalResp(httpResponse, TransferTaskResp.class);
            resp.setRawResponse(httpResponse);
            return resp;
        }
    }

    public abstract static class ApprovalUpdatedEventHandler implements IEventHandler<ApprovalUpdatedEvent> {
        @Override
        public ApprovalUpdatedEvent getEvent() {
            return new ApprovalUpdatedEvent();
        }
    }
}