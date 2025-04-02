package com.lark.oapi.sample.apiall.apaasv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.apaas.v1.model.*;

import java.util.HashMap;

// POST /open-apis/apaas/v1/applications/:namespace/objects/oql_query
public class OqlQueryApplicationObjectSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        OqlQueryApplicationObjectReq req = OqlQueryApplicationObjectReq.newBuilder()
                .namespace("package_test__c")
                .oqlQueryApplicationObjectReqBody(OqlQueryApplicationObjectReqBody.newBuilder()
                        .query("SELECT _id, _name FROM _user WHERE _type = $1 AND _accountStatus = $user_status LIMIT 10")
                        .args("")
                        .namedArgs("")
                        .build())
                .build();

        // 发起请求
        OqlQueryApplicationObjectResp resp = client.apaas().v1().applicationObject().oqlQuery(req);

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
