package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.AnswerUserQueryTicketReq;
import com.lark.oapi.service.helpdesk.v1.model.AnswerUserQueryTicketReqBody;
import com.lark.oapi.service.helpdesk.v1.model.AnswerUserQueryTicketResp;
import com.lark.oapi.service.helpdesk.v1.model.UserQueryFaqInfo;

// POST /open-apis/helpdesk/v1/tickets/:ticket_id/answer_user_query
public class AnswerUserQueryTicketSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        AnswerUserQueryTicketReq req = AnswerUserQueryTicketReq.newBuilder()
                .ticketId("6945345902185807891")
                .answerUserQueryTicketReqBody(AnswerUserQueryTicketReqBody.newBuilder()
                        .eventId("abcd")
                        .faqs(new UserQueryFaqInfo[]{})
                        .build())
                .build();

        // 发起请求
        AnswerUserQueryTicketResp resp = client.helpdesk().ticket().answerUserQuery(req);

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
