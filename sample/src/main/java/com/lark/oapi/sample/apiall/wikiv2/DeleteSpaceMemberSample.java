package com.lark.oapi.sample.apiall.wikiv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.wiki.v2.model.DeleteSpaceMemberReq;
import com.lark.oapi.service.wiki.v2.model.DeleteSpaceMemberResp;
import com.lark.oapi.service.wiki.v2.model.Member;

// DELETE /open-apis/wiki/v2/spaces/:space_id/members/:member_id
public class DeleteSpaceMemberSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteSpaceMemberReq req = DeleteSpaceMemberReq.newBuilder()
                .spaceId("7008061636015554580")
                .memberId("g64fb7g7")
                .member(Member.newBuilder()
                        .memberType("")
                        .memberRole("")
                        .build())
                .build();

        // 发起请求
        DeleteSpaceMemberResp resp = client.wiki().spaceMember().delete(req);

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
