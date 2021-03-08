package com.larksuite.oapi.core.api.request.requestoptfn;

import com.larksuite.oapi.core.api.request.RequestOpt;
import com.larksuite.oapi.core.api.request.RequestOptFn;

import java.util.concurrent.TimeUnit;

public class Timeout implements RequestOptFn {

    private long ms;

    public Timeout(int time, TimeUnit timeUnit) {
        this.ms = timeUnit.toMillis(time);
    }

    @Override
    public void fn(RequestOpt opt) {
        opt.setTimeoutOfMs(ms);
    }
}
