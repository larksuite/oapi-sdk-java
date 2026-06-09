package com.lark.oapi.sample.apiall.applicationv7;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v7.model.*;

import java.io.File;
import java.util.HashMap;

// POST /open-apis/application/v7/app_avatar/upload
public class CreateAppAvatarUploadSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        File file = new File("filepath");
        CreateAppAvatarUploadReq req = CreateAppAvatarUploadReq.newBuilder()
                .createAppAvatarUploadReqBody(CreateAppAvatarUploadReqBody.newBuilder()
                        .avatar(file)
                        .build())
                .build();

        // 发起请求
        CreateAppAvatarUploadResp resp = client.application().v7().appAvatarUpload().create(req);

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
