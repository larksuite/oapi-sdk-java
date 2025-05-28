package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.*;

import java.util.HashMap;

// DELETE /open-apis/drive/v1/permissions/:token/members/:member_id
public class DeletePermissionMemberSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeletePermissionMemberReq req = DeletePermissionMemberReq.newBuilder()
                .token("doccnBKgoMyY5OMbUG6FioTXuBe")
                .memberId("ou_7dab8a3d3cdcc9da365777c7ad535d62")
                .type("doc")
                .memberType("openid")
                .deletePermissionMemberReqBody(DeletePermissionMemberReqBody.newBuilder()
                        .type("user")
                        .permType("container")
                        .build())
                .build();

        // 发起请求
        DeletePermissionMemberResp resp = client.drive().v1().permissionMember().delete(req);

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
