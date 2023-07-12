package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.GetFileVersionReq;
import com.lark.oapi.service.drive.v1.model.GetFileVersionResp;

// GET /open-apis/drive/v1/files/:file_token/versions/:version_id
public class GetFileVersionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetFileVersionReq req = GetFileVersionReq.newBuilder()
                .fileToken("shtbcqqoXZJaKYrfN5IHQg4sVFZ")
                .versionId("file_version")
                .objType("doc/sheet/bitable/docx")
                .userIdType("open_id")
                .build();

        // 发起请求
        GetFileVersionResp resp = client.drive().fileVersion().get(req);

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
