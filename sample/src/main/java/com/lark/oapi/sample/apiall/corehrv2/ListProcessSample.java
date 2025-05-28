package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// GET /open-apis/corehr/v2/processes
public class ListProcessSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListProcessReq req = ListProcessReq.newBuilder()
                .statuses(new Integer[]{})
                .pageToken("7278949005675988535")
                .pageSize(100)
                .modifyTimeFrom("1547654251506")
                .modifyTimeTo("1547654251506")
                .flowDefinitionId("people_6961286846093788680_7081951411982077732")
                .build();

        // 发起请求
        ListProcessResp resp = client.corehr().v2().process().list(req);

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
