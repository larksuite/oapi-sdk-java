package com.lark.oapi.core.token;

import com.lark.oapi.core.cache.LocalCache;

public class GlobalAppTicketManager {

  private static volatile AppTicketManager globalAppTicketManager = new AppTicketManager(
      LocalCache.getInstance());

  public static AppTicketManager getAppTicketManager() {
    return globalAppTicketManager;
  }

  public static void setAppTicketManager(AppTicketManager appTicketManager) {
    globalAppTicketManager = appTicketManager;
  }
}
