package com.larksuite.oapi.core.utils;

import com.larksuite.oapi.okhttp3_14.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class OKHttps {

    public static final OkHttpClient defaultClient = create(0, TimeUnit.MILLISECONDS);

    public static OkHttpClient create(long callTimeout, TimeUnit timeUnit) {
        return new OkHttpClient.Builder()
                .callTimeout(callTimeout, timeUnit)
                .build();
    }
}
