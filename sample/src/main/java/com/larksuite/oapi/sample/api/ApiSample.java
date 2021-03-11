package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.AppSettings;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Domain;
import com.larksuite.oapi.core.Keys;
import com.larksuite.oapi.core.api.*;
import com.larksuite.oapi.core.api.request.FormData;
import com.larksuite.oapi.core.api.request.FormDataFile;
import com.larksuite.oapi.core.api.request.Request;
import com.larksuite.oapi.core.api.response.Response;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.sample.config.Configs;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ApiSample {

    // for Cutome APP（自建应用）
    private static final AppSettings appSettings = Config.getInternalAppSettingsByEnv();
    // config with redis store
    // private static final Config config = Configs.getConfigWithRedisStore("https://open.feishu.cn", appSettings);
    // private static final Config config = Configs.getConfig("https://open.feishu.cn", appSettings);
    private static final Config config = Configs.getConfig(Domain.FeiShu, appSettings);


    public static void main(String[] args) throws Exception {
        //sendMessage();
        //batchSendMessage();
        //sendIsvMessage();
        sendCardMessage();
        //uploadImage();
        //downloadImage();
    }

    /**
     * send text message
     */
    private static void sendMessage() throws Exception {
        Map<String, Object> message = new HashMap<>();
        message.put("user_id", "77bbc392");
        message.put("msg_type", "text");
        Map<String, Object> content = new HashMap<>();
        content.put("text", "java test");
        message.put("content", content);
        Request<Map<String, Object>, Map<String, Object>> request = Request.newRequest("message/v4/send",
                "POST", AccessTokenType.Tenant, message, new HashMap<>(), Request.setTenantKey("13586be5aacf1748"));
        Response<Map<String, Object>> response = Api.send(config, request);
        System.out.println(response.getRequestID());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }

    /**
     * batch send text message
     */
    private static void batchSendMessage() {
        Map<String, Object> message = new HashMap<>();
        message.put("user_id", "[user id]");
        message.put("msg_type", "text");
        Map<String, Object> content = new HashMap<>();
        content.put("text", "java test");
        message.put("content", content);
        Request<Map<String, Object>, Map<String, Object>> request = Request.newRequest("message/v4/send",
                "POST", AccessTokenType.Tenant, message, new HashMap<>());

        DefaultReqCall<Map<String, Object>, Map<String, Object>> reqCall1 = new DefaultReqCall<>(config, request);
        DefaultReqCall<Map<String, Object>, Map<String, Object>> reqCall2 = new DefaultReqCall<>(config, request);
        BatchReqCall<Map<String, Object>, Map<String, Object>> batchReqCall = new BatchReqCall<>(reqCall1, reqCall2);
        try {
            List<ReqCallResult<Map<String, Object>, Map<String, Object>>> reqCallResults = batchReqCall.call();
            for (ReqCallResult<Map<String, Object>, Map<String, Object>> reqCallResult : reqCallResults) {
                if (reqCallResult.getException() != null) {
                    System.out.println(reqCallResult.getException().getMessage());
                    return;
                }
                System.out.println(reqCallResult.getResponse().getRequestID());
                System.out.println(reqCallResult.getResponse().getHTTPStatusCode());
                System.out.println(Jsons.DEFAULT_GSON.toJson(reqCallResult.getResponse()));
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * send text message (isv app)
     */
    private static void sendIsvMessage() throws Exception {
        Config config = Config.getTestISVConf("staging");
        config.getStore().put(Keys.appTicketKey(config.getAppSettings().getAppID()), "[app ticket from event]", 12, TimeUnit.HOURS);
        Map<String, Object> message = new HashMap<>();
        message.put("user_id", "[user id]");
        message.put("msg_type", "text");
        Map<String, Object> content = new HashMap<>();
        content.put("text", "java test isv");
        message.put("content", content);
        Request<Map<String, Object>, Map<String, Object>> request = Request.newRequest("message/v4/send",
                "POST", AccessTokenType.Tenant, message, new HashMap<>(), Request.setTenantKey("[tenant key]"));
        Response<Map<String, Object>> response = Api.send(config, request);
        System.out.println(response.getRequestID());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }

    /**
     * send card message
     */
    private static void sendCardMessage() throws Exception {
        // config.getStore().put(Keys.tenantAccessTokenKey(config.getAppSettings().getAppID(), ""), "t-xxxxxxxxxxxxxxxxxxxxxxxxx", 1000, TimeUnit.DAYS);
        Map<String, Object> message = new HashMap<>();
        message.put("user_id", "77bbc392");
        message.put("msg_type", "interactive");
        String content = "{\"config\":{\"wide_screen_mode\":true},\"i18n_elements\":{\"zh_cn\":[{\"tag\":\"div\",\"text\":{\"tag\":\"lark_md\",\"content\":\"[飞书](https://www.feishu.cn)整合即时沟通、日历、音视频会议、云文档、云盘、工作台等功能于一体，成就组织和个人，更高效、更愉悦。\"}},{\"tag\":\"action\",\"actions\":[{\"tag\":\"button\",\"text\":{\"tag\":\"plain_text\",\"content\":\"主按钮\"},\"type\":\"primary\",\"value\":{\"key\":\"primary\"}},{\"tag\":\"button\",\"text\":{\"tag\":\"plain_text\",\"content\":\"次按钮\"},\"type\":\"default\",\"value\":{\"key\":\"default\"}}]}]}}";
        message.put("card", Jsons.DEFAULT_GSON.fromJson(content, HashMap.class));
        Request<Map<String, Object>, Map<String, Object>> request = Request.newRequest("message/v4/send",
                "POST", AccessTokenType.Tenant, message, new HashMap<>());
        Response<Map<String, Object>> response = Api.send(config, request);
        System.out.println(response.getRequestID());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }

    /**
     * upload image file
     */
    private static void uploadImage() throws Exception {
        FormData formData = new FormData();
        formData.addField("image_type", "message");
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.png");
        formData.addFile("image", new FormDataFile().setContentStream(inputStream));
        Request<FormData, Map<String, Object>> request = Request.newRequest("image/v4/put",
                "POST", AccessTokenType.Tenant, formData, new HashMap<>());
        Response<Map<String, Object>> response = Api.send(config, request);
        System.out.println(response.getRequestID());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }

    /**
     * download image file
     *
     * @throws Exception
     */
    private static void downloadImage() throws Exception {
        // config.getStore().put(Keys.tenantAccessTokenKey(config.getAppSettings().getAppID(), ""), "t-xxxxxxxxxxxxxxxxxxx", 1000, TimeUnit.DAYS);
        try (FileOutputStream output = new FileOutputStream("dddddd.png")) {
            Map<String, Object> queries = new HashMap<>();
            queries.put("image_key", "[img_xxxxxxxxxxx]");
            Request<Object, FileOutputStream> request = Request.newRequest("image/v4/get",
                    "GET", AccessTokenType.Tenant, null, output,
                    Request.setResponseStream(), Request.setQueryParams(queries));
            Response<FileOutputStream> response = Api.send(config, request);
            System.out.println(response.getRequestID());
            System.out.println(response.getHTTPStatusCode());
            System.out.println(Jsons.DEFAULT_GSON.toJson(response));
        }
    }


}
