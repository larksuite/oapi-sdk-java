package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.AddEnumOptionCommonDataMetaDataReq;
import com.lark.oapi.service.corehr.v1.model.AddEnumOptionCommonDataMetaDataReqBody;
import com.lark.oapi.service.corehr.v1.model.AddEnumOptionCommonDataMetaDataResp;
import com.lark.oapi.service.corehr.v1.model.EnumFieldOption;

// POST /open-apis/corehr/v1/common_data/meta_data/add_enum_option
public class AddEnumOptionCommonDataMetaDataSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        AddEnumOptionCommonDataMetaDataReq req = AddEnumOptionCommonDataMetaDataReq.newBuilder()
                .clientToken("6727817538283013641")
                .addEnumOptionCommonDataMetaDataReqBody(AddEnumOptionCommonDataMetaDataReqBody.newBuilder()
                        .objectApiName("probation_management")
                        .enumFieldApiName("final_assessment_grade")
                        .enumFieldOptions(new EnumFieldOption[]{})
                        .build())
                .build();

        // 发起请求
        AddEnumOptionCommonDataMetaDataResp resp = client.corehr().v1().commonDataMetaData().addEnumOption(req);

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
