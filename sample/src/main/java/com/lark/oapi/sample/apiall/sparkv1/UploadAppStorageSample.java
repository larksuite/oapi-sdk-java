package com.lark.oapi.sample.apiall.sparkv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.spark.v1.model.*;

import java.io.File;
import java.util.HashMap;

// POST /open-apis/spark/v1/apps/:app_id/storage/upload
public class UploadAppStorageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        File file = new File("filepath");
        UploadAppStorageReq req = UploadAppStorageReq.newBuilder()
                .appId("app_4jcn5n11bpf5v")
                .uploadAppStorageReqBody(UploadAppStorageReqBody.newBuilder()
                        .fileName("file_name")
                        .checkSum("f8d80a7f68b820d99f5612b952140319991d6599d95f29699d076684b0977f99")
                        .file(file)
                        .build())
                .build();

        // 发起请求
        UploadAppStorageResp resp = client.spark().v1().appStorage().upload(req);

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
