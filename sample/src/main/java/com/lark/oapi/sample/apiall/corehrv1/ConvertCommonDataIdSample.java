package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.ConvertCommonDataIdReq;
import com.lark.oapi.service.corehr.v1.model.ConvertCommonDataIdReqBody;
import com.lark.oapi.service.corehr.v1.model.ConvertCommonDataIdResp;

// POST /open-apis/corehr/v1/common_data/id/convert
public class ConvertCommonDataIdSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ConvertCommonDataIdReq req = ConvertCommonDataIdReq.newBuilder()
                .idTransformType(1)
                .idType("employment_id")
                .feishuUserIdType("open_id")
                .feishuDepartmentIdType("open_department_id")
                .convertCommonDataIdReqBody(ConvertCommonDataIdReqBody.newBuilder()
                        .ids(new String[]{})
                        .build())
                .build();

        // 发起请求
        ConvertCommonDataIdResp resp = client.corehr().v1().commonDataId().convert(req);

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
