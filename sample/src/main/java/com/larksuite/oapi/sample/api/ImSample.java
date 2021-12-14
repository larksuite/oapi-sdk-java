package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.*;
import com.larksuite.oapi.core.api.response.Response;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.service.im.v1.ImService;
import com.larksuite.oapi.service.im.v1.model.Message;
import com.larksuite.oapi.service.im.v1.model.MessageCreateReqBody;

import java.util.concurrent.TimeUnit;

public class ImSample {
    // Configuration of "Custom App", parameter description:
    // AppID、AppSecret: "Developer Console" -> "Credentials"（App ID、App Secret）
    // VerificationToken、EncryptKey: "Developer Console" -> "Event Subscriptions"（Verification Token、Encrypt Key）
    // For more information, please see: Github->README.md->Advanced use->How to build app settings(AppSettings)
    private static final AppSettings appSettings = Config.getInternalAppSettingsByEnv();

    // Currently, you are visiting Feishu, which uses default storage
    // For more information, please see: Github->README.md->Advanced use->How to build overall configuration(Config)


    public static void main(String[] args) throws Exception {
        DefaultStore store = new DefaultStore();
        Config config = new Config(Domain.FeiShu, appSettings, store);

        ImService imService = new ImService(config);
        // body params
        MessageCreateReqBody body = new MessageCreateReqBody();
        body.setReceiveId("77bbc392");
        body.setContent("{\"text\": \"test content\"}");
        body.setMsgType("text");

        ImService.MessageCreateReqCall reqCall2 = imService.getMessages().create(body);
        // query params
        reqCall2.setReceiveIdType("user_id");

        Response<Message> resp2 = reqCall2.execute();
        System.out.println(resp2.getRequestID());
        System.out.println(resp2.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(resp2));


        // store.put("tenant_access_token-cli_9fe8602eab7f500d-", "", 12, TimeUnit.HOURS);
        ImService.MessageCreateReqCall reqCall3 = imService.getMessages().create(body);
        // query params
        reqCall3.setReceiveIdType("user_id");

        Response<Message> resp3 = reqCall3.execute();
        System.out.println(resp3.getRequestID());
        System.out.println(resp3.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(resp3));
    }
}
