package com.lark.oapi.sample.apiall.approvalv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.approval.v4.model.*;

// POST /open-apis/approval/v4/approvals
public class CreateApprovalSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateApprovalReq req = CreateApprovalReq.newBuilder()
                .departmentIdType("open_department_id")
                .userIdType("user_id")
                .approvalCreate(ApprovalCreate.newBuilder()
                        .approvalName("@i18n@approval_name")
                        .approvalCode("7C468A54-8745-2245-9675-08B7C63E7A85")
                        .description("@i18n@description")
                        .viewers(new ApprovalCreateViewers[]{})
                        .form(ApprovalForm.newBuilder().build())
                        .nodeList(new ApprovalNode[]{})
                        .settings(ApprovalSetting.newBuilder().build())
                        .config(ApprovalConfig.newBuilder().build())
                        .icon(0)
                        .i18nResources(new I18nResource[]{})
                        .processManagerIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        CreateApprovalResp resp = client.approval().approval().create(req);

        // 处理服务端错误
        if (!resp.success()) {
            System.out.println(String.format("code:%s,msg:%s,reqId:%s"
                    , resp.getCode(), resp.getMsg(), resp.getRequestId()));
            return;
        }

        // 业务数据处理
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
    }
}
