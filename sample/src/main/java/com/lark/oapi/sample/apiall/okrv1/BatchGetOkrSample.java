package com.lark.oapi.sample.apiall.okrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.okr.v1.model.BatchGetOkrReq;
import com.lark.oapi.service.okr.v1.model.BatchGetOkrResp;

// GET /open-apis/okr/v1/okrs/batch_get
public class BatchGetOkrSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchGetOkrReq req = BatchGetOkrReq.newBuilder()
                .userIdType("open_id")
                .okrIds(new String[]{})
                .lang("zh_cn")
                .build();

        // 发起请求
        BatchGetOkrResp resp = client.okr().okr().batchGet(req);

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
