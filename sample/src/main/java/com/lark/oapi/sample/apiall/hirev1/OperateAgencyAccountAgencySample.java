package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/agencies/operate_agency_account
public class OperateAgencyAccountAgencySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        OperateAgencyAccountAgencyReq req = OperateAgencyAccountAgencyReq.newBuilder()
                .operateAgencyAccountAgencyReqBody(OperateAgencyAccountAgencyReqBody.newBuilder()
                        .option(1)
                        .id("7398623155442682156")
                        .reason("这个人特别不负责")
                        .build())
                .build();

        // 发起请求
        OperateAgencyAccountAgencyResp resp = client.hire().v1().agency().operateAgencyAccount(req);

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
