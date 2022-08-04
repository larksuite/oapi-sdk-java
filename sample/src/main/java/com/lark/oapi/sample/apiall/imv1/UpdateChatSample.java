package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.I18nNames;
import com.lark.oapi.service.im.v1.model.UpdateChatReq;
import com.lark.oapi.service.im.v1.model.UpdateChatReqBody;
import com.lark.oapi.service.im.v1.model.UpdateChatResp;

// HTTP PATH: /open-apis/im/v1/chats/:chat_id"
public class UpdateChatSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    UpdateChatReq req = UpdateChatReq.newBuilder()
        .chatId("oc_a0553eda9014c201e6969b478895c230")
        .userIdType("user_id")
        .updateChatReqBody(UpdateChatReqBody.newBuilder()
            .avatar("default-avatar_44ae0ca3-e140-494b-956f-78091e348435")
            .name("测试群名称")
            .description("测试群描述")
            .i18nNames(I18nNames.newBuilder().build())
            .addMemberPermission("all members")
            .shareCardPermission("allowed")
            .atAllPermission("all members")
            .editPermission("all members")
            .ownerId("4d7a3c6g")
            .joinMessageVisibility("only_owner/all_members/not_anyone")
            .leaveMessageVisibility("only_owner/all_members/not_anyone")
            .membershipApproval("no_approval_required/approval_required")
            .build())
        .build();

    // 发起请求
    UpdateChatResp resp = client.im().chat().update(req);

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
