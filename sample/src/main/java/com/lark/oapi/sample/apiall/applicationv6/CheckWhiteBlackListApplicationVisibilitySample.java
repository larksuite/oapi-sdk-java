package com.lark.oapi.sample.apiall.applicationv6;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v6.model.CheckWhiteBlackListApplicationVisibilityReq;
import com.lark.oapi.service.application.v6.model.CheckWhiteBlackListApplicationVisibilityReqBody;
import com.lark.oapi.service.application.v6.model.CheckWhiteBlackListApplicationVisibilityResp;

// POST /open-apis/application/v6/applications/:app_id/visibility/check_white_black_list
public class CheckWhiteBlackListApplicationVisibilitySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CheckWhiteBlackListApplicationVisibilityReq req = CheckWhiteBlackListApplicationVisibilityReq.newBuilder()
                .appId("cli_a3a3d00b40b8d01b")
                .userIdType("open_id")
                .departmentIdType("department_id")
                .checkWhiteBlackListApplicationVisibilityReqBody(CheckWhiteBlackListApplicationVisibilityReqBody.newBuilder()
                        .userIds(new String[]{})
                        .departmentIds(new String[]{})
                        .groupIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        CheckWhiteBlackListApplicationVisibilityResp resp = client.application().applicationVisibility().checkWhiteBlackList(req);

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
