package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// GET /open-apis/hire/v1/applications/:application_id/get_detail
public class GetDetailApplicationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetDetailApplicationReq req = GetDetailApplicationReq.newBuilder()
                .applicationId("6956499586395523359")
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .jobLevelIdType("job_level_id")
                .jobFamilyIdType("job_family_id")
                .employeeTypeIdType("employee_type_enum_id")
                .options(new String[]{})
                .build();

        // 发起请求
        GetDetailApplicationResp resp = client.hire().v1().application().getDetail(req);

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
