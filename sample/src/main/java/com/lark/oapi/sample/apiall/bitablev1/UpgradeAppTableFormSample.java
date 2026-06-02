package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.*;

import java.util.HashMap;

// POST /open-apis/bitable/v1/apps/:app_token/tables/:table_id/forms/:form_id/upgrade
public class UpgradeAppTableFormSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpgradeAppTableFormReq req = UpgradeAppTableFormReq.newBuilder()
                .appToken("bascnv1jIEppJdTCn3jOosabcef")
                .tableId("tblz8nadEUdxNMt5")
                .formId("vew6oMbAa4")
                .upgradeAppTableFormReqBody(UpgradeAppTableFormReqBody.newBuilder()
                        .formName("文档问题反馈")
                        .displayMode("traditional")
                        .build())
                .build();

        // 发起请求
        UpgradeAppTableFormResp resp = client.bitable().v1().appTableForm().upgrade(req);

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
