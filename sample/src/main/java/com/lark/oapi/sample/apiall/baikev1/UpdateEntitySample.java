package com.lark.oapi.sample.apiall.baikev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.baike.v1.model.Entity;
import com.lark.oapi.service.baike.v1.model.OuterInfo;
import com.lark.oapi.service.baike.v1.model.RelatedMeta;
import com.lark.oapi.service.baike.v1.model.Term;
import com.lark.oapi.service.baike.v1.model.UpdateEntityReq;
import com.lark.oapi.service.baike.v1.model.UpdateEntityResp;

// PUT /open-apis/baike/v1/entities/:entity_id
public class UpdateEntitySample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    UpdateEntityReq req = UpdateEntityReq.newBuilder()
        .entityId("enterprise_40217521")
        .userIdType("user_id")
        .entity(Entity.newBuilder()
            .mainKeys(new Term[]{})
            .aliases(new Term[]{})
            .description("企业百科是飞书提供的一款知识管理工具，通过企业百科可以帮助企业将分散的知识信息进行聚合，并通过UGC的方式，促进企业知识的保鲜和流通")
            .relatedMeta(RelatedMeta.newBuilder().build())
            .outerInfo(OuterInfo.newBuilder().build())
            .richText("")
            .build())
        .build();

    // 发起请求
    UpdateEntityResp resp = client.baike().entity().update(req);

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
