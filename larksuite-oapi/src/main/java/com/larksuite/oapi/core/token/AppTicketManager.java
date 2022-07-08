package com.larksuite.oapi.core.token;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Constants;
import com.larksuite.oapi.core.Transport;
import com.larksuite.oapi.core.cache.ICache;
import com.larksuite.oapi.core.request.ApplyAppTicketReq;
import com.larksuite.oapi.core.utils.Sets;
import com.larksuite.oapi.core.utils.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

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
        ApplyAppTicketReq applyAppTicketReq = new ApplyAppTicketReq();
        applyAppTicketReq.setAppId(config.getAppId());
        applyAppTicketReq.setAppSecret(config.getAppSecret());
        try {
            Transport.send(config, null, "POST", Constants.APPLY_APP_TICKET_PATH, Sets.newHashSet(AccessTokenType.None), applyAppTicketReq);
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
