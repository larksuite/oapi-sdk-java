package com.lark.oapi.sample.apiall.momentsv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.moments.v1.model.*;

import java.util.HashMap;

// GET /open-apis/moments/v1/posts/:post_id
public class GetPostSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetPostReq req = GetPostReq.newBuilder()
                .postId("6934510454161014804")
                .userIdType("user_id")
                .build();

        // 发起请求
        GetPostResp resp = client.moments().v1().post().get(req);

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
