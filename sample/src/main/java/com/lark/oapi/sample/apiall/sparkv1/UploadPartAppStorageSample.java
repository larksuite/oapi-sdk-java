package com.lark.oapi.sample.apiall.sparkv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.spark.v1.model.*;

import java.io.File;
import java.util.HashMap;

// POST /open-apis/spark/v1/apps/:app_id/storage/upload/part
public class UploadPartAppStorageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        File file = new File("filepath");
        UploadPartAppStorageReq req = UploadPartAppStorageReq.newBuilder()
                .appId("app_4jcn5n11bpf5v")
                .uploadPartAppStorageReqBody(UploadPartAppStorageReqBody.newBuilder()
                        .uploadId("upload_abc123xyz456")
                        .chunkIndex(1)
                        .file(file)
                        .chunkCheckSum("ef176a6c424f954fa42d4cde03949897")
                        .build())
                .build();

        // 发起请求
        UploadPartAppStorageResp resp = client.spark().v1().appStorage().uploadPart(req);

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
