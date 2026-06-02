package com.lark.oapi.sample.apiall.applicationv5;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v5.model.*;

import java.util.HashMap;

// GET /open-apis/application/v5/applications/favourite
public class FavouriteApplicationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        FavouriteApplicationReq req = FavouriteApplicationReq.newBuilder()
                .language("zh_cn")
                .pageToken("7153511712153412356")
                .pageSize(10)
                .build();

        // 发起请求
        FavouriteApplicationResp resp = client.application().v5().application().favourite(req);

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
