package com.lark.oapi.sample.apiall.security_and_compliancev2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.security_and_compliance.v2.model.*;

import java.util.HashMap;

// GET /open-apis/security_and_compliance/v2/device_records
public class ListDeviceRecordSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListDeviceRecordReq req = ListDeviceRecordReq.newBuilder()
                .pageSize(100)
                .pageToken("7394463407091023892")
                .deviceRecordId("7089353870308032531")
                .currentUserId("ou_b25e90585ef8c1adac4b379c2e257906")
                .userIdType("open_id")
                .deviceName("Q9C6RYMFDK")
                .serialNumber("C02DTHRMML7H")
                .diskSerialNumber("CC344362-5990-5A68-8DDD-64A23C99FA0C")
                .macAddress("ac:de:48:00:11:21")
                .androidId("02a11ac4a83b918e")
                .uuid("4C4C4544-0052-5A10-804E-B6C04F324433")
                .idfv("968F0E5C-C297-4122-ACB6-102494DEFD9A")
                .aaid("ff3c2237-cd76-4331-9d72-0a4470854567")
                .deviceOwnership(0)
                .deviceStatus(0)
                .deviceTerminalType(0)
                .os(0)
                .latestUserId("ou_b25e90585ef8c1adac4b379c2e257906")
                .did("7089353870308032531")
                .isManaged(false)
                .mdmDeviceId("123abc")
                .mdmProviderName("Workspace_ONE")
                .build();

        // 发起请求
        ListDeviceRecordResp resp = client.securityAndCompliance().v2().deviceRecord().list(req);

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
