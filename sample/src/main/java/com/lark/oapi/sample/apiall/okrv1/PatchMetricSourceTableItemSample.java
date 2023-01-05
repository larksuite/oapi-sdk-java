package com.lark.oapi.sample.apiall.okrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.okr.v1.model.PatchMetricSourceTableItemReq;
import com.lark.oapi.service.okr.v1.model.PatchMetricSourceTableItemReqBody;
import com.lark.oapi.service.okr.v1.model.PatchMetricSourceTableItemResp;

// PATCH /open-apis/okr/v1/metric_sources/:metric_source_id/tables/:metric_table_id/items/:metric_item_id
public class PatchMetricSourceTableItemSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchMetricSourceTableItemReq req = PatchMetricSourceTableItemReq.newBuilder()
                .metricSourceId("7041857032248410131")
                .metricTableId("7041857032248410131")
                .metricItemId("7041857032248410131")
                .userIdType("open_id")
                .patchMetricSourceTableItemReqBody(PatchMetricSourceTableItemReqBody.newBuilder()
                        .metricInitialValue(1.0)
                        .metricTargetValue(3.0)
                        .metricCurrentValue(2.0)
                        .supportedUserId("7041857032248410131")
                        .build())
                .build();

        // 发起请求
        PatchMetricSourceTableItemResp resp = client.okr().metricSourceTableItem().patch(req);

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
