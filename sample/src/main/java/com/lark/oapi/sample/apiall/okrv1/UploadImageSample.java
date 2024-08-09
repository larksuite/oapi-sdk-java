package com.lark.oapi.sample.apiall.okrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.okr.v1.model.*;

import java.io.File;
import java.util.HashMap;

// POST /open-apis/okr/v1/images/upload
public class UploadImageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        File file = new File("filepath");
        UploadImageReq req = UploadImageReq.newBuilder()
                .uploadImageReqBody(UploadImageReqBody.newBuilder()
                        .data(file)
                        .targetId("6974586812998174252")
                        .targetType(1)
                        .build())
                .build();

        // 发起请求
        UploadImageResp resp = client.okr().v1().image().upload(req);

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
