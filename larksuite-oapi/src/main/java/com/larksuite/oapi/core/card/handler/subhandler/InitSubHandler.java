package com.larksuite.oapi.core.card.handler.subhandler;

import com.larksuite.oapi.core.Constants;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.card.handler.ISubHandler;
import com.larksuite.oapi.core.card.mode.HTTPCard;
import com.larksuite.oapi.core.card.mode.Header;
import com.larksuite.oapi.core.model.OapiRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitSubHandler implements ISubHandler {

    private static final Logger log = LoggerFactory.getLogger(InitSubHandler.class);

    @Override
    public void handle(Context context, HTTPCard httpCard) throws Exception {
        OapiRequest request = httpCard.getRequest();
        String timestamp = request.getHeader().getFirstValue(Header.X_LARK_REQUEST_TIMESTAMP);
        String nonce = request.getHeader().getFirstValue(Header.X_LARK_REQUEST_NONCE);
        String signature = request.getHeader().getFirstValue(Header.X_LARK_SIGNATURE);
        String refreshToken = request.getHeader().getFirstValue(Header.X_REFRESH_TOKEN);
        Header header = new Header(timestamp, nonce, signature, refreshToken);
        httpCard.setHeader(header);
        context.set(Header.X_LARK_REQUEST_TIMESTAMP, timestamp);
        context.set(Header.X_LARK_REQUEST_NONCE, nonce);
        context.set(Header.X_LARK_SIGNATURE, signature);
        context.set(Header.X_REFRESH_TOKEN, refreshToken);
        String logID = request.getHeader().getFirstValue(Constants.HTTP_HEADER_KEY_LOG_ID);
        String requestID = request.getHeader().getFirstValue(Constants.HTTP_HEADER_KEY_REQUEST_ID);
        context.setRequestID(logID, requestID);
        httpCard.setInput(httpCard.getRequest().getBody());
        log.debug("[init] header:{}, card: {}", header, httpCard.getInput());
    }
}
