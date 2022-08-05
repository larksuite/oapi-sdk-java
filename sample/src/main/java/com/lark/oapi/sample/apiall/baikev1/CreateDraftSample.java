package com.lark.oapi.sample.apiall.baikev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.baike.v1.model.CreateDraftReq;
import com.lark.oapi.service.baike.v1.model.CreateDraftResp;
import com.lark.oapi.service.baike.v1.model.Entity;
import com.lark.oapi.service.baike.v1.model.OuterInfo;
import com.lark.oapi.service.baike.v1.model.RelatedMeta;
import com.lark.oapi.service.baike.v1.model.Term;

// HTTP PATH: /open-apis/baike/v1/drafts"
public class CreateDraftSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateDraftReq req = CreateDraftReq.newBuilder()
        .userIdType("user_id")
        .entity(Entity.newBuilder()
            .id("enterprise_40217521")
            .mainKeys(new Term[]{})
            .aliases(new Term[]{})
            .description("企业百科是飞书提供的一款知识管理工具，通过企业百科可以帮助企业将分散的知识信息进行聚合，并通过UGC的方式，促进企业知识的保鲜和流通")
            .relatedMeta(RelatedMeta.newBuilder().build())
            .outerInfo(OuterInfo.newBuilder().build())
            .richText("")
            .build())
        .build();

    // 发起请求
    CreateDraftResp resp = client.baike().draft().create(req);

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
