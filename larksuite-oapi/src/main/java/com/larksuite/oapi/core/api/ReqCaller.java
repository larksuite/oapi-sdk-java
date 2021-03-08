package com.larksuite.oapi.core.api;

import com.larksuite.oapi.core.api.response.Response;

import java.util.concurrent.Callable;

public abstract class ReqCaller<I, O> implements Callable<ReqCaller<I, O>> {
    private int idx$$;
    private volatile Response<O> response;
    private volatile Exception exception;

    public abstract Response<O> execute() throws Exception;

    @Override
    public ReqCaller<I, O> call() {
        try {
            this.response = execute();
        } catch (Exception e) {
            this.exception = e;
        }
        return this;
    }

    protected int getIdx$$() {
        return idx$$;
    }

    protected void setIdx$$(int idx$$) {
        this.idx$$ = idx$$;
    }

    public Response<O> getResponse() {
        return response;
    }

    public Exception getException() {
        return exception;
    }
}
