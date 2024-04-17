package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.UploadPartFileReq;
import com.lark.oapi.service.drive.v1.model.UploadPartFileReqBody;
import com.lark.oapi.service.drive.v1.model.UploadPartFileResp;

import java.io.File;

// POST /open-apis/drive/v1/files/upload_part
public class UploadPartFileSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        File file = new File("filepath");
        UploadPartFileReq req = UploadPartFileReq.newBuilder()
                .uploadPartFileReqBody(UploadPartFileReqBody.newBuilder()
                        .uploadId("7111211691345512356")
                        .seq(0)
                        .size(4194304)
                        .checksum("12342388237783212356")
                        .file(file)
                        .build())
                .build();

        // 发起请求
        UploadPartFileResp resp = client.drive().v1().file().uploadPart(req);

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
