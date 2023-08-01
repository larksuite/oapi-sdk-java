package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;
import com.lark.oapi.service.corehr.v1.model.Enum;

// PATCH /open-apis/corehr/v1/employments/:employment_id
public class PatchEmploymentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchEmploymentReq req = PatchEmploymentReq.newBuilder()
                .employmentId("1616161616")
                .clientToken("12454646")
                .userIdType("people_corehr_id")
                .departmentIdType("people_corehr_department_id")
                .employment(Employment.newBuilder()
                        .seniorityDate("2020-01-01")
                        .employeeNumber("1000000")
                        .employmentType(Enum.newBuilder().build())
                        .personId("6919733936050406926")
                        .primaryEmployment(true)
                        .customFields(new ObjectFieldData[]{})
                        .workEmailList(new Email[]{})
                        .reasonForOffboarding(Enum.newBuilder().build())
                        .atsApplicationId("6838119494196871234")
                        .build())
                .build();

        // 发起请求
        PatchEmploymentResp resp = client.corehr().employment().patch(req);

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
