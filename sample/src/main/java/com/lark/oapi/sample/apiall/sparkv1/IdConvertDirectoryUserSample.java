package com.lark.oapi.sample.apiall.sparkv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.spark.v1.model.*;

import java.util.HashMap;

// POST /open-apis/spark/v1/directory/user/id_convert
public class IdConvertDirectoryUserSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        IdConvertDirectoryUserReq req = IdConvertDirectoryUserReq.newBuilder()
                .idConvertDirectoryUserReqBody(IdConvertDirectoryUserReqBody.newBuilder()
                        .idConvertType(10)
                        .ids(new String[]{})
                        .build())
                .build();

        // 发起请求
        IdConvertDirectoryUserResp resp = client.spark().v1().directoryUser().idConvert(req);

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
