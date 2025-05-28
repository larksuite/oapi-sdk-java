package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/default_cost_centers/update_version
public class UpdateVersionDefaultCostCenterSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateVersionDefaultCostCenterReq req = UpdateVersionDefaultCostCenterReq.newBuilder()
                .clientToken("12454646")
                .userIdType("open_id")
                .updateVersionDefaultCostCenterReqBody(UpdateVersionDefaultCostCenterReqBody.newBuilder()
                        .employmentId("6862995757234914821")
                        .defaultCostCenter(EmploymentDefaultCostCenter.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        UpdateVersionDefaultCostCenterResp resp = client.corehr().v2().defaultCostCenter().updateVersion(req);

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
