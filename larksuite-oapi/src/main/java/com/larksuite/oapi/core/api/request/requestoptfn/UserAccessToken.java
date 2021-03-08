package com.larksuite.oapi.core.api.request.requestoptfn;

import com.larksuite.oapi.core.api.request.RequestOpt;
import com.larksuite.oapi.core.api.request.RequestOptFn;

public class UserAccessToken implements RequestOptFn {

    private String userAccessToken;

    public UserAccessToken(String userAccessToken) {
        this.userAccessToken = userAccessToken;
    }

    @Override
    public void fn(RequestOpt opt) {
        opt.setUserAccessToken(userAccessToken);
    }
}
