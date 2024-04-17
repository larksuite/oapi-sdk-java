package com.lark.oapi.sample.apiall.baikev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.baike.v1.model.ListEntityReq;
import com.lark.oapi.service.baike.v1.model.ListEntityResp;

// GET /open-apis/baike/v1/entities
public class ListEntitySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListEntityReq req = ListEntityReq.newBuilder()
                .pageSize(20)
                .pageToken("b152fa6e6f62a291019a04c3a93f365f8ac641910506ff15ff4cad6534e087cb4ed8fa2c")
                .provider("星云")
                .userIdType("user_id")
                .build();

        // 发起请求
        ListEntityResp resp = client.baike().v1().entity().list(req);

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
