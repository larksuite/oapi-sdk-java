package com.lark.oapi.sample.apiall.agentv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.agent.v1.model.*;

import java.io.File;

// POST /open-apis/agent/v1/files
public class CreateFileSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        File file = new File("filepath");
        CreateFileReq req =
                CreateFileReq.newBuilder()
                        .createFileReqBody(
                                CreateFileReqBody.newBuilder()
                                        .file(file)
                                        .uuid("3f6c1e0a-7b1d-4a52-8c0e-9d2f4b6a8c10")
                                        .filename("chart.png")
                                        .build())
                        .build();

        // 发起请求
        CreateFileResp resp = client.agent().v1().file().create(req);

        // 处理服务端错误
        if (!resp.success()) {
            System.out.println(
                    String.format(
                            "code:%s,msg:%s,reqId:%s",
                            resp.getCode(), resp.getMsg(), resp.getRequestId()));
            return;
        }

        // 业务数据处理
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
    }
}
