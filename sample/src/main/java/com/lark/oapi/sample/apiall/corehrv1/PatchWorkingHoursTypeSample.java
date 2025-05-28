package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v1.model.Enum;

// PATCH /open-apis/corehr/v1/working_hours_types/:working_hours_type_id
public class PatchWorkingHoursTypeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchWorkingHoursTypeReq req = PatchWorkingHoursTypeReq.newBuilder()
                .workingHoursTypeId("1616161616")
                .clientToken("12454646")
                .workingHoursType(WorkingHoursType.newBuilder()
                        .code("1")
                        .name(new I18n[]{})
                        .countryRegionIdList(new String[]{})
                        .defaultForJob(true)
                        .active(true)
                        .customFields(new ObjectFieldData[]{})
                        .build())
                .build();

        // 发起请求
        PatchWorkingHoursTypeResp resp = client.corehr().v1().workingHoursType().patch(req);

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
