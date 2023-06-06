package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.ListPreHireReq;
import com.lark.oapi.service.corehr.v1.model.ListPreHireResp;

// GET /open-apis/corehr/v1/pre_hires
public class ListPreHireSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListPreHireReq req = ListPreHireReq.newBuilder()
                .pageToken("1231231987")
                .pageSize("100")
                .preHireIds(new String[]{})
                .build();

        // 发起请求
        ListPreHireResp resp = client.corehr().preHire().list(req);

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
