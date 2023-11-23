package com.lark.oapi.sample.apiall.approvalv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.approval.v4.model.CheckExternalInstanceReq;
import com.lark.oapi.service.approval.v4.model.CheckExternalInstanceReqBody;
import com.lark.oapi.service.approval.v4.model.CheckExternalInstanceResp;
import com.lark.oapi.service.approval.v4.model.ExteranlInstanceCheck;

// POST /open-apis/approval/v4/external_instances/check
public class CheckExternalInstanceSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CheckExternalInstanceReq req = CheckExternalInstanceReq.newBuilder()
                .checkExternalInstanceReqBody(CheckExternalInstanceReqBody.newBuilder()
                        .instances(new ExteranlInstanceCheck[]{})
                        .build())
                .build();

        // 发起请求
        CheckExternalInstanceResp resp = client.approval().v4().externalInstance().check(req);

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
