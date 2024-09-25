package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.Enum;
import com.lark.oapi.service.corehr.v1.model.*;

// POST /open-apis/corehr/v1/companies
public class CreateCompanySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateCompanyReq req = CreateCompanyReq.newBuilder()
                .clientToken("12454646")
                .company(Company.newBuilder()
                        .hiberarchyCommon(HiberarchyCommon.newBuilder().build())
                        .type(Enum.newBuilder().build())
                        .industryList(new Enum[]{})
                        .legalRepresentative(new I18n[]{})
                        .postCode("邮编")
                        .taxPayerId("123456840")
                        .confidential(true)
                        .subTypeList(new Enum[]{})
                        .branchCompany(true)
                        .primaryManager(new I18n[]{})
                        .customFields(new ObjectFieldData[]{})
                        .currency(Currency.newBuilder().build())
                        .phone(PhoneNumberAndAreaCode.newBuilder().build())
                        .fax(PhoneNumberAndAreaCode.newBuilder().build())
                        .registeredOfficeAddressInfo(Address.newBuilder().build())
                        .officeAddressInfo(Address.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        CreateCompanyResp resp = client.corehr().v1().company().create(req);

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
