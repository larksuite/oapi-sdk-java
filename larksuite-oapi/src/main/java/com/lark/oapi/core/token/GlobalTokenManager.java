package com.lark.oapi.core.token;

import com.lark.oapi.core.cache.LocalCache;

public class GlobalTokenManager {

  private static volatile TokenManager globalTokenManager = new TokenManager(
      LocalCache.getInstance());

  public static TokenManager getTokenManager() {
    return globalTokenManager;
  }

  public static void setTokenManager(TokenManager tokenManager) {
    globalTokenManager = tokenManager;
  }

}
