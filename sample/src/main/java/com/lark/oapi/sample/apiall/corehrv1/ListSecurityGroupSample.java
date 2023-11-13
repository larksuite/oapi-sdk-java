package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.ListSecurityGroupReq;
import com.lark.oapi.service.corehr.v1.model.ListSecurityGroupResp;

// GET /open-apis/corehr/v1/security_groups
public class ListSecurityGroupSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListSecurityGroupReq req = ListSecurityGroupReq.newBuilder()
                .pageToken("10")
                .pageSize("100")
                .build();

        // 发起请求
        ListSecurityGroupResp resp = client.corehr().securityGroup().list(req);

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
