package com.lark.oapi.sample.apiall.adminv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.admin.v1.model.CreateBadgeImageReq;
import com.lark.oapi.service.admin.v1.model.CreateBadgeImageReqBody;
import com.lark.oapi.service.admin.v1.model.CreateBadgeImageResp;

import java.io.File;

// POST /open-apis/admin/v1/badge_images
public class CreateBadgeImageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        File file = new File("filepath");
        CreateBadgeImageReq req = CreateBadgeImageReq.newBuilder()
                .createBadgeImageReqBody(CreateBadgeImageReqBody.newBuilder()
                        .imageFile(file)
                        .imageType(1)
                        .build())
                .build();

        // 发起请求
        CreateBadgeImageResp resp = client.admin().badgeImage().create(req);

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
