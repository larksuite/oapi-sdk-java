package com.larksuite.oapi.core.api.request.requestoptfn;

import com.larksuite.oapi.core.api.request.RequestOpt;
import com.larksuite.oapi.core.api.request.RequestOptFn;

public class ResponseStream implements RequestOptFn {

    @Override
    public void fn(RequestOpt opt) {
        opt.setResponseStream(true);
    }
}
