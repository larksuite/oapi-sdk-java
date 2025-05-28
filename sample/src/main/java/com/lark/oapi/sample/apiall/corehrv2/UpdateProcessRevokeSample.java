package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// PUT /open-apis/corehr/v2/process_revoke/:process_id
public class UpdateProcessRevokeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateProcessRevokeReq req = UpdateProcessRevokeReq.newBuilder()
                .processId("7328345170959681068")
                .userIdType("open_id")
                .processRevokeAndWithdraw(ProcessRevokeAndWithdraw.newBuilder()
                        .userId("ou_91791271921729102012")
                        .reason("原因自定义字符串")
                        .systemUser(false)
                        .build())
                .build();

        // 发起请求
        UpdateProcessRevokeResp resp = client.corehr().v2().processRevoke().update(req);

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
