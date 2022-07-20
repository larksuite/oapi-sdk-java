/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lark.oapi.core.token;

import com.lark.oapi.core.Config;
import com.lark.oapi.core.Constants;
import com.lark.oapi.core.Transport;
import com.lark.oapi.core.cache.ICache;
import com.lark.oapi.core.request.ResendAppTicketReq;
import com.lark.oapi.core.utils.Sets;
import com.lark.oapi.core.utils.Strings;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppTicketManager {

  private static final Logger log = LoggerFactory.getLogger(AppTicketManager.class);
  private static final String APP_TICKET_PREFIX = "app_ticket";
  private ICache cache;

  public AppTicketManager(ICache cache) {
    this.cache = cache;
  }

  private String getKey(String appId) {
    return APP_TICKET_PREFIX + "-" + appId;
  }

  public void put(String appId, String value, int expire, TimeUnit timeUnit) {
    cache.set(getKey(appId), value, expire, timeUnit);
  }

  private void applyAppTicket(Config config) {
    ResendAppTicketReq applyAppTicketReq = new ResendAppTicketReq();
    applyAppTicketReq.setAppId(config.getAppId());
    applyAppTicketReq.setAppSecret(config.getAppSecret());
    try {
      Transport.send(config, null, "POST", Constants.APPLY_APP_TICKET_PATH,
          Sets.newHashSet(AccessTokenType.None), applyAppTicketReq);
    } catch (Exception e) {
      log.error("trigger appTicket resend failed ", e);
    }
  }

  public String get(Config config) throws Exception {
    String appTicket = cache.get(getKey(config.getAppId()));
    if (Strings.isEmpty(appTicket)) {
      // 触发重推
      applyAppTicket(config);
    }
    return appTicket;
  }
}
