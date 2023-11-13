package com.lark.oapi.sample.apiall.lingov1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.lingo.v1.model.UploadFileReq;
import com.lark.oapi.service.lingo.v1.model.UploadFileResp;

import java.io.File;

// POST /open-apis/lingo/v1/files/upload
public class UploadFileSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        File file = new File("filepath");
        UploadFileReq req = UploadFileReq.newBuilder()
                .file(com.lark.oapi.service.lingo.v1.model.File.newBuilder()
                        .name("示例图片.png")
                        .file(file)
                        .build())
                .build();

        // 发起请求
        UploadFileResp resp = client.lingo().file().upload(req);

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
