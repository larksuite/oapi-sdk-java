package com.lark.oapi.sample.apiall.attendancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.attendance.v1.model.QueryUserSettingReq;
import com.lark.oapi.service.attendance.v1.model.QueryUserSettingReqBody;
import com.lark.oapi.service.attendance.v1.model.QueryUserSettingResp;

// GET /open-apis/attendance/v1/user_settings/query
public class QueryUserSettingSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryUserSettingReq req = QueryUserSettingReq.newBuilder()
                .employeeType("employee_id")
                .queryUserSettingReqBody(QueryUserSettingReqBody.newBuilder()
                        .userIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        QueryUserSettingResp resp = client.attendance().v1().userSetting().query(req);

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
