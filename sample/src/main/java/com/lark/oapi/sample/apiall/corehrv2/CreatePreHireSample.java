package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/pre_hires
public class CreatePreHireSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreatePreHireReq req = CreatePreHireReq.newBuilder()
                .prehireCreate(PrehireCreate.newBuilder()
                        .basicInfo(BasicInfo.newBuilder().build())
                        .offerInfo(OfferInfo.newBuilder().build())
                        .educationInfo(new EducationInfo[]{})
                        .workExperience(new WorkExperience[]{})
                        .atsApplicationId("7140946969586010376")
                        .build())
                .build();

        // 发起请求
        CreatePreHireResp resp = client.corehr().v2().preHire().create(req);

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
