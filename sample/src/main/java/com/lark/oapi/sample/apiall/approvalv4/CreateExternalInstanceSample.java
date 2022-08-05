package com.lark.oapi.sample.apiall.approvalv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.approval.v4.model.CcNode;
import com.lark.oapi.service.approval.v4.model.CreateExternalInstanceReq;
import com.lark.oapi.service.approval.v4.model.CreateExternalInstanceResp;
import com.lark.oapi.service.approval.v4.model.ExternalInstance;
import com.lark.oapi.service.approval.v4.model.ExternalInstanceForm;
import com.lark.oapi.service.approval.v4.model.ExternalInstanceLink;
import com.lark.oapi.service.approval.v4.model.ExternalInstanceTaskNode;
import com.lark.oapi.service.approval.v4.model.I18nResource;

// HTTP PATH: /open-apis/approval/v4/external_instances"
public class CreateExternalInstanceSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateExternalInstanceReq req = CreateExternalInstanceReq.newBuilder()
        .externalInstance(ExternalInstance.newBuilder()
            .approvalCode("81D31358-93AF-92D6-7425-01A5D67C4E71")
            .status("PENDING")
            .extra("")
            .instanceId("24492654")
            .links(ExternalInstanceLink.newBuilder().build())
            .title("@i18n@1")
            .form(new ExternalInstanceForm[]{})
            .userId("a987sf9s")
            .userName("@i18n@9")
            .openId("ou_be73cbc0ee35eb6ca54e9e7cc14998c1")
            .departmentId("od-8ec33278bc2")
            .departmentName("@i18n@10")
            .startTime("1556468012678")
            .endTime("1556468012678")
            .updateTime("1556468012678")
            .displayMethod("BROWSER")
            .updateMode("UPDATE")
            .taskList(new ExternalInstanceTaskNode[]{})
            .ccList(new CcNode[]{})
            .i18nResources(new I18nResource[]{})
            .build())
        .build();

    // 发起请求
    CreateExternalInstanceResp resp = client.approval().externalInstance().create(req);

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
