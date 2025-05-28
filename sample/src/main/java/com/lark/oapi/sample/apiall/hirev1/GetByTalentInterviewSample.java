package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// GET /open-apis/hire/v1/interviews/get_by_talent
public class GetByTalentInterviewSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetByTalentInterviewReq req = GetByTalentInterviewReq.newBuilder()
                .talentId("6949805467799537964")
                .userIdType("open_id")
                .jobLevelIdType("people_admin_job_level_id")
                .build();

        // 发起请求
        GetByTalentInterviewResp resp = client.hire().v1().interview().getByTalent(req);

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
