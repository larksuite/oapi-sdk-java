package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.CreateTalentExternalInfoReq;
import com.lark.oapi.service.hire.v1.model.CreateTalentExternalInfoReqBody;
import com.lark.oapi.service.hire.v1.model.CreateTalentExternalInfoResp;

// POST /open-apis/hire/v1/talents/:talent_id/external_info
public class CreateTalentExternalInfoSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateTalentExternalInfoReq req = CreateTalentExternalInfoReq.newBuilder()
                .talentId("7043758982146345223")
                .createTalentExternalInfoReqBody(CreateTalentExternalInfoReqBody.newBuilder()
                        .externalCreateTime("1639992265035")
                        .build())
                .build();

        // 发起请求
        CreateTalentExternalInfoResp resp = client.hire().v1().talentExternalInfo().create(req);

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
