package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.UpdateUserIdUserReq;
import com.lark.oapi.service.contact.v3.model.UpdateUserIdUserReqBody;
import com.lark.oapi.service.contact.v3.model.UpdateUserIdUserResp;

// PATCH /open-apis/contact/v3/users/:user_id/update_user_id
public class UpdateUserIdUserSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateUserIdUserReq req = UpdateUserIdUserReq.newBuilder()
                .userId("")
                .userIdType("user_id")
                .updateUserIdUserReqBody(UpdateUserIdUserReqBody.newBuilder()
                        .newUserId("3e3cf96b")
                        .build())
                .build();

        // 发起请求
        UpdateUserIdUserResp resp = client.contact().user().updateUserId(req);

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
