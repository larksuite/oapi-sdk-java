package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.ListApplicationReq;
import com.lark.oapi.service.hire.v1.model.ListApplicationResp;

// GET /open-apis/hire/v1/applications
public class ListApplicationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListApplicationReq req = ListApplicationReq.newBuilder()
                .processId("6960663240925956554")
                .stageId("614218419274131")
                .talentId("6891560630172518670")
                .activeStatus("1")
                .jobId("7334134355464633")
                .pageToken("1")
                .pageSize(100)
                .updateStartTime("1618500278663")
                .updateEndTime("1618500278663")
                .build();

        // 发起请求
        ListApplicationResp resp = client.hire().application().list(req);

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
