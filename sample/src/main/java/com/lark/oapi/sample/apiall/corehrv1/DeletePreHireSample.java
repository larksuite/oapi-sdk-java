package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.DeletePreHireReq;
import com.lark.oapi.service.corehr.v1.model.DeletePreHireResp;

// DELETE /open-apis/corehr/v1/pre_hires/:pre_hire_id
public class DeletePreHireSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeletePreHireReq req = DeletePreHireReq.newBuilder()
                .preHireId("76534545454")
                .build();

        // 发起请求
        DeletePreHireResp resp = client.corehr().v1().preHire().delete(req);

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
