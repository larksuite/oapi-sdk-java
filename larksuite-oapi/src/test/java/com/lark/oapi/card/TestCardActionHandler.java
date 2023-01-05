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

package com.lark.oapi.card;

import com.lark.oapi.card.model.CardAction;
import com.lark.oapi.core.Constants;
import com.lark.oapi.core.request.EventReq;
import com.lark.oapi.core.response.EventResp;
import com.lark.oapi.core.utils.Jsons;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCardActionHandler {

    @Test
    public void testVerifyUrlOK() throws Throwable {
        CardActionHandler actionHandler = CardActionHandler.newBuilder("token", "",
                new CardActionHandler.ICardHandler() {
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
        String bodyStr = Jsons.DEFAULT.toJson(cardAction);

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
        CardActionHandler actionHandler = CardActionHandler.newBuilder("token", "",
                new CardActionHandler.ICardHandler() {
                    @Override
                    public Object handle(CardAction cardAction) throws Throwable {
                        System.out.println(Jsons.DEFAULT.toJson(cardAction));
                        return null;
                    }
                }).build();

        CardAction cardAction = new CardAction();
        cardAction.setOpenId("ou_sdfimx9948345");
        cardAction.setUserId("ou_sdfimx9948343");
        cardAction.setToken("token1");
        String bodyStr = Jsons.DEFAULT.toJson(cardAction);

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
