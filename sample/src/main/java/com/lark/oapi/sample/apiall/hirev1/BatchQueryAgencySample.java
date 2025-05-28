package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/agencies/batch_query
public class BatchQueryAgencySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchQueryAgencyReq req = BatchQueryAgencyReq.newBuilder()
                .userIdType("user_id")
                .pageToken("eyJvZmZzZXQiOjEsInRpbWVzdGFtcCI6MTY0MDc2NTYzMjA4OCwiaWQiOm51bGx9")
                .pageSize(10)
                .batchQueryAgencyReqBody(BatchQueryAgencyReqBody.newBuilder()
                        .agencySupplierIdList(new String[]{})
                        .keyword("猎头")
                        .filterList(new CommonFilter[]{})
                        .build())
                .build();

        // 发起请求
        BatchQueryAgencyResp resp = client.hire().v1().agency().batchQuery(req);

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
