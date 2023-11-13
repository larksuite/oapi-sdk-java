package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v6.enums.MessageTypeEnum;
import com.lark.oapi.service.im.v1.enums.CreateMessageReceiveIdTypeEnum;
import com.lark.oapi.service.im.v1.model.CreateMessageReq;
import com.lark.oapi.service.im.v1.model.CreateMessageReqBody;
import com.lark.oapi.service.im.v1.model.CreateMessageResp;
import com.lark.oapi.service.im.v1.model.ext.MessageTemplate;
import com.lark.oapi.service.im.v1.model.ext.MessageTemplateData;

import java.util.HashMap;
import java.util.Map;

// POST /open-apis/im/v1/messages
public class CreateMessageCardByTemplateSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

		Map<String, Object> templateVariable = new HashMap<>();

        // 创建请求对象
        CreateMessageReq req = CreateMessageReq.newBuilder()
            .receiveIdType(CreateMessageReceiveIdTypeEnum.OPEN_ID)
            .createMessageReqBody(
                CreateMessageReqBody.newBuilder()
                    .receiveId("ou_xxxxx")
                    .msgType(MessageTypeEnum.INTERACTIVE.getValue())
                    .content(
						MessageTemplate.newBuilder()
							.data(
								MessageTemplateData.newBuilder()
									.templateId("ctp_xxxx")
									.templateVariable(templateVariable)
									.build()
							)
							.build()
					)
                    .uuid("a0d69e20-1dd1-458b-k525-dfeca4015204")
                    .build())
            .build();

        // 发起请求
        CreateMessageResp resp = client.im().message().create(req);

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
