package com.lark.oapi.sample.apiall.security_and_compliancev2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.security_and_compliance.v2.model.*;

import java.util.HashMap;

// POST /open-apis/security_and_compliance/v2/device_records
public class CreateDeviceRecordSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateDeviceRecordReq req = CreateDeviceRecordReq.newBuilder()
                .createDeviceRecordReqBody(CreateDeviceRecordReqBody.newBuilder()
                        .deviceSystem(0)
                        .deviceOwnership(0)
                        .deviceStatus(0)
                        .isPublic(false)
                        .serialNumber("C02DTHRMML7H")
                        .diskSerialNumber("CC344362-5990-5A68-8DDD-64A23C99FA0C")
                        .uuid("621CDFF0-13D0-5AB1-9ADC-5F560095F6ED")
                        .macAddress("ac:de:48:00:11:21")
                        .androidId("02a11ac4a83b918e")
                        .idfv("968F0E5C-C297-4122-ACB6-102494DEFD9A")
                        .aaid("ff3c2237-cd76-4331-9d72-0a4470854567")
                        .build())
                .build();

        // 发起请求
        CreateDeviceRecordResp resp = client.securityAndCompliance().v2().deviceRecord().create(req);

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
