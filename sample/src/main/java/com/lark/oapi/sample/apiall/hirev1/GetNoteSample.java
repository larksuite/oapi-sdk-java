package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.GetNoteReq;
import com.lark.oapi.service.hire.v1.model.GetNoteResp;

// GET /open-apis/hire/v1/notes/:note_id
public class GetNoteSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetNoteReq req = GetNoteReq.newBuilder()
                .noteId("6949805467799537964")
                .userIdType("open_id")
                .build();

        // 发起请求
        GetNoteResp resp = client.hire().note().get(req);

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
