package com.lark.oapi.sample.apiall.attendancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.attendance.v1.model.ListArchiveRuleReq;
import com.lark.oapi.service.attendance.v1.model.ListArchiveRuleResp;

// GET /open-apis/attendance/v1/archive_rule
public class ListArchiveRuleSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListArchiveRuleReq req = ListArchiveRuleReq.newBuilder()
                .pageSize(10)
                .pageToken("xxx")
                .build();

        // 发起请求
        ListArchiveRuleResp resp = client.attendance().v1().archiveRule().list(req);

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
