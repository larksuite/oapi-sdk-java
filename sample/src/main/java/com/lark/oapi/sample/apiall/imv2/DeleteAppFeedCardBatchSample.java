package com.lark.oapi.sample.apiall.imv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v2.model.DeleteAppFeedCardBatchReq;
import com.lark.oapi.service.im.v2.model.DeleteAppFeedCardBatchReqBody;
import com.lark.oapi.service.im.v2.model.DeleteAppFeedCardBatchResp;
import com.lark.oapi.service.im.v2.model.UserOpenAppFeedCardDeleter;

// DELETE /open-apis/im/v2/app_feed_card/batch
public class DeleteAppFeedCardBatchSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteAppFeedCardBatchReq req = DeleteAppFeedCardBatchReq.newBuilder()
                .userIdType("open_id")
                .deleteAppFeedCardBatchReqBody(DeleteAppFeedCardBatchReqBody.newBuilder()
                        .feedCards(new UserOpenAppFeedCardDeleter[]{})
                        .build())
                .build();

        // 发起请求
        DeleteAppFeedCardBatchResp resp = client.im().v2().appFeedCardBatch().delete(req);

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
