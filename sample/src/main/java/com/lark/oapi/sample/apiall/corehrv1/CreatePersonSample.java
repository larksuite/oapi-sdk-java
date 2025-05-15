package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;
import java.util.HashMap;
import com.lark.oapi.service.corehr.v1.model.Enum;

// POST /open-apis/corehr/v1/persons
public class CreatePersonSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreatePersonReq req = CreatePersonReq.newBuilder()
			 .clientToken("12454646")
			.person(Person.newBuilder()
				 .nameList(new PersonName[]{})
				 .gender(Enum.newBuilder().build())
				 .dateOfBirth("2020-01-01")
				 .nationalityId("7075702732803278381")
				 .race(Enum.newBuilder().build())
				 .maritalStatus(Enum.newBuilder().build())
				 .phoneList(new Phone[]{})
				 .addressList(new Address[]{})
				 .emailList(new Email[]{})
				 .workExperienceList(new WorkExperience[]{})
				 .educationList(new Education[]{})
				 .bankAccountList(new BankAccount[]{})
				 .nationalIdList(new NationalId[]{})
				 .dependentList(new Dependent[]{})
				 .emergencyContactList(new EmergencyContact[]{})
				 .dateEnteredWorkforce("2020-10-01")
				 .profileImageId("dfysuc8x76dsfsw")
				 .customFields(new ObjectFieldData[]{})
				 .residentTaxIdList(new String[]{})
				 .age(22)
				 .personalProfile(new PersonalProfile[]{})
				  .build())
			 .build();

	  // 发起请求
	  CreatePersonResp resp = client.corehr().v1().person().create(req);

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
