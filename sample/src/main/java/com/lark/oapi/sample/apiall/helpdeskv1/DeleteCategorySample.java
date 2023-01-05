package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.DeleteCategoryReq;
import com.lark.oapi.service.helpdesk.v1.model.DeleteCategoryResp;

// DELETE /open-apis/helpdesk/v1/categories/:id
public class DeleteCategorySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteCategoryReq req = DeleteCategoryReq.newBuilder()
                .id("6948728206392295444")
                .build();

        // 发起请求
        DeleteCategoryResp resp = client.helpdesk().category().delete(req);

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
