package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.DeleteReserveReq;
import com.lark.oapi.service.vc.v1.model.DeleteReserveResp;

// DELETE /open-apis/vc/v1/reserves/:reserve_id
public class DeleteReserveSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteReserveReq req = DeleteReserveReq.newBuilder()
                .reserveId("6911188411932033028")
                .build();

        // 发起请求
        DeleteReserveResp resp = client.vc().reserve().delete(req);

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
