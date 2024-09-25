package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.BatchQueryMetaReq;
import com.lark.oapi.service.drive.v1.model.BatchQueryMetaResp;
import com.lark.oapi.service.drive.v1.model.MetaRequest;
import com.lark.oapi.service.drive.v1.model.RequestDoc;

// POST /open-apis/drive/v1/metas/batch_query
public class BatchQueryMetaSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchQueryMetaReq req = BatchQueryMetaReq.newBuilder()
                .userIdType("user_id")
                .metaRequest(MetaRequest.newBuilder()
                        .requestDocs(new RequestDoc[]{})
                        .withUrl(false)
                        .build())
                .build();

        // 发起请求
        BatchQueryMetaResp resp = client.drive().v1().meta().batchQuery(req);

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
