package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/job_changes/:job_change_id/revoke
public class RevokeJobChangeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        RevokeJobChangeReq req = RevokeJobChangeReq.newBuilder()
                .jobChangeId("7402156992338658860")
                .userIdType("open_id")
                .revokeJobChangeReqBody(RevokeJobChangeReqBody.newBuilder()
                        .operatorId("ou_a294793e8fa21529f2a60e3e9de45520")
                        .build())
                .build();

        // 发起请求
        RevokeJobChangeResp resp = client.corehr().v2().jobChange().revoke(req);

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
