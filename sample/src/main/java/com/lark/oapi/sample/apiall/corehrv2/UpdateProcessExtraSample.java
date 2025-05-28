package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// PUT /open-apis/corehr/v2/processes/:process_id/extra
public class UpdateProcessExtraSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateProcessExtraReq req = UpdateProcessExtraReq.newBuilder()
                .processId("7410664363763172908")
                .userIdType("open_id")
                .processExtra(ProcessExtra.newBuilder()
                        .operator("7184703091806602796")
                        .nodeId("7414045453433439788")
                        .approverId("7424452160928106028")
                        .extraType(1)
                        .approvalType(1)
                        .extraUserIds(new String[]{})
                        .remark("备注")
                        .systemUser(false)
                        .build())
                .build();

        // 发起请求
        UpdateProcessExtraResp resp = client.corehr().v2().processExtra().update(req);

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
