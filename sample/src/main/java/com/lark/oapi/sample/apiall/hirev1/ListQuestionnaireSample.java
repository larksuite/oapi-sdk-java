package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.ListQuestionnaireReq;
import com.lark.oapi.service.hire.v1.model.ListQuestionnaireResp;

// GET /open-apis/hire/v1/questionnaires
public class ListQuestionnaireSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListQuestionnaireReq req = ListQuestionnaireReq.newBuilder()
                .pageToken("1231231987")
                .pageSize(1)
                .applicationId("6985833807195212076")
                .interviewId("7038435261598763308")
                .updateStartTime("1638848468868")
                .updateEndTime("1638848468869")
                .build();

        // 发起请求
        ListQuestionnaireResp resp = client.hire().v1().questionnaire().list(req);

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
