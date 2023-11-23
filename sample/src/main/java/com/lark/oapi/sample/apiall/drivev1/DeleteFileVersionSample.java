package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.DeleteFileVersionReq;
import com.lark.oapi.service.drive.v1.model.DeleteFileVersionResp;

// DELETE /open-apis/drive/v1/files/:file_token/versions/:version_id
public class DeleteFileVersionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteFileVersionReq req = DeleteFileVersionReq.newBuilder()
                .fileToken("doxbcyvqZlSc9WlHvQMlSJwUrsb")
                .versionId("file_version")
                .objType("doc/docs/sheet/bitable")
                .userIdType("open_id")
                .build();

        // 发起请求
        DeleteFileVersionResp resp = client.drive().v1().fileVersion().delete(req);

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
