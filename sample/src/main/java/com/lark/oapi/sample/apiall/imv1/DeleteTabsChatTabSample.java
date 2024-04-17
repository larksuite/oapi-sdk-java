package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.DeleteTabsChatTabReq;
import com.lark.oapi.service.im.v1.model.DeleteTabsChatTabReqBody;
import com.lark.oapi.service.im.v1.model.DeleteTabsChatTabResp;

// DELETE /open-apis/im/v1/chats/:chat_id/chat_tabs/delete_tabs
public class DeleteTabsChatTabSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteTabsChatTabReq req = DeleteTabsChatTabReq.newBuilder()
                .chatId("oc_a0553eda9014c201e6969b478895c230")
                .deleteTabsChatTabReqBody(DeleteTabsChatTabReqBody.newBuilder()
                        .tabIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        DeleteTabsChatTabResp resp = client.im().v1().chatTab().deleteTabs(req);

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
