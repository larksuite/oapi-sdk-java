package com.lark.oapi.sample.apiall.approvalv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.approval.v4.model.*;

import java.util.HashMap;

// GET /open-apis/approval/v4/districts
public class ListDistrictSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListDistrictReq req = ListDistrictReq.newBuilder()
                .pageSize(0)
                .pageToken("")
                .rootDistrictId("1816670")
                .listType("sub_level")
                .locale("zh-CN")
                .build();

        // 发起请求
        ListDistrictResp resp = client.approval().v4().district().list(req);

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
