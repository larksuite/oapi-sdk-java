package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// PATCH /open-apis/corehr/v2/locations/:location_id
public class PatchLocationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchLocationReq req = PatchLocationReq.newBuilder()
                .locationId("1616161616")
                .clientToken("12454646")
                .locationUpdate(LocationUpdate.newBuilder()
                        .parentId("4719168654814483759")
                        .names(new I18n[]{})
                        .active(true)
                        .effectiveTime("2020-05-02")
                        .code("12456")
                        .descriptions(new I18n[]{})
                        .locationUsages(new Enum[]{})
                        .workingHoursTypeId("4690238309151997779")
                        .locale(Enum.newBuilder().build())
                        .timeZoneId("123456789")
                        .displayLanguageId("123456789")
                        .build())
                .build();

        // 发起请求
        PatchLocationResp resp = client.corehr().v2().location().patch(req);

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
