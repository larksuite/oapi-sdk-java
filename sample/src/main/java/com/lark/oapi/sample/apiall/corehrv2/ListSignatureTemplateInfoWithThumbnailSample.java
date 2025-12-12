package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// GET /open-apis/corehr/v2/signature_template_info_with_thumbnails
public class ListSignatureTemplateInfoWithThumbnailSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListSignatureTemplateInfoWithThumbnailReq req = ListSignatureTemplateInfoWithThumbnailReq.newBuilder()
                .pageSize(0)
                .pageToken("")
                .name("入职电子签模板")
                .categoryApiname("contract_agreement,certificate")
                .usageApiname("dispatch,general")
                .active(false)
                .needRegionInfo(false)
                .applicabilityApinames(new String[]{})
                .userIdType("user_id")
                .build();

        // 发起请求
        ListSignatureTemplateInfoWithThumbnailResp resp = client.corehr().v2().signatureTemplateInfoWithThumbnail().list(req);

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
