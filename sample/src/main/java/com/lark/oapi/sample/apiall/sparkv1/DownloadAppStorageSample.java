package com.lark.oapi.sample.apiall.sparkv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.spark.v1.model.*;

import java.io.File;
import java.util.HashMap;

// GET /open-apis/spark/v1/apps/:app_id/storage
public class DownloadAppStorageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        File file = new File("filepath");
        DownloadAppStorageReq req = DownloadAppStorageReq.newBuilder()
                .appId("app_4jcn5n11bpf5v")
                .fileKey("1859988692091946")
                .fileUrl("/app/app_4jmwuym484u90/runtime/api/v1/storage/object/bucket_aadju74v6daba/1859988692091946")
                .build();

        // 发起请求
        DownloadAppStorageResp resp = client.spark().v1().appStorage().download(req);

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
