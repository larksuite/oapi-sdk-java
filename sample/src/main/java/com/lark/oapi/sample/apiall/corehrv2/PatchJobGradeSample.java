package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// PATCH /open-apis/corehr/v2/job_grades/:job_grade_id
public class PatchJobGradeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchJobGradeReq req = PatchJobGradeReq.newBuilder()
                .jobGradeId("6862995757234914824")
                .clientToken("1245464678")
                .jobGradeUpdate(JobGradeUpdate.newBuilder()
                        .gradeOrder(9999)
                        .code("A01234")
                        .names(new I18n[]{})
                        .descriptions(new I18n[]{})
                        .active(true)
                        .build())
                .build();

        // 发起请求
        PatchJobGradeResp resp = client.corehr().v2().jobGrade().patch(req);

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
