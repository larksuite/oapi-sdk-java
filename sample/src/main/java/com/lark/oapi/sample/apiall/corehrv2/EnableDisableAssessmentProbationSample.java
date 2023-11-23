package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.EnableDisableAssessmentProbationReq;
import com.lark.oapi.service.corehr.v2.model.EnableDisableAssessmentProbationReqBody;
import com.lark.oapi.service.corehr.v2.model.EnableDisableAssessmentProbationResp;

// POST /open-apis/corehr/v2/probation/enable_disable_assessment
public class EnableDisableAssessmentProbationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        EnableDisableAssessmentProbationReq req = EnableDisableAssessmentProbationReq.newBuilder()
                .enableDisableAssessmentProbationReqBody(EnableDisableAssessmentProbationReqBody.newBuilder()
                        .active(true)
                        .appUrl("https://qwe111.feishuapp.bytedance.net/ae/ui/apps/176612345027111/appPages/l11bsrwss13yt?dataGrid%41pye4fsbajo21l=%7B%7D&key=ffm41o1&dataGrid%41wmv98t29vif3kj=%1B%7D")
                        .build())
                .build();

        // 发起请求
        EnableDisableAssessmentProbationResp resp = client.corehr().v2().probation().enableDisableAssessment(req);

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
