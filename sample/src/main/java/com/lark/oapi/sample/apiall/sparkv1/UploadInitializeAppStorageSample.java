package com.lark.oapi.sample.apiall.sparkv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.spark.v1.model.*;

import java.util.HashMap;

// POST /open-apis/spark/v1/apps/:app_id/storage/upload/initialize
public class UploadInitializeAppStorageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UploadInitializeAppStorageReq req = UploadInitializeAppStorageReq.newBuilder()
                .appId("app_4jcn5n11bpf5v")
                .uploadInitializeAppStorageReqBody(UploadInitializeAppStorageReqBody.newBuilder()
                        .fileName("上传文件名称示例")
                        .fileSize(104857600)
                        .mimeType("text/plain; charset=utf-8")
                        .build())
                .build();

        // 发起请求
        UploadInitializeAppStorageResp resp = client.spark().v1().appStorage().uploadInitialize(req);

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
