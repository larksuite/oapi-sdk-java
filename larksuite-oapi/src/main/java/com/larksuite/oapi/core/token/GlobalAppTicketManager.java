package com.larksuite.oapi.core.token;

import com.larksuite.oapi.core.cache.LocalCacheSingleton;

public class GlobalAppTicketManager {
    private static volatile AppTicketManager globalAppTicketManager = new AppTicketManager(LocalCacheSingleton.getInstance());

    public static AppTicketManager getAppTicketManager() {
        return globalAppTicketManager;
    }

    public static void setAppTicketManager(AppTicketManager appTicketManager) {
        globalAppTicketManager = appTicketManager;
    }
}
