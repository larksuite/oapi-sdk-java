package com.lark.oapi.sample.apiall.directoryv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.directory.v1.model.*;

import java.util.HashMap;

// GET /open-apis/directory/v1/share_entities
public class ListCollborationShareEntitySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListCollborationShareEntityReq req = ListCollborationShareEntityReq.newBuilder()
                .targetTenantKey("test_key")
                .targetDepartmentId("test_key")
                .targetGroupId("test_key")
                .isSelectSubject(false)
                .pageToken("")
                .pageSize(100)
                .build();

        // 发起请求
        ListCollborationShareEntityResp resp = client.directory().v1().collborationShareEntity().list(req);

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
