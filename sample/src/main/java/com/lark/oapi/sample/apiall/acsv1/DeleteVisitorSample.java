package com.lark.oapi.sample.apiall.acsv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.acs.v1.model.DeleteVisitorReq;
import com.lark.oapi.service.acs.v1.model.DeleteVisitorResp;

// DELETE /open-apis/acs/v1/visitors/:visitor_id
public class DeleteVisitorSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteVisitorReq req = DeleteVisitorReq.newBuilder()
                .visitorId("6939433228970082566")
                .userIdType("user_id")
                .build();

        // 发起请求
        DeleteVisitorResp resp = client.acs().v1().visitor().delete(req);

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
