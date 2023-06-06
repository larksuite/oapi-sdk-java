package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.GetNationalIdTypeReq;
import com.lark.oapi.service.corehr.v1.model.GetNationalIdTypeResp;

// GET /open-apis/corehr/v1/national_id_types/:national_id_type_id
public class GetNationalIdTypeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetNationalIdTypeReq req = GetNationalIdTypeReq.newBuilder()
                .nationalIdTypeId("121515")
                .build();

        // 发起请求
        GetNationalIdTypeResp resp = client.corehr().nationalIdType().get(req);

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
