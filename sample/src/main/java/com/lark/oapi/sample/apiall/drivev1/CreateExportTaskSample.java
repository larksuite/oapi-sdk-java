package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.CreateExportTaskReq;
import com.lark.oapi.service.drive.v1.model.CreateExportTaskResp;
import com.lark.oapi.service.drive.v1.model.ExportTask;

// POST /open-apis/drive/v1/export_tasks
public class CreateExportTaskSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateExportTaskReq req = CreateExportTaskReq.newBuilder()
                .exportTask(ExportTask.newBuilder()
                        .fileExtension("pdf")
                        .token("doccnxe5OxxxxxxxSNdsJviENsk")
                        .type("doc")
                        .subId("tblKz5D60T4JlfcT")
                        .build())
                .build();

        // 发起请求
        CreateExportTaskResp resp = client.drive().exportTask().create(req);

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
