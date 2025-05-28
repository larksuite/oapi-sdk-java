package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/agencies/get_agency_account
public class GetAgencyAccountAgencySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetAgencyAccountAgencyReq req = GetAgencyAccountAgencyReq.newBuilder()
                .userIdType("union_id")
                .pageToken("eyJvZmZzZXQiOjEsInRpbWVzdGFtcCI6MTY0MDc2NTYzMjA4OCwiaWQiOm51bGx9")
                .pageSize(10)
                .getAgencyAccountAgencyReqBody(GetAgencyAccountAgencyReqBody.newBuilder()
                        .supplierId("7398623155442682156")
                        .status(1)
                        .role(1)
                        .build())
                .build();

        // 发起请求
        GetAgencyAccountAgencyResp resp = client.hire().v1().agency().getAgencyAccount(req);

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
