package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.*;

// POST /open-apis/bitable/v1/apps/:app_token/tables/:table_id/fields
public class CreateAppTableFieldSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateAppTableFieldReq req = CreateAppTableFieldReq.newBuilder()
                .appToken("appbcbWCzen6D8dezhoCH2RpMAh")
                .tableId("tblsRc9GRRXKqhvW")
                .clientToken("fe599b60-450f-46ff-b2ef-9f6675625b97")
                .appTableField(AppTableField.newBuilder()
                        .fieldName("字段名称")
                        .type(1)
                        .property(AppTableFieldProperty.newBuilder().build())
                        .description(AppTableFieldDescription.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        CreateAppTableFieldResp resp = client.bitable().appTableField().create(req);

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
