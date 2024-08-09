package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/applications
public class CreateApplicationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateApplicationReq req = CreateApplicationReq.newBuilder()
                .userIdType("user_id")
                .createApplicationReqBody(CreateApplicationReqBody.newBuilder()
                        .talentId("12312312312")
                        .jobId("12312312312")
                        .userId("6930815272790114324")
                        .resumeSourceId("7115289562569591070")
                        .applicationPreferredCityCodeList(new String[]{})
                        .build())
                .build();

        // 发起请求
        CreateApplicationResp resp = client.hire().v1().application().create(req);

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
