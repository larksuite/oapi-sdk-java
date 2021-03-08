package com.larksuite.oapi.core.api.request.requestoptfn;

import com.larksuite.oapi.core.api.request.RequestOpt;
import com.larksuite.oapi.core.api.request.RequestOptFn;

public class NotDataField implements RequestOptFn {

    @Override
    public void fn(RequestOpt opt) {
        opt.setNotDataField(true);
    }
}
