package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;
import java.util.HashMap;
import com.lark.oapi.service.corehr.v1.model.Enum;

// GET /open-apis/corehr/v1/leaves/leave_request_history
public class LeaveRequestHistoryLeaveSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  LeaveRequestHistoryLeaveReq req = LeaveRequestHistoryLeaveReq.newBuilder()
			 .pageToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9")
			 .pageSize("100")
			 .employmentIdList(new String[]{})
			 .initiatorIdList(new String[]{})
			 .leaveRequestStatus(new String[]{})
			 .leaveTypeIdList(new String[]{})
			 .leaveStartDateMin("2022-07-20 morning")
			 .leaveStartDateMax("2022-07-20 morning")
			 .leaveEndDateMin("2022-07-20 morning")
			 .leaveEndDateMax("2022-07-20 morning")
			 .leaveSubmitDateMin("2022-07-20 morning")
			 .leaveSubmitDateMax("2022-07-20 morning")
			 .userIdType("people_corehr_id")
			 .leaveUpdateTimeMin("2022-10-24 10:00:00")
			 .leaveUpdateTimeMax("2022-10-24 10:00:00")
			 .returnDetail(false)
			 .leaveTermType(0)
			 .timeZone("Asia/Shanghai")
			 .dataSource(1)
			 .dbUpdateTimeMin("2022-10-24 10:00:00")
			 .dbUpdateTimeMax("2022-10-24 10:00:00")
			 .wdNeedAmountZeroRecords(false)
			 .wdNeedDeniedAndCanceledRecord(false)
			 .wdPaidType(1)
			 .build();

	  // 发起请求
	  LeaveRequestHistoryLeaveResp resp = client.corehr().v1().leave().leaveRequestHistory(req);

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
