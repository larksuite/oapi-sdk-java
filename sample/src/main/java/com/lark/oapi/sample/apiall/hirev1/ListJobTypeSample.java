package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.ListJobTypeReq;
import com.lark.oapi.service.hire.v1.model.ListJobTypeResp;

// GET /open-apis/hire/v1/job_types
public class ListJobTypeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListJobTypeReq req = ListJobTypeReq.newBuilder()
                .pageSize(0)
                .pageToken("")
                .build();

        // 发起请求
        ListJobTypeResp resp = client.hire().jobType().list(req);

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
