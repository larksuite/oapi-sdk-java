package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.CreateAppReq;
import com.lark.oapi.service.bitable.v1.model.CreateAppResp;
import com.lark.oapi.service.bitable.v1.model.ReqApp;

// POST /open-apis/bitable/v1/apps
public class CreateAppSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateAppReq req = CreateAppReq.newBuilder()
                .reqApp(ReqApp.newBuilder()
                        .name("一篇新的多维表格")
                        .folderToken("fldbcoh8O99CIMltVc")
                        .timeZone("Asia/Macau")
                        .build())
                .build();

        // 发起请求
        CreateAppResp resp = client.bitable().v1().app().create(req);

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
