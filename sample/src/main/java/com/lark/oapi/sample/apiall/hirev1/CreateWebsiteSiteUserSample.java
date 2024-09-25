package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.CreateWebsiteSiteUserReq;
import com.lark.oapi.service.hire.v1.model.CreateWebsiteSiteUserResp;
import com.lark.oapi.service.hire.v1.model.WebsiteUser;

// POST /open-apis/hire/v1/websites/:website_id/site_users
public class CreateWebsiteSiteUserSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateWebsiteSiteUserReq req = CreateWebsiteSiteUserReq.newBuilder()
                .websiteId("1618209327096")
                .websiteUser(WebsiteUser.newBuilder()
                        .name("dan27")
                        .email("dan27@163.com")
                        .externalId("6960663240925956621")
                        .mobile("182900291190")
                        .mobileCountryCode("CN_1")
                        .build())
                .build();

        // 发起请求
        CreateWebsiteSiteUserResp resp = client.hire().v1().websiteSiteUser().create(req);

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
