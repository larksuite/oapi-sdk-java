package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/eco_background_checks/update_result
public class UpdateResultEcoBackgroundCheckSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateResultEcoBackgroundCheckReq req = UpdateResultEcoBackgroundCheckReq.newBuilder()
                .updateResultEcoBackgroundCheckReqBody(UpdateResultEcoBackgroundCheckReqBody.newBuilder()
                        .backgroundCheckId("6931286400470354183")
                        .result("无差异")
                        .resultTime("1660123456789")
                        .operatorRole(1)
                        .reportFileList(new EcoBackgroundCheckReportFile[]{})
                        .build())
                .build();

        // 发起请求
        UpdateResultEcoBackgroundCheckResp resp = client.hire().v1().ecoBackgroundCheck().updateResult(req);

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
