package com.lark.oapi.sample.apiall.baikev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.baike.v1.model.ListClassificationReq;
import com.lark.oapi.service.baike.v1.model.ListClassificationResp;

// GET /open-apis/baike/v1/classifications
public class ListClassificationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListClassificationReq req = ListClassificationReq.newBuilder()
                .pageSize(20)
                .pageToken("408ecac018b2e3518db37275e812aad7bb8ad3e755fc886f322ac6c430ba")
                .build();

        // 发起请求
        ListClassificationResp resp = client.baike().v1().classification().list(req);

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
