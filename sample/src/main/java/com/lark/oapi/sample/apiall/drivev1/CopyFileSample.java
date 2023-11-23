package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.CopyFileReq;
import com.lark.oapi.service.drive.v1.model.CopyFileReqBody;
import com.lark.oapi.service.drive.v1.model.CopyFileResp;
import com.lark.oapi.service.drive.v1.model.Property;

// POST /open-apis/drive/v1/files/:file_token/copy
public class CopyFileSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CopyFileReq req = CopyFileReq.newBuilder()
                .fileToken("doccngpahSdXrFPIBD4XdIabcef")
                .userIdType("user_id")
                .copyFileReqBody(CopyFileReqBody.newBuilder()
                        .name("test.txt")
                        .type("doc")
                        .folderToken("fldbcO1UuPz8VwnpPx5a92abcef")
                        .extra(new Property[]{})
                        .build())
                .build();

        // 发起请求
        CopyFileResp resp = client.drive().v1().file().copy(req);

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
