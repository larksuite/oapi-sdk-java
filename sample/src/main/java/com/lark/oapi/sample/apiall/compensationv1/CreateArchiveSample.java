package com.lark.oapi.sample.apiall.compensationv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.compensation.v1.model.*;

import java.util.HashMap;

// POST /open-apis/compensation/v1/archives
public class CreateArchiveSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateArchiveReq req = CreateArchiveReq.newBuilder()
                .userIdType("open_id")
                .createArchiveReqBody(CreateArchiveReqBody.newBuilder()
                        .uniqueId("123e4567-e89b-42d3-a456-426614174000")
                        .operatorId("7337149697626801708")
                        .userId("7337149697626801708")
                        .effectiveTime("2024-11-12")
                        .currencyId("6863329932261459464")
                        .planId("7431430313074247212")
                        .planTid("7431430313074279980")
                        .changeReasonId("7125907336899888684")
                        .itemValueLists(new ArchiveItemValue[]{})
                        .description("调薪说明")
                        .editRemark("更正调薪说明")
                        .build())
                .build();

        // 发起请求
        CreateArchiveResp resp = client.compensation().v1().archive().create(req);

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
