package com.lark.oapi.core.token;

import com.lark.oapi.core.Config;
import com.lark.oapi.core.Constants;
import com.lark.oapi.core.Transport;
import com.lark.oapi.core.cache.ICache;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.utils.Sets;
import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.core.utils.UnmarshalRespUtil;
import com.lark.oapi.service.ext.model.JsSdkTicketResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class JsSdkTicketManager {

    private static final Logger log = LoggerFactory.getLogger(TokenManager.class);
    private static final int expiryDeltaOfSecond = 3 * 60;
    private static final String JS_SDK_TICKET_PREFIX = "js_skd_ticket";
    private ICache cache;

    public JsSdkTicketManager(ICache cache) {
        this.cache = cache;
    }

    private String getKey(String appId) {
        return JS_SDK_TICKET_PREFIX + "-" + appId;
    }

    public void put(String appId, String value, int expire, TimeUnit timeUnit) {
        cache.set(getKey(appId), value, expire, timeUnit);
    }

    private void getJsSdkTicket(Config config) {
        try {
            RawResponse resp = Transport.send(config
                , RequestOptions.newBuilder().build()
                , "POST"
                , Constants.JS_SDK_TICKET_GET_URL_PATH
                , Sets.newHashSet(AccessTokenType.Tenant), null);

            JsSdkTicketResp jsSdkTicketResp = UnmarshalRespUtil.unmarshalResp(resp,
                JsSdkTicketResp.class);

            String ticket = jsSdkTicketResp.getData().getTicket();
            int timeOut = jsSdkTicketResp.getData().getExpiresIn();
            put(config.getAppId(), ticket, timeOut - expiryDeltaOfSecond, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("get JsSdkTicket failed ", e);
        }
    }

    public String get(Config config) throws Exception {
        String jsSdkTicket = cache.get(getKey(config.getAppId()));
        if (Strings.isEmpty(jsSdkTicket)) {
            // 触发重新获取
            getJsSdkTicket(config);
        }
        return jsSdkTicket;
    }
}
