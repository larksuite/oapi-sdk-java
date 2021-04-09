package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.AppSettings;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Domain;
import com.larksuite.oapi.core.api.AccessTokenType;
import com.larksuite.oapi.core.api.Api;
import com.larksuite.oapi.core.api.request.FormData;
import com.larksuite.oapi.core.api.request.FormDataFile;
import com.larksuite.oapi.core.api.request.Request;
import com.larksuite.oapi.core.api.response.Response;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.sample.config.Configs;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class IMSample {
    // for Cutome APP（自建应用）
    private static final AppSettings appSettings = Config.getInternalAppSettingsByEnv();
    // config with redis store
    // private static final Config config = Configs.getConfigWithRedisStore("https://open.feishu.cn", appSettings);
    // private static final Config config = Configs.getConfig("https://open.feishu.cn", appSettings);
    private static final Config config = Configs.getConfig(Domain.FeiShu, appSettings);

    public static void main(String[] args) throws Exception {
        //uploadPDF();
        downloadPDF();
        System.out.println("end");
    }

    /**
     * upload image file
     */
    private static void uploadPDF() throws Exception {
        FormData formData = new FormData();
        formData.addField("file_type", "pdf");
        formData.addField("file_name", "test-测试.pdf");
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.pdf");
        formData.addFile("file", new FormDataFile().setContentStream(inputStream));
        Request<FormData, Map<String, Object>> request = Request.newRequest("im/v1/files",
                "POST", AccessTokenType.Tenant, formData, new HashMap<>());
        Response<Map<String, Object>> response = Api.send(config, request);
        System.out.println(Jsons.DEFAULT_GSON.toJson(response.getHeader()));
        System.out.println(response.getRequestID());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }

    private static void downloadPDF() throws Exception {
        // config.getStore().put(Keys.tenantAccessTokenKey(config.getAppSettings().getAppID(), ""), "t-xxxxxxxxxxxxxxxxxxx", 1000, TimeUnit.DAYS);
        try (FileOutputStream output = new FileOutputStream("dddddd.pdf")) {
            Map<String, Object> pathParams = new HashMap<>();
            pathParams.put("file_key", "file_cb01d64b-252d-4766-b38a-283b7893819g");
            Request<Object, FileOutputStream> request = Request.newRequest("im/v1/files/:file_key",
                    "GET", AccessTokenType.Tenant, null, output,
                    Request.setResponseStream(), Request.setPathParams(pathParams));
            Response<FileOutputStream> response = Api.send(config, request);
            System.out.println(Jsons.DEFAULT_GSON.toJson(response.getHeader()));
            System.out.println(response.getRequestID());
            System.out.println(response.getHTTPStatusCode());
        }
    }
}
