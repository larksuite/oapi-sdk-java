package com.larksuite.oapi.core.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

public class Jsons {

    public static final Gson LONG_TO_STR_GSON = createGSON(false, true);
    public static final Gson DEFAULT_GSON = createGSON(false, false);

    public static Gson createGSON(boolean isPretty, boolean longToStr) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        if (longToStr) {
            gsonBuilder.setLongSerializationPolicy(LongSerializationPolicy.STRING);
        }
        if (isPretty) {
            gsonBuilder.setPrettyPrinting();
        }
        return gsonBuilder.create();
    }

}
