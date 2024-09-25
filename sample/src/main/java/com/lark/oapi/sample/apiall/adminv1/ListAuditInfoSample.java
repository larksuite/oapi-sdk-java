package com.lark.oapi.sample.apiall.adminv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.admin.v1.model.ListAuditInfoReq;
import com.lark.oapi.service.admin.v1.model.ListAuditInfoResp;

// GET /open-apis/admin/v1/audit_infos
public class ListAuditInfoSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListAuditInfoReq req = ListAuditInfoReq.newBuilder()
                .userIdType("user_id")
                .latest(1668700799)
                .oldest(1668528000)
                .eventName("space_create_doc")
                .operatorType("user")
                .operatorValue("55ed16fe")
                .eventModule(1)
                .pageToken("LC39/f1%2B/Sz9Uv39Gf39/ew/cd5WY0gfGYFdixOW9cVk4bC79ituO/gx0qpPn1bYf92nz/kI0nNJOG3wCwDJKoNU%2BtyaXbpI8pV/9UNDMZT0BNeyanFH17Wv711Qh9anR3l2GjQfc2fUqXtxg1YPp63XyhYY4iRMv54ySRG7r%2BI89iS3zAoPzFuuU1MUJKsf")
                .pageSize(20)
                .userType(0)
                .objectType(1)
                .objectValue("55ed16fe")
                .extFilterObjectByCcmToken("55ed16fe")
                .build();

        // 发起请求
        ListAuditInfoResp resp = client.admin().v1().auditInfo().list(req);

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
