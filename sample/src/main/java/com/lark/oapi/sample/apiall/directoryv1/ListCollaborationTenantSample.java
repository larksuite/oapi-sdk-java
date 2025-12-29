package com.lark.oapi.sample.apiall.directoryv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.directory.v1.model.*;

import java.util.HashMap;

// GET /open-apis/directory/v1/collaboration_tenants
public class ListCollaborationTenantSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListCollaborationTenantReq req = ListCollaborationTenantReq.newBuilder()
                .pageSize(100)
                .pageToken("g102aggaEYLRMSHU6DENYI4HMBAJB75XOQN2CUTV")
                .build();

        // 发起请求
        ListCollaborationTenantResp resp = client.directory().v1().collaborationTenant().list(req);

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
