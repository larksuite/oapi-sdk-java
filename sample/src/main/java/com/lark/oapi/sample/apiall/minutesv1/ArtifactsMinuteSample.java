package com.lark.oapi.sample.apiall.minutesv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.minutes.v1.model.*;

import java.util.HashMap;

// GET /open-apis/minutes/v1/minutes/:minute_token/artifacts
public class ArtifactsMinuteSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ArtifactsMinuteReq req = ArtifactsMinuteReq.newBuilder()
                .minuteToken("obcnq3b9jl72l83w4f149w9c")
                .build();

        // 发起请求
        ArtifactsMinuteResp resp = client.minutes().v1().minute().artifacts(req);

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
