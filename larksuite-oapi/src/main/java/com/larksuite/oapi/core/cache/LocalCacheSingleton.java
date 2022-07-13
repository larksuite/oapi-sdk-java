package com.larksuite.oapi.core.cache;

// TODO 直接由 LocalCache 提供单例是不是更简洁
public class LocalCacheSingleton {
    private static final LocalCache LOCAL_CACHE = new LocalCache();

    private LocalCacheSingleton() {}

    public static LocalCache getInstance() {
        return LOCAL_CACHE;
    }
}
