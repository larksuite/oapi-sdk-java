package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.UploadPersonReq;
import com.lark.oapi.service.corehr.v1.model.UploadPersonReqBody;
import com.lark.oapi.service.corehr.v1.model.UploadPersonResp;

import java.io.File;

// POST /open-apis/corehr/v1/persons/upload
public class UploadPersonSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        File file = new File("filepath");
        UploadPersonReq req = UploadPersonReq.newBuilder()
                .uploadPersonReqBody(UploadPersonReqBody.newBuilder()
                        .fileContent(file)
                        .fileName("个人信息")
                        .build())
                .build();

        // 发起请求
        UploadPersonResp resp = client.corehr().v1().person().upload(req);

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
