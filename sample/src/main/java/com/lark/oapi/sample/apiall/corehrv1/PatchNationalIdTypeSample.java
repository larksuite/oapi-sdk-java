package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;
import com.lark.oapi.service.corehr.v1.model.Enum;

// PATCH /open-apis/corehr/v1/national_id_types/:national_id_type_id
public class PatchNationalIdTypeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchNationalIdTypeReq req = PatchNationalIdTypeReq.newBuilder()
                .nationalIdTypeId("1616161616")
                .clientToken("12454646")
                .nationalIdType(NationalIdType.newBuilder()
                        .countryRegionId("6862995747139225096")
                        .name(new I18n[]{})
                        .active(true)
                        .validationRule("")
                        .validationRuleDescription(new I18n[]{})
                        .code("AUS-TFN")
                        .identificationType(Enum.newBuilder().build())
                        .customFields(new ObjectFieldData[]{})
                        .build())
                .build();

        // 发起请求
        PatchNationalIdTypeResp resp = client.corehr().nationalIdType().patch(req);

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
