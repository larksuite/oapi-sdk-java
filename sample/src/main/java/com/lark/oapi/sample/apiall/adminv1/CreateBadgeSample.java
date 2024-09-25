package com.lark.oapi.sample.apiall.adminv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.admin.v1.model.Badge;
import com.lark.oapi.service.admin.v1.model.CreateBadgeReq;
import com.lark.oapi.service.admin.v1.model.CreateBadgeResp;
import com.lark.oapi.service.admin.v1.model.I18n;

// POST /open-apis/admin/v1/badges
public class CreateBadgeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateBadgeReq req = CreateBadgeReq.newBuilder()
                .badge(Badge.newBuilder()
                        .name("激励勋章")
                        .explanation("这枚勋章为了激励员工颁发。")
                        .detailImage("75a1949f-d9df-4b46-bc88-dacc51e88f3j")
                        .showImage("03daa74a-159f-49e9-963e-b6c4d76103fj")
                        .i18nName(I18n.newBuilder().build())
                        .i18nExplanation(I18n.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        CreateBadgeResp resp = client.admin().v1().badge().create(req);

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
