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
        context.set(Constants.HTTP_HEADER, request.getHeader());
        String timestamp = request.getHeader().firstValue(Header.X_LARK_REQUEST_TIMESTAMP);
        String nonce = request.getHeader().firstValue(Header.X_LARK_REQUEST_NONCE);
        String signature = request.getHeader().firstValue(Header.X_LARK_SIGNATURE);
        String refreshToken = request.getHeader().firstValue(Header.X_REFRESH_TOKEN);
        Header header = new Header(timestamp, nonce, signature, refreshToken);
        httpCard.setHeader(header);
        httpCard.setInput(httpCard.getRequest().getBody());
        log.debug("[init] header:{}, card: {}", header, httpCard.getInput());
    }
}
