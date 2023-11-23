package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.ListFileViewRecordReq;
import com.lark.oapi.service.drive.v1.model.ListFileViewRecordResp;

// GET /open-apis/drive/v1/files/:file_token/view_records
public class ListFileViewRecordSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListFileViewRecordReq req = ListFileViewRecordReq.newBuilder()
                .fileToken("XIHSdYSI7oMEU1xrsnxc8fabcef")
                .pageSize(10)
                .pageToken("1674037112--7189934631754563585")
                .fileType("docx")
                .viewerIdType("open_id")
                .build();

        // 发起请求
        ListFileViewRecordResp resp = client.drive().v1().fileViewRecord().list(req);

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
