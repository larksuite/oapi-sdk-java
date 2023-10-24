package com.lark.oapi.sample.apiall.okrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.okr.v1.model.*;
import java.util.HashMap;

// PATCH /open-apis/okr/v1/metric_sources/:metric_source_id/tables/:metric_table_id/items/batch_update
public class BatchUpdateMetricSourceTableItemSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  BatchUpdateMetricSourceTableItemReq req = BatchUpdateMetricSourceTableItemReq.newBuilder()
			 .metricSourceId("7041857032248410131")
			 .metricTableId("7041857032248410131")
			 .userIdType("open_id")
			.batchUpdateMetricSourceTableItemReqBody(BatchUpdateMetricSourceTableItemReqBody.newBuilder()
				 .items(new MetricItemRequest[]{})
				  .build())
			 .build();

	  // 发起请求
	  BatchUpdateMetricSourceTableItemResp resp = client.okr().metricSourceTableItem().batchUpdate(req);

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
