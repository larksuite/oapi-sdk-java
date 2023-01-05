package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.EhrImportTask;
import com.lark.oapi.service.hire.v1.model.PatchEhrImportTaskReq;
import com.lark.oapi.service.hire.v1.model.PatchEhrImportTaskResp;

// PATCH /open-apis/hire/v1/ehr_import_tasks/:ehr_import_task_id
public class PatchEhrImportTaskSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchEhrImportTaskReq req = PatchEhrImportTaskReq.newBuilder()
                .ehrImportTaskId("623455234")
                .ehrImportTask(EhrImportTask.newBuilder()
                        .failReason("当前HC不可用")
                        .redirectUrl("https://example.com")
                        .state(1)
                        .build())
                .build();

        // 发起请求
        PatchEhrImportTaskResp resp = client.hire().ehrImportTask().patch(req);

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
