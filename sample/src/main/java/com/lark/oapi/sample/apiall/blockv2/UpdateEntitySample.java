package com.lark.oapi.sample.apiall.blockv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.block.v2.model.*;

import java.util.HashMap;

// PUT /open-apis/block/v2/entities/:block_id
public class UpdateEntitySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateEntityReq req = UpdateEntityReq.newBuilder()
                .blockId("7794641623571830467")
                .entity(Entity.newBuilder()
                        .title("已阅block")
                        .blockTypeId("blk_6204893fee000013739f5359")
                        .sourceData("")
                        .sourceMeta("")
                        .version("1651716489253602")
                        .sourceLink("")
                        .summary("")
                        .preview("")
                        .i18nSummay("")
                        .i18nPreview("")
                        .owner("ou_fa7aa170f92d1615de63371ac425a767")
                        .extra("{}")
                        .build())
                .build();

        // 发起请求
        UpdateEntityResp resp = client.block().v2().entity().update(req);

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
