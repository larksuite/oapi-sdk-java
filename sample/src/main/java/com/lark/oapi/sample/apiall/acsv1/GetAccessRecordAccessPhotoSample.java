package com.lark.oapi.sample.apiall.acsv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.acs.v1.model.GetAccessRecordAccessPhotoReq;
import com.lark.oapi.service.acs.v1.model.GetAccessRecordAccessPhotoResp;

// GET /open-apis/acs/v1/access_records/:access_record_id/access_photo
public class GetAccessRecordAccessPhotoSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetAccessRecordAccessPhotoReq req = GetAccessRecordAccessPhotoReq.newBuilder()
                .accessRecordId("6939433228970082591")
                .build();

        // 发起请求
        GetAccessRecordAccessPhotoResp resp = client.acs().accessRecordAccessPhoto().get(req);

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
