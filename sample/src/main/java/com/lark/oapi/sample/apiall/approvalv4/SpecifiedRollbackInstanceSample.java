package com.lark.oapi.sample.apiall.approvalv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.approval.v4.model.*;

import java.util.HashMap;

// POST /open-apis/approval/v4/instances/specified_rollback
public class SpecifiedRollbackInstanceSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SpecifiedRollbackInstanceReq req = SpecifiedRollbackInstanceReq.newBuilder()
                .userIdType("user_id")
                .specifiedRollback(SpecifiedRollback.newBuilder()
                        .userId("893g4c45")
                        .taskId("7026591166355210260")
                        .reason("申请事项填写不具体，请重新填写")
                        .extra("暂不填写")
                        .taskDefKeyList(new String[]{})
                        .build())
                .build();

        // 发起请求
        SpecifiedRollbackInstanceResp resp = client.approval().v4().instance().specifiedRollback(req);

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
