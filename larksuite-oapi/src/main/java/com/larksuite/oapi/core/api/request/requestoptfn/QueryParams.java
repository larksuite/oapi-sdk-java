package com.larksuite.oapi.core.api.request.requestoptfn;

import com.larksuite.oapi.core.api.request.RequestOpt;
import com.larksuite.oapi.core.api.request.RequestOptFn;

import java.util.Map;

public class QueryParams implements RequestOptFn {
    private Map<String, Object> queryParams;

    public QueryParams(Map<String, Object> queryParams) {
        this.queryParams = queryParams;
    }

    @Override
    public void fn(RequestOpt opt) {
        opt.setQueryParams(queryParams);
    }
}
