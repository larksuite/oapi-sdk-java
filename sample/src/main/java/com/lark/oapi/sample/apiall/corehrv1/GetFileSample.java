package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.GetFileReq;
import com.lark.oapi.service.corehr.v1.model.GetFileResp;

// GET /open-apis/corehr/v1/files/:id
public class GetFileSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetFileReq req = GetFileReq.newBuilder()
                .id("150018109586e8ea745e47ae8feb3722dbe1d03a181336393633393133303431393831343930373235150100")
                .build();

        // 发起请求
        GetFileResp resp = client.corehr().file().get(req);

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
