package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.PatchGroupReq;
import com.lark.oapi.service.contact.v3.model.PatchGroupReqBody;
import com.lark.oapi.service.contact.v3.model.PatchGroupResp;

// PATCH /open-apis/contact/v3/group/:group_id
public class PatchGroupSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchGroupReq req = PatchGroupReq.newBuilder()
                .groupId("g187131")
                .patchGroupReqBody(PatchGroupReqBody.newBuilder()
                        .name("外包 IT 用户组")
                        .description("IT 外包用户组，需要进行细粒度权限管控")
                        .build())
                .build();

        // 发起请求
        PatchGroupResp resp = client.contact().group().patch(req);

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
