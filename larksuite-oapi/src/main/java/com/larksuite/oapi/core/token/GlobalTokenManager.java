package com.larksuite.oapi.core.token;

import com.larksuite.oapi.core.cache.LocalCacheSingleton;

public class GlobalTokenManager {
    private static volatile TokenManager globalTokenManager = new TokenManager(LocalCacheSingleton.getInstance());

    public static TokenManager getTokenManager() {
        return globalTokenManager;
    }

    public static void setTokenManager(TokenManager tokenManager) {
        globalTokenManager = tokenManager;
    }

}
