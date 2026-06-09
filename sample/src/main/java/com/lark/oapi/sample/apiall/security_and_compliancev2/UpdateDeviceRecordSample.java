package com.lark.oapi.sample.apiall.security_and_compliancev2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.security_and_compliance.v2.model.*;

import java.util.HashMap;

// PUT /open-apis/security_and_compliance/v2/device_records/:device_record_id
public class UpdateDeviceRecordSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateDeviceRecordReq req = UpdateDeviceRecordReq.newBuilder()
                .deviceRecordId("7089353870308032531")
                .version("0")
                .updateDeviceRecordReqBody(UpdateDeviceRecordReqBody.newBuilder()
                        .deviceOwnership(0)
                        .deviceStatus(0)
                        .isPublic(false)
                        .build())
                .build();

        // 发起请求
        UpdateDeviceRecordResp resp = client.securityAndCompliance().v2().deviceRecord().update(req);

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
