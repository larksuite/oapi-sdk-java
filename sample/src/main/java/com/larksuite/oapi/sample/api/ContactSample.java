package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.AppSettings;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Domain;
import com.larksuite.oapi.core.api.request.Request;
import com.larksuite.oapi.core.api.response.EmptyData;
import com.larksuite.oapi.core.api.response.Response;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.sample.config.Configs;
import com.larksuite.oapi.service.contact.v3.ContactService;
import com.larksuite.oapi.service.contact.v3.model.DepartmentListResult;
import com.larksuite.oapi.service.contact.v3.model.User;
import com.larksuite.oapi.service.contact.v3.model.UserDeleteReqBody;
import com.larksuite.oapi.service.contact.v3.model.UserPatchResult;

public class ContactSample {
    // for Cutome APP（自建应用）
    private static final AppSettings appSettings = Config.getInternalAppSettingsByEnv();
    // config with redis store
    // private static final Config config = Configs.getConfigWithRedisStore("https://open.feishu.cn", appSettings);
    // private static final Config config = Configs.getConfig("https://open.feishu.cn", appSettings);
    private static final Config config = Configs.getConfig(Domain.FeiShu, appSettings);

    private static void patch(ContactService contactService) throws Exception {
        User user = new User();
        user.setName("rename");

        Response<UserPatchResult> response = contactService.getUsers().patch(user, Request.setTenantKey("Tenant Key"))
                .setUserId("77bbc392").setUserIdType("user_id").execute();
        System.out.println(response.getRequestID());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }

    private static void delete(ContactService contactService) throws Exception {
        UserDeleteReqBody userDeleteReq = new UserDeleteReqBody();
        Response<EmptyData> response = contactService.getUsers().delete(userDeleteReq).setUserIdType("user_id").setUserId("13cgad15").execute();
        System.out.println(response.getRequestID());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }

    private static void departmentList(ContactService contactService) throws Exception {
        Response<DepartmentListResult> response = contactService.getDepartments().list().setFetchChild(true).execute();
        System.out.println(response.getRequestID());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }

    public static void main(String[] args) throws Exception {
        ContactService contactService = new ContactService(config);
        patch(contactService);
        // delete(contactService);
        //departmentList(contactService);

    }
}
