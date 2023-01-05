package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.UploadFinishFileReq;
import com.lark.oapi.service.drive.v1.model.UploadFinishFileReqBody;
import com.lark.oapi.service.drive.v1.model.UploadFinishFileResp;

// POST /open-apis/drive/v1/files/upload_finish
public class UploadFinishFileSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UploadFinishFileReq req = UploadFinishFileReq.newBuilder()
                .uploadFinishFileReqBody(UploadFinishFileReqBody.newBuilder()
                        .uploadId("7111211691345512356")
                        .blockNum(1)
                        .build())
                .build();

        // 发起请求
        UploadFinishFileResp resp = client.drive().file().uploadFinish(req);

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
