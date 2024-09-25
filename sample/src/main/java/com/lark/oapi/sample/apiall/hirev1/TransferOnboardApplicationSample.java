package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.TransferOnboardApplicationReq;
import com.lark.oapi.service.hire.v1.model.TransferOnboardApplicationReqBody;
import com.lark.oapi.service.hire.v1.model.TransferOnboardApplicationResp;

// POST /open-apis/hire/v1/applications/:application_id/transfer_onboard
public class TransferOnboardApplicationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        TransferOnboardApplicationReq req = TransferOnboardApplicationReq.newBuilder()
                .applicationId("7073372582620416300")
                .userIdType("open_id")
                .departmentIdType("people_admin_department_id")
                .jobLevelIdType("people_admin_job_level_id")
                .jobFamilyIdType("people_admin_job_category_id")
                .employeeTypeIdType("people_admin_employee_type_id")
                .transferOnboardApplicationReqBody(TransferOnboardApplicationReqBody.newBuilder()
                        .actualOnboardTime(0)
                        .expectedConversionTime(0)
                        .jobRequirementId("6960663240925956402")
                        .operatorId("ou-xxx")
                        .onboardCityCode("CT_2")
                        .department("6966123381141866028")
                        .leader("ou-xxx")
                        .sequence("7006234385490345986")
                        .level("6937934036379650311")
                        .employeeType("1")
                        .build())
                .build();

        // 发起请求
        TransferOnboardApplicationResp resp = client.hire().v1().application().transferOnboard(req);

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
