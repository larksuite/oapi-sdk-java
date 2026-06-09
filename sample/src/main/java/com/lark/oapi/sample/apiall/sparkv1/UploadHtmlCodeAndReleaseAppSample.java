package com.lark.oapi.sample.apiall.sparkv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.spark.v1.model.*;

import java.io.File;
import java.util.HashMap;

// POST /open-apis/spark/v1/apps/:app_id/upload_and_release_html_code
public class UploadHtmlCodeAndReleaseAppSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        File file = new File("filepath");
        UploadHtmlCodeAndReleaseAppReq req = UploadHtmlCodeAndReleaseAppReq.newBuilder()
                .appId("app_4k6af8utt2s0n")
                .uploadHtmlCodeAndReleaseAppReqBody(UploadHtmlCodeAndReleaseAppReqBody.newBuilder()
                        .file(file)
                        .build())
                .build();

        // 发起请求
        UploadHtmlCodeAndReleaseAppResp resp = client.spark().v1().app().uploadHtmlCodeAndRelease(req);

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
