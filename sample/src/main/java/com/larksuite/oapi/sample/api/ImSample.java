package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.AppSettings;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.DefaultStore;
import com.larksuite.oapi.core.Domain;
import com.larksuite.oapi.core.api.response.Response;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.service.im.v1.ImService;
import com.larksuite.oapi.service.im.v1.ImService.FileGetReqCall;
import java.io.FileOutputStream;

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
    FileGetReqCall reqCall3 = imService.getFiles().get();
    // query params
    reqCall3.setFileKey("file_v2_4fa17cda-01f3-4aac-927a-7833ab482fcg");
    try (FileOutputStream output = new FileOutputStream("a.pdf")) {
      reqCall3.setResponseStream(output);

      Response resp3 = reqCall3.execute();
      System.out.println(resp3.getRequestID());
      System.out.println(resp3.getHTTPStatusCode());
      System.out.println(Jsons.DEFAULT_GSON.toJson(resp3.getHeader()));
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
