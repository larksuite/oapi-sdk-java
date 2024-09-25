package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.GetOfferReq;
import com.lark.oapi.service.hire.v1.model.GetOfferResp;

// GET /open-apis/hire/v1/offers/:offer_id
public class GetOfferSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetOfferReq req = GetOfferReq.newBuilder()
                .offerId("1111111")
                .userIdType("user_id")
                .departmentIdType("open_department_id")
                .jobLevelIdType("people_admin_job_level_id")
                .jobFamilyIdType("people_admin_job_category_id")
                .employeeTypeIdType("people_admin_employee_type_id")
                .build();

        // 发起请求
        GetOfferResp resp = client.hire().v1().offer().get(req);

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
