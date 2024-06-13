package com.lark.oapi.sample.apiall.baikev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.baike.v1.model.*;

import java.io.File;
import java.util.HashMap;

// POST /open-apis/baike/v1/files/upload
public class UploadFileSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        File file = new File("filepath");
        UploadFileReq req = UploadFileReq.newBuilder()
                .file(com.lark.oapi.service.baike.v1.model.File.newBuilder()
                        .name("示例图片.png")
                        .file(file)
                        .build())
                .build();

        // 发起请求
        UploadFileResp resp = client.baike().v1().file().upload(req);

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
