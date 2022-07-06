package com.larksuite.oapi.card;

import com.larksuite.oapi.card.model.CardAction;
import com.larksuite.oapi.core.Constants;
import com.larksuite.oapi.core.request.EventReq;
import com.larksuite.oapi.core.response.EventResp;
import com.larksuite.oapi.core.utils.Jsons;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCardActionHandler {

    @Test
    public void testVerifyUrlOK() throws Throwable {
        CardActionHandler actionHandler = CardActionHandler.newBuilder("token", "", new CardActionHandler.ICardHandler() {
            @Override
            public Object handle(CardAction cardAction) throws Throwable {
                return null;
            }
        }).build();

        CardAction cardAction = new CardAction();
        cardAction.setOpenId("ou_sdfimx9948345");
        cardAction.setUserId("ou_sdfimx9948343");
        cardAction.setToken("token");
        cardAction.setType(Constants.URL_VERIFICATION);
        String bodyStr = Jsons.LONG_TO_STR_GSON.toJson(cardAction);

        Map<String, List<String>> map = new HashMap<>();
        map.put(Constants.X_LARK_REQUEST_TIMESTAMP.toLowerCase(), Arrays.asList("timestamp"));
        map.put(Constants.X_LARK_REQUEST_NONCE.toLowerCase(), Arrays.asList("nonce"));
        String signature = actionHandler.calculateSignature("timestamp", "nonce", "token", bodyStr);
        map.put(Constants.X_LARK_SIGNATURE.toLowerCase(), Arrays.asList(signature));

        EventReq req = new EventReq();
        req.setHeaders(map);
        req.setBody(bodyStr.getBytes(StandardCharsets.UTF_8));


        EventResp resp = actionHandler.handle(req);
        assert resp != null;
    }

    @Test
    public void testProcessOk() throws Throwable {
        CardActionHandler actionHandler = CardActionHandler.newBuilder("token", "", new CardActionHandler.ICardHandler() {
            @Override
            public Object handle(CardAction cardAction) throws Throwable {
                System.out.println(Jsons.LONG_TO_STR_GSON.toJson(cardAction));
                return null;
            }
        }).build();

        CardAction cardAction = new CardAction();
        cardAction.setOpenId("ou_sdfimx9948345");
        cardAction.setUserId("ou_sdfimx9948343");
        cardAction.setToken("token1");
        String bodyStr = Jsons.LONG_TO_STR_GSON.toJson(cardAction);

        Map<String, List<String>> map = new HashMap<>();
        map.put(Constants.X_LARK_REQUEST_TIMESTAMP.toLowerCase(), Arrays.asList("timestamp"));
        map.put(Constants.X_LARK_REQUEST_NONCE.toLowerCase(), Arrays.asList("nonce"));
        String signature = actionHandler.calculateSignature("timestamp", "nonce", "token", bodyStr);
        map.put(Constants.X_LARK_SIGNATURE.toLowerCase(), Arrays.asList(signature));

        EventReq req = new EventReq();
        req.setHeaders(map);
        req.setBody(bodyStr.getBytes(StandardCharsets.UTF_8));


        EventResp resp = actionHandler.handle(req);
        assert resp != null;

    }

}
