package com.larksuite.oapi.card;

import com.larksuite.oapi.card.exception.NotFoundHandlerException;
import com.larksuite.oapi.card.model.CardAction;
import com.larksuite.oapi.card.model.CustomResponse;
import com.larksuite.oapi.core.Constants;
import com.larksuite.oapi.core.IHandler;
import com.larksuite.oapi.core.exception.AuthChallengeException;
import com.larksuite.oapi.core.exception.HttpStatusCodeIllegalException;
import com.larksuite.oapi.core.exception.SignatureVerificationException;
import com.larksuite.oapi.core.request.EventReq;
import com.larksuite.oapi.core.response.EventResp;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.core.utils.Strings;
import com.larksuite.oapi.event.IEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class CardActionHandler implements IHandler {
    private static final Logger log = LoggerFactory.getLogger(CardActionHandler.class);
    private String verificationToken;
    private String encryptKey;
    private ICardHandler cardHandler;

    public CardActionHandler(Builder builder) {
        this.verificationToken = builder.verificationToken;
        this.encryptKey = builder.encryptKey;
        this.cardHandler = builder.cardHandler;
    }

    public static Builder newBuilder(String verificationToken, String encryptKey, ICardHandler cardHandler) {
        return new Builder(verificationToken, encryptKey, cardHandler);
    }

    private boolean verifySign(EventReq eventReq) throws NoSuchAlgorithmException {
        if (Strings.isEmpty(verificationToken)) {
            return true;
        }

        String cipherEventJsonStr = new String(eventReq.getBody(), StandardCharsets.UTF_8);
        String timestamp, nonce, sourceSign, targetSign;
        timestamp = eventReq.getHeaderFirstValue(Constants.X_LARK_REQUEST_TIMESTAMP);
        nonce = eventReq.getHeaderFirstValue(Constants.X_LARK_REQUEST_NONCE);
        sourceSign = eventReq.getHeaderFirstValue(Constants.X_LARK_SIGNATURE);
        targetSign = calculateSignature(timestamp, nonce, verificationToken, cipherEventJsonStr);
        return targetSign.equals(sourceSign);
    }

    protected String calculateSignature(String timestamp, String nonce, String token, String bodyString) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        String s = timestamp + nonce + token + bodyString;
        byte[] digest = messageDigest.digest(s.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString().toLowerCase();
    }

    private EventResp buildResult(Object result) {
        EventResp eventResp = new EventResp();
        eventResp.setStatusCode(200);
        eventResp.setContentType(Constants.CONTENT_TYPE);

        // 返回值设置
        if (result == null) {
            eventResp.setBody(String.format(EventResp.RESPONSE_FORMAT, "success").getBytes(StandardCharsets.UTF_8));
            return eventResp;
        }

        if (result instanceof String) {
            eventResp.setBody(((String) result).getBytes(StandardCharsets.UTF_8));
            return eventResp;
        }

        if (result instanceof String) {
            eventResp.setBody(((String) result).getBytes(StandardCharsets.UTF_8));
            return eventResp;
        }

        if (result instanceof CustomResponse) {
            if (((CustomResponse) result).getStatusCode() == 0) {
                throw new HttpStatusCodeIllegalException(0);
            }
            eventResp.setStatusCode(((CustomResponse) result).getStatusCode());
            eventResp.setBody(Jsons.DEFAULT_GSON.toJson(((CustomResponse) result).getBody()).getBytes(StandardCharsets.UTF_8));
            eventResp.setHeaders(((CustomResponse) result).getHeaders());
            return eventResp;
        }

        eventResp.setBody(Jsons.DEFAULT_GSON.toJson(result).getBytes(StandardCharsets.UTF_8));
        return eventResp;
    }

    @Override
    public EventResp handle(EventReq eventReq) throws Throwable {
        EventResp eventResp = new EventResp();
        eventResp.setStatusCode(200);
        eventResp.setContentType(Constants.CONTENT_TYPE);
        try {
            // 反序列化
            CardAction cardAction = Jsons.DEFAULT_GSON.fromJson(new String(eventReq.getBody(), StandardCharsets.UTF_8), CardAction.class);

            // auth by challenge
            if (Constants.URL_VERIFICATION.equals(cardAction.getType())) {
                if (!verificationToken.equals(cardAction.getToken())) {
                    throw new AuthChallengeException();
                }

                eventResp.setBody(String.format(EventResp.CHALLENGE_RESPONSE_FORMAT,
                        cardAction.getChallenge()).getBytes(StandardCharsets.UTF_8));
                return eventResp;
            }

            // 验签
            if (!Constants.URL_VERIFICATION.equals(cardAction.getType())) {
                if (!verifySign(eventReq)) {
                    throw new SignatureVerificationException();
                }
            }

            // 处理逻辑
            if (cardHandler == null) {
                throw new NotFoundHandlerException();
            }
            Object result = cardHandler.handle(cardAction);

            //返回结果
            return buildResult(result);

        } catch (Throwable e) {
            log.error("handle card action failed,requestId:{},err:{}", eventReq.getRequestID(), e);
            if (e instanceof NotFoundHandlerException) {
                eventResp.setBody(String.format(EventResp.RESPONSE_FORMAT,
                        e.getMessage()).getBytes(StandardCharsets.UTF_8));
                return eventResp;
            }

            eventResp.setStatusCode(500);
            eventResp.setBody(String.format(EventResp.RESPONSE_FORMAT,
                    e.getMessage()).getBytes(StandardCharsets.UTF_8));
        }

        return eventResp;
    }

    public interface ICardHandler {
        Object handle(CardAction cardAction) throws Throwable;
    }

    public static class Builder {
        private Map<String, IEventHandler> eventType2EventHandler = new HashMap<>();
        private String verificationToken;
        private String encryptKey;
        private ICardHandler cardHandler;

        public Builder(String verificationToken, String encryptKey, ICardHandler cardHandler) {
            this.verificationToken = verificationToken;
            this.encryptKey = encryptKey;
            this.cardHandler = cardHandler;
        }

        public CardActionHandler build() {
            return new CardActionHandler(this);
        }
    }
}
