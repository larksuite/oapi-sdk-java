package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.QueryOffboardingReq;
import com.lark.oapi.service.corehr.v1.model.QueryOffboardingReqBody;
import com.lark.oapi.service.corehr.v1.model.QueryOffboardingResp;

// POST /open-apis/corehr/v1/offboardings/query
public class QueryOffboardingSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryOffboardingReq req = QueryOffboardingReq.newBuilder()
                .queryOffboardingReqBody(QueryOffboardingReqBody.newBuilder()
                        .active(true)
                        .offboardingReasonUniqueIdentifier(new String[]{})
                        .build())
                .build();

        // 发起请求
        QueryOffboardingResp resp = client.corehr().offboarding().query(req);

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
