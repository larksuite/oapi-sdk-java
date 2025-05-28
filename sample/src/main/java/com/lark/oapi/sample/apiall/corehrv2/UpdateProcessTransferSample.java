package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// PUT /open-apis/corehr/v2/processes/:process_id/transfer
public class UpdateProcessTransferSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateProcessTransferReq req = UpdateProcessTransferReq.newBuilder()
                .processId("7410664363763172908")
                .userIdType("open_id")
                .processTransfer(ProcessTransfer.newBuilder()
                        .operator("7184703091806602796")
                        .toUserId("7184703091806602796")
                        .approverIds(new String[]{})
                        .remark("备注")
                        .systemUser(false)
                        .build())
                .build();

        // 发起请求
        UpdateProcessTransferResp resp = client.corehr().v2().processTransfer().update(req);

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
