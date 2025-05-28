package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/approval_groups/open_query_job_change_list_by_ids
public class OpenQueryJobChangeListByIdsApprovalGroupsSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        OpenQueryJobChangeListByIdsApprovalGroupsReq req = OpenQueryJobChangeListByIdsApprovalGroupsReq.newBuilder()
                .processId("6991776076699549697")
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .openQueryJobChangeListByIdsApprovalGroupsReqBody(OpenQueryJobChangeListByIdsApprovalGroupsReqBody.newBuilder()
                        .jobChangeIds(new String[]{})
                        .needDepartmentPath(false)
                        .build())
                .build();

        // 发起请求
        OpenQueryJobChangeListByIdsApprovalGroupsResp resp = client.corehr().v2().approvalGroups().openQueryJobChangeListByIds(req);

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
