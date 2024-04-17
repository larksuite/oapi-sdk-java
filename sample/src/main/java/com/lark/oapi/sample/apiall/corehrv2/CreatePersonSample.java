package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.Enum;
import com.lark.oapi.service.corehr.v2.model.*;

// POST /open-apis/corehr/v2/persons
public class CreatePersonSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreatePersonReq req = CreatePersonReq.newBuilder()
                .clientToken("12454646")
                .personInfo(PersonInfo.newBuilder()
                        .nameList(new PersonName[]{})
                        .gender(Enum.newBuilder().build())
                        .dateOfBirth("2020-01-01")
                        .nationalityIdV2("6862995757234914821")
                        .race(Enum.newBuilder().build())
                        .maritalStatus(Enum.newBuilder().build())
                        .phoneList(new Phone[]{})
                        .addressList(new Address[]{})
                        .emailList(new Email[]{})
                        .workExperienceList(new WorkExperienceInfo[]{})
                        .educationList(new Education[]{})
                        .bankAccountList(new BankAccount[]{})
                        .nationalIdList(new NationalId[]{})
                        .dependentList(new Dependent[]{})
                        .emergencyContactList(new EmergencyContact[]{})
                        .dateEnteredWorkforce("2020-10-01")
                        .profileImageId("dfysuc8x76dsfsw")
                        .personalProfile(new PersonalProfile[]{})
                        .nativeRegion("6863326262618752111")
                        .hukouType(Enum.newBuilder().build())
                        .hukouLocation("山东省平阴县")
                        .talentId("6863326262618752123")
                        .customFields(new CustomFieldData[]{})
                        .bornCountryRegion("中国")
                        .isDisabled(true)
                        .disableCardNumber("1110000")
                        .isMartyrFamily(true)
                        .martyrCardNumber("1110000")
                        .isOldAlone(true)
                        .residentTaxes(new ResidentTax[]{})
                        .firstEntryTime("2021-01-02")
                        .leaveTime("2022-01-02")
                        .build())
                .build();

        // 发起请求
        CreatePersonResp resp = client.corehr().v2().person().create(req);

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
