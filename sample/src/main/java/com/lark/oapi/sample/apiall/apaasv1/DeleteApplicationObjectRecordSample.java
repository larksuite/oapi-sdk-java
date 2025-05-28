package com.lark.oapi.sample.apiall.apaasv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.apaas.v1.model.*;

import java.util.HashMap;

// DELETE /open-apis/apaas/v1/applications/:namespace/objects/:object_api_name/records/:id
public class DeleteApplicationObjectRecordSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteApplicationObjectRecordReq req = DeleteApplicationObjectRecordReq.newBuilder()
                .namespace("package_test__c")
                .objectApiName("user")
                .id("1764024447556775")
                .build();

        // 发起请求
        DeleteApplicationObjectRecordResp resp = client.apaas().v1().applicationObjectRecord().delete(req);

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
