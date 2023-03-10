package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.DeleteJobFamilyReq;
import com.lark.oapi.service.contact.v3.model.DeleteJobFamilyResp;

// DELETE /open-apis/contact/v3/job_families/:job_family_id
public class DeleteJobFamilySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteJobFamilyReq req = DeleteJobFamilyReq.newBuilder()
                .jobFamilyId("mga5oa8ayjlp9rb")
                .build();

        // 发起请求
        DeleteJobFamilyResp resp = client.contact().jobFamily().delete(req);

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
