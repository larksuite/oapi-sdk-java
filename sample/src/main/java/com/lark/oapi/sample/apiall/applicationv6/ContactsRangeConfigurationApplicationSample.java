package com.lark.oapi.sample.apiall.applicationv6;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v6.model.ContactsRangeConfigurationApplicationReq;
import com.lark.oapi.service.application.v6.model.ContactsRangeConfigurationApplicationResp;

// GET /open-apis/application/v6/applications/:app_id/contacts_range_configuration
public class ContactsRangeConfigurationApplicationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ContactsRangeConfigurationApplicationReq req = ContactsRangeConfigurationApplicationReq.newBuilder()
                .appId("cli_9b445f5258795107")
                .pageSize(50)
                .pageToken("new-e3c5a0627cdf0c2e057da7257b90376a")
                .departmentIdType("open_department_id")
                .userIdType("user_id")
                .build();

        // 发起请求
        ContactsRangeConfigurationApplicationResp resp = client.application().v6().application().contactsRangeConfiguration(req);

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
