package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/talents/remove_to_folder
public class RemoveToFolderTalentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        RemoveToFolderTalentReq req = RemoveToFolderTalentReq.newBuilder()
                .removeToFolderTalentReqBody(RemoveToFolderTalentReqBody.newBuilder()
                        .talentIdList(new String[]{})
                        .folderId("7039620186502138156")
                        .build())
                .build();

        // 发起请求
        RemoveToFolderTalentResp resp = client.hire().v1().talent().removeToFolder(req);

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
