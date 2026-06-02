package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.*;

import java.util.HashMap;

// POST /open-apis/vc/v1/meetings/search
public class SearchMeetingSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchMeetingReq req = SearchMeetingReq.newBuilder()
                .pageToken("")
                .pageSize(0)
                .searchMeetingReqBody(SearchMeetingReqBody.newBuilder()
                        .query("周会")
                        .meetingFilter(MeetingFilter.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        SearchMeetingResp resp = client.vc().v1().meeting().search(req);

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
