package com.larksuite.oapi.core.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

public class Jsons {

    public static final Gson DEFAULT_GSON = createGSON(false);

    public static Gson createGSON(boolean isPretty) {
        GsonBuilder gsonBuilder = new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING);
        if (isPretty) {
            gsonBuilder.setPrettyPrinting();
        }
        return gsonBuilder.create();
    }

}
