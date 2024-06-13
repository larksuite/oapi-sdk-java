package com.lark.oapi.sample.apiall.applicationv6;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v6.model.*;

import java.util.HashMap;

// PATCH /open-apis/application/v6/applications/:app_id/contacts_range
public class PatchApplicationContactsRangeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchApplicationContactsRangeReq req = PatchApplicationContactsRangeReq.newBuilder()
                .appId("cli_dsfjksdfee1")
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .patchApplicationContactsRangeReqBody(PatchApplicationContactsRangeReqBody.newBuilder()
                        .contactsRangeType("some")
                        .addVisibleList(AppContactsRangeIdList.newBuilder().build())
                        .delVisibleList(AppContactsRangeIdList.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        PatchApplicationContactsRangeResp resp = client.application().v6().applicationContactsRange().patch(req);

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
