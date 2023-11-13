package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.GetWorkingHoursTypeReq;
import com.lark.oapi.service.corehr.v1.model.GetWorkingHoursTypeResp;

// GET /open-apis/corehr/v1/working_hours_types/:working_hours_type_id
public class GetWorkingHoursTypeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetWorkingHoursTypeReq req = GetWorkingHoursTypeReq.newBuilder()
                .workingHoursTypeId("1212")
                .build();

        // 发起请求
        GetWorkingHoursTypeResp resp = client.corehr().workingHoursType().get(req);

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
