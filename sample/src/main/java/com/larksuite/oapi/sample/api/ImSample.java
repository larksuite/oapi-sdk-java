package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.AppSettings;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.DefaultStore;
import com.larksuite.oapi.core.Domain;
import com.larksuite.oapi.core.api.request.FormDataFile;
import com.larksuite.oapi.core.api.response.Response;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.service.im.v1.ImService;
import com.larksuite.oapi.service.im.v1.model.ImageCreateResult;

import java.io.IOException;
import java.io.InputStream;

public class ImSample {
    // Configuration of "Custom App", parameter description:
    // AppID、AppSecret: "Developer Console" -> "Credentials"（App ID、App Secret）
    // VerificationToken、EncryptKey: "Developer Console" -> "Event Subscriptions"（Verification Token、Encrypt Key）
    // For more information, please see: Github->README.md->Advanced use->How to build app settings(AppSettings)
    private static final AppSettings appSettings = Config.getInternalAppSettingsByEnv();

    // Currently, you are visiting Feishu, which uses default storage
    // For more information, please see: Github->README.md->Advanced use->How to build overall configuration(Config)
    private static final Config config = new Config(Domain.FeiShu, appSettings, new DefaultStore());

    public static void main(String[] args) throws Exception {
        ImService imService = new ImService(config);
        ImService.ImageCreateReqCall reqCall = imService.getImages().create();
        reqCall.setImageType("message");
        // read files under Resources
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("file path")) {
            // method 1: use byte stream
            reqCall.setImage(new FormDataFile().setContentStream(inputStream));
            // method 2: use byte array
            // byte[] bs = IOs.readAll(inputStream);
            // reqCall.setImage(new FormDataFile().setContent(bs));

            Response<ImageCreateResult> resp = reqCall.execute();

            System.out.println(resp.getRequestID());
            System.out.println(resp.getHTTPStatusCode());
            System.out.println(Jsons.DEFAULT_GSON.toJson(resp));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}