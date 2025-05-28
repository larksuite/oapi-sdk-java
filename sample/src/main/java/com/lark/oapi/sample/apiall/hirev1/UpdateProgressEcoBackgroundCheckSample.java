package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/eco_background_checks/update_progress
public class UpdateProgressEcoBackgroundCheckSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateProgressEcoBackgroundCheckReq req = UpdateProgressEcoBackgroundCheckReq.newBuilder()
                .updateProgressEcoBackgroundCheckReqBody(UpdateProgressEcoBackgroundCheckReqBody.newBuilder()
                        .backgroundCheckId("6931286400470354183")
                        .stageId("6931286400470354183")
                        .stageEnName("stage report")
                        .stageName("阶段报告")
                        .stageTime("1660123456789")
                        .result("通过")
                        .operatorRole(1)
                        .reportFileList(new EcoBackgroundCheckReportFile[]{})
                        .build())
                .build();

        // 发起请求
        UpdateProgressEcoBackgroundCheckResp resp = client.hire().v1().ecoBackgroundCheck().updateProgress(req);

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
