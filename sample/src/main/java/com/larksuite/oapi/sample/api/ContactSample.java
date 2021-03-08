package com.larksuite.oapi.sample.api;

import com.larksuite.oapi.core.AppSettings;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.DefaultStore;
import com.larksuite.oapi.core.Domain;
import com.larksuite.oapi.core.api.request.Request;
import com.larksuite.oapi.core.api.response.Response;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.service.contact.v3.ContactService;
import com.larksuite.oapi.service.contact.v3.model.User;
import com.larksuite.oapi.service.contact.v3.model.UserPatchResult;

public class ContactSample {
    // for test
    private static final Config config = Config.getTestInternalConf("online");

    public static void main(String[] args) throws Exception {
        ContactService contactService = new ContactService(config);

        User user = new User();
        user.setName("rename");

        Response<UserPatchResult> response = contactService.getUsers().patch(user, Request.setTenantKey("Tenant Key"))
                .setUserId("77bbc392").setUserIdType("user_id").execute();
        System.out.println(response.getRequestID());
        System.out.println(response.getHTTPStatusCode());
        System.out.println(Jsons.DEFAULT_GSON.toJson(response));
    }
}
