package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v1.model.Enum;

// POST /open-apis/corehr/v1/working_hours_types
public class CreateWorkingHoursTypeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateWorkingHoursTypeReq req = CreateWorkingHoursTypeReq.newBuilder()
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
        CreateWorkingHoursTypeResp resp = client.corehr().v1().workingHoursType().create(req);

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
