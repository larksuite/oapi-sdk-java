package com.lark.oapi.sample.apiall.drivev2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v2.model.PatchPermissionPublicReq;
import com.lark.oapi.service.drive.v2.model.PatchPermissionPublicResp;
import com.lark.oapi.service.drive.v2.model.PermissionPublic;

// PATCH /open-apis/drive/v2/permissions/:token/public
public class PatchPermissionPublicSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchPermissionPublicReq req = PatchPermissionPublicReq.newBuilder()
                .token("doccnBKgoMyY5OMbUG6FioTXuBe")
                .type("doc")
                .permissionPublic(PermissionPublic.newBuilder()
                        .externalAccessEntity("open")
                        .securityEntity("anyone_can_view")
                        .commentEntity("anyone_can_view")
                        .shareEntity("anyone")
                        .manageCollaboratorEntity("collaborator_can_view")
                        .linkShareEntity("tenant_readable")
                        .copyEntity("anyone_can_view")
                        .build())
                .build();

        // 发起请求
        PatchPermissionPublicResp resp = client.drive().v2().permissionPublic().patch(req);

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
