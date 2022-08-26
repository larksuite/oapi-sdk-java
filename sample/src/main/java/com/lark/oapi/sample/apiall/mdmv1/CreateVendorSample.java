package com.lark.oapi.sample.apiall.mdmv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mdm.v1.model.Appendix;
import com.lark.oapi.service.mdm.v1.model.CreateVendorReq;
import com.lark.oapi.service.mdm.v1.model.CreateVendorResp;
import com.lark.oapi.service.mdm.v1.model.ExtendField;
import com.lark.oapi.service.mdm.v1.model.Vendor;
import com.lark.oapi.service.mdm.v1.model.VendorAccount;
import com.lark.oapi.service.mdm.v1.model.VendorAddress;
import com.lark.oapi.service.mdm.v1.model.VendorCompanyView;
import com.lark.oapi.service.mdm.v1.model.VendorContact;

// POST /open-apis/mdm/v1/vendors
public class CreateVendorSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateVendorReq req = CreateVendorReq.newBuilder()
        .userId("123123123123")
        .userIdType("user_id")
        .vendor(Vendor.newBuilder()
            .id("7023646046559404327")
            .adCountry("CN")
            .adProvince("MDPS00000001")
            .adCity("MDCY00001226")
            .address("上海市浦东新区世纪大道1000号")
            .adPostcode("100100")
            .legalPerson("张三")
            .certificationType("0")
            .certificationId("913100xxxxx555781R")
            .contactPerson("李四")
            .contactTelephone("021-87853200")
            .contactMobilePhone("+8617621685955")
            .fax("021-87853200")
            .eMail("shunxing@xxx.com")
            .status(1)
            .vendor("V00108006")
            .vendorText("张三样例")
            .shortText("王五")
            .vendorType("1")
            .vendorCategory("11")
            .vendorNature("0")
            .linkedEmployee("6959513973725069601")
            .linkedCustomer("客户")
            .associatedWithLegalEntity(true)
            .extendInfo(new ExtendField[]{})
            .vendorAccounts(new VendorAccount[]{})
            .vendorAddresses(new VendorAddress[]{})
            .vendorCompanyViews(new VendorCompanyView[]{})
            .vendorContacts(new VendorContact[]{})
            .glAccount("22020101")
            .downPaymentTerm("PT09")
            .paymentTerm("PT08")
            .vendorSiteCode("999999")
            .appendix(new Appendix[]{})
            .isRisked(false)
            .build())
        .build();

    // 发起请求
    CreateVendorResp resp = client.mdm().vendor().create(req);

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
