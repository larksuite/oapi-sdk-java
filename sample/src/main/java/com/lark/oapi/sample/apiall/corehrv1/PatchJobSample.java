package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;

// PATCH /open-apis/corehr/v1/jobs/:job_id
public class PatchJobSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchJobReq req = PatchJobReq.newBuilder()
                .jobId("1616161616")
                .clientToken("12454646")
                .job(Job.newBuilder()
                        .code("JP422119")
                        .name(new I18n[]{})
                        .description(new I18n[]{})
                        .active(true)
                        .jobTitle(new I18n[]{})
                        .jobFamilyIdList(new String[]{})
                        .jobLevelIdList(new String[]{})
                        .workingHoursTypeId("6890452208593372679")
                        .effectiveTime("2020-01-01 00:00:00")
                        .expirationTime("2021-01-01 00:00:00")
                        .customFields(new ObjectFieldData[]{})
                        .build())
                .build();

        // 发起请求
        PatchJobResp resp = client.corehr().v1().job().patch(req);

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
