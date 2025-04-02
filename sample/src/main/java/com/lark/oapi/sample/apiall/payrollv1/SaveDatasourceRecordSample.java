package com.lark.oapi.sample.apiall.payrollv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.payroll.v1.model.*;

import java.util.HashMap;

// POST /open-apis/payroll/v1/datasource_records/save
public class SaveDatasourceRecordSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SaveDatasourceRecordReq req = SaveDatasourceRecordReq.newBuilder()
                .saveDatasourceRecordReqBody(SaveDatasourceRecordReqBody.newBuilder()
                        .sourceCode("test__c")
                        .records(new DatasourceRecord[]{})
                        .build())
                .build();

        // 发起请求
        SaveDatasourceRecordResp resp = client.payroll().v1().datasourceRecord().save(req);

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
