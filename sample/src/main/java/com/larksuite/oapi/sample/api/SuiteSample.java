package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.AppSettings;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Domain;
import com.larksuite.oapi.core.api.request.Request;
import com.larksuite.oapi.core.api.response.Response;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.sample.config.Configs;
import com.larksuite.oapi.service.suite.v1.SuiteService;
import com.larksuite.oapi.service.suite.v1.model.*;

public class SuiteSample {
    // for Cutome APP（自建应用）
    private static final AppSettings appSettings = Config.getInternalAppSettingsByEnv();
    // config with redis store
    // private static final Config config = Configs.getConfigWithRedisStore("https://open.feishu.cn", appSettings);
    // private static final Config config = Configs.getConfig("https://open.feishu.cn", appSettings);
    private static final Config config = Configs.getConfig(Domain.FeiShu, appSettings);

    public static void main(String[] args) throws Exception {
        SuiteService service = new SuiteService(config);
        DocsApiMetaReqBody body = new DocsApiMetaReqBody();
        RequestDoc requestDoc = new RequestDoc();
        requestDoc.setDocsToken("1233");
        requestDoc.setDocsType("doc");
        body.setRequestDocs(new RequestDoc[]{requestDoc});
        Response<DocsApiMetaResult> response = service.getDocsApis().meta(body, Request.setUserAccessToken("u-n7IgWeg3R1WN4Af3JxGP5f")).execute();
        System.out.println(response.getRequestID());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));

        DocsApiSearchReqBody body2 = new DocsApiSearchReqBody();
        body2.setDocsTypes(new String[]{"doc", "sheet"});
        Response<DocsApiSearchResult> response2 = service.getDocsApis().search(body2, Request.setUserAccessToken("u-n7IgWeg3R1WN4Af3JxGP5f")).execute();
        System.out.println(response.getRequestID());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response2));
    }
}
