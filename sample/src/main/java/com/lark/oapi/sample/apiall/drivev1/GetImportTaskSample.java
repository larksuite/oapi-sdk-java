package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.GetImportTaskReq;
import com.lark.oapi.service.drive.v1.model.GetImportTaskResp;

// GET /open-apis/drive/v1/import_tasks/:ticket
public class GetImportTaskSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetImportTaskReq req = GetImportTaskReq.newBuilder()
                .ticket("6990281865xxxxxxxx7843")
                .build();

        // 发起请求
        GetImportTaskResp resp = client.drive().v1().importTask().get(req);

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
