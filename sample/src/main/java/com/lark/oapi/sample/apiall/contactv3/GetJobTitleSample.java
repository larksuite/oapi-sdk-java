package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.GetJobTitleReq;
import com.lark.oapi.service.contact.v3.model.GetJobTitleResp;

// GET /open-apis/contact/v3/job_titles/:job_title_id
public class GetJobTitleSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetJobTitleReq req = GetJobTitleReq.newBuilder()
                .jobTitleId("dd39369b19b9")
                .build();

        // 发起请求
        GetJobTitleResp resp = client.contact().v3().jobTitle().get(req);

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
