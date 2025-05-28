package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/report_detail_row/batchSave
public class BatchSaveReportDetailRowSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchSaveReportDetailRowReq req = BatchSaveReportDetailRowReq.newBuilder()
                .reportDetailReq(ReportDetailReq.newBuilder()
                        .workforcePlanId("7430330781544564268")
                        .centralizedReportingProjectId("7430470688844023340")
                        .items(new WorkforcePlanDetailRow[]{})
                        .build())
                .build();

        // 发起请求
        BatchSaveReportDetailRowResp resp = client.corehr().v2().reportDetailRow().batchSave(req);

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
