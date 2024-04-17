package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.DownloadExportTaskReq;
import com.lark.oapi.service.drive.v1.model.DownloadExportTaskResp;

// GET /open-apis/drive/v1/export_tasks/file/:file_token/download
public class DownloadExportTaskSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DownloadExportTaskReq req = DownloadExportTaskReq.newBuilder()
                .fileToken("boxcnNAlfwHxxxxxxxxxxSaLSec")
                .build();

        // 发起请求
        DownloadExportTaskResp resp = client.drive().v1().exportTask().download(req);

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
