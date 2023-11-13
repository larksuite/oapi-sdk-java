package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.*;

// POST /open-apis/im/v1/chats
public class CreateChatSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateChatReq req = CreateChatReq.newBuilder()
                .userIdType("open_id")
                .setBotManager(false)
                .uuid("b13g2t38-1jd2-458b-8djf-dtbca5104204")
                .createChatReqBody(CreateChatReqBody.newBuilder()
                        .avatar("default-avatar_44ae0ca3-e140-494b-956f-78091e348435")
                        .name("测试群名称")
                        .description("测试群描述")
                        .i18nNames(I18nNames.newBuilder().build())
                        .ownerId("4d7a3c6g")
                        .userIdList(new String[]{})
                        .botIdList(new String[]{})
                        .chatMode("group")
                        .chatType("private")
                        .joinMessageVisibility("all_members")
                        .leaveMessageVisibility("all_members")
                        .membershipApproval("no_approval_required")
                        .restrictedModeSetting(RestrictedModeSetting.newBuilder().build())
                        .urgentSetting("all_members")
                        .videoConferenceSetting("all_members")
                        .editPermission("all_members")
                        .build())
                .build();

        // 发起请求
        CreateChatResp resp = client.im().chat().create(req);

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
