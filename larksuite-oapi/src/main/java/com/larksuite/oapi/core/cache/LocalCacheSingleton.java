package com.larksuite.oapi.core.cache;

public class LocalCacheSingleton {
    private static final LocalCache LOCAL_CACHE = new LocalCache();

    private LocalCacheSingleton() {
    }

    public static LocalCache getInstance() {
        return LOCAL_CACHE;
    }
}
