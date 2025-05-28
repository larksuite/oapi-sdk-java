package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.*;

import java.util.HashMap;

// POST /open-apis/contact/v3/job_levels
public class CreateJobLevelSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateJobLevelReq req = CreateJobLevelReq.newBuilder()
                .jobLevel(JobLevel.newBuilder()
                        .name("高级专家")
                        .description("公司内部中高级职称，有一定专业技术能力的人员")
                        .order(200)
                        .status(true)
                        .i18nName(new I18nContent[]{})
                        .i18nDescription(new I18nContent[]{})
                        .build())
                .build();

        // 发起请求
        CreateJobLevelResp resp = client.contact().v3().jobLevel().create(req);

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
