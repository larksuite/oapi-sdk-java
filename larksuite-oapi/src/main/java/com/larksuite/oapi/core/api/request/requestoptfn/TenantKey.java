package com.larksuite.oapi.core.api.request.requestoptfn;

import com.larksuite.oapi.core.api.request.RequestOpt;
import com.larksuite.oapi.core.api.request.RequestOptFn;

public class TenantKey implements RequestOptFn {

    private String tenantKey;

    public TenantKey(String tenantKey) {
        this.tenantKey = tenantKey;
    }

    @Override
    public void fn(RequestOpt opt) {
        opt.setTenantKey(tenantKey);
    }
}
