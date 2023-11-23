package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.ResourceReservationListExportReq;
import com.lark.oapi.service.vc.v1.model.ResourceReservationListExportReqBody;
import com.lark.oapi.service.vc.v1.model.ResourceReservationListExportResp;

// POST /open-apis/vc/v1/exports/resource_reservation_list
public class ResourceReservationListExportSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ResourceReservationListExportReq req = ResourceReservationListExportReq.newBuilder()
                .resourceReservationListExportReqBody(ResourceReservationListExportReqBody.newBuilder()
                        .roomLevelId("omm_608d34d82d531b27fa993902d350a307")
                        .needTopic(true)
                        .startTime("1655276858")
                        .endTime("1655276858")
                        .roomIds(new String[]{})
                        .isExclude(false)
                        .build())
                .build();

        // 发起请求
        ResourceReservationListExportResp resp = client.vc().v1().export().resourceReservationList(req);

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
