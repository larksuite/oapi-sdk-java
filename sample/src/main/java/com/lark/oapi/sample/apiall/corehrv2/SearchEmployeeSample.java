package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/employees/search
public class SearchEmployeeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchEmployeeReq req = SearchEmployeeReq.newBuilder()
                .pageSize(100)
                .pageToken("6891251722631890445")
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .searchEmployeeReqBody(SearchEmployeeReqBody.newBuilder()
                        .fields(new String[]{})
                        .employmentIdList(new String[]{})
                        .employeeNumberList(new String[]{})
                        .workEmail("13312345678@qq.com")
                        .phoneNumber("16760342300")
                        .keyWord("张三")
                        .employmentStatus("hired")
                        .employeeTypeId("6971090097697521314")
                        .departmentIdList(new String[]{})
                        .directManagerIdList(new String[]{})
                        .dottedLineManagerIdList(new String[]{})
                        .regularEmployeeStartDateStart("2020-01-01")
                        .regularEmployeeStartDateEnd("2020-01-01")
                        .effectiveTimeStart("2020-01-01")
                        .effectiveTimeEnd("2020-01-01")
                        .workLocationIdListIncludeSub(new String[]{})
                        .preferredEnglishFullNameList(new String[]{})
                        .preferredLocalFullNameList(new String[]{})
                        .nationalIdNumberList(new String[]{})
                        .phoneNumberList(new String[]{})
                        .emailAddressList(new String[]{})
                        .departmentIdListIncludeSub(new String[]{})
                        .costCenterIdList(new String[]{})
                        .build())
                .build();

        // 发起请求
        SearchEmployeeResp resp = client.corehr().v2().employee().search(req);

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
