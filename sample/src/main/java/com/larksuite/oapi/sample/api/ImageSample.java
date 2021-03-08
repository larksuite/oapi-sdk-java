package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.api.request.FormDataFile;
import com.larksuite.oapi.core.api.response.Response;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.service.image.v4.ImageService;
import com.larksuite.oapi.service.image.v4.model.Image;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageSample {
    // for test
    private static final Config config = Config.getTestInternalConf("online");

    // for online
    // private static final AppSettings appSettings = Config.getInternalAppSettingsByEnv();
    // private static final Config config = ConfigUtils.getConfig(com.larksuite.oapi.core.Constants.Domain.FeiShu, appSettings);

    public static void main(String[] args) throws Exception {
        //testPut();
        testGet();
    }

    private static void testPut() throws Exception {
        ImageService service = new ImageService(config);
        ImageService.ImagePutReqCall reqCall = service.getImages().put();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.png");
        reqCall.setImage(new FormDataFile().setContentStream(inputStream));
        reqCall.setImageType("message");
        Response<Image> response = reqCall.execute();
        System.out.println();
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }

    private static void testGet() throws Exception {
        ImageService service = new ImageService(config);
        try (FileOutputStream output = new FileOutputStream("test_download_img_1.png")) {
            ImageService.ImageGetReqCall reqCall = service.getImages().get();
            reqCall.setImageKey("image key");
            reqCall.setResponseStream(output);
            Response response = reqCall.execute();
            System.out.println(response.getRequestID());
            System.out.println(response.getHTTPStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
