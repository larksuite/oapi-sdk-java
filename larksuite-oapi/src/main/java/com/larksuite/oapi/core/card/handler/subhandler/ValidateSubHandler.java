package com.larksuite.oapi.core.card.handler.subhandler;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.card.exception.SignatureException;
import com.larksuite.oapi.core.card.handler.ISubHandler;
import com.larksuite.oapi.core.card.mode.HTTPCard;
import com.larksuite.oapi.core.card.mode.Header;
import com.larksuite.oapi.core.utils.Strings;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ValidateSubHandler implements ISubHandler {
    @Override
    public void handle(Context context, HTTPCard httpCard) throws Exception {
        if (Strings.isEmpty(httpCard.getHeader().getSignature())) {
            return;
        }
        Config config = Config.ByCtx(context);
        Header header = httpCard.getHeader();
        String targetSig = signature(header.getTimestamp(), header.getNonce(),
                config.getAppSettings().getVerificationToken(), httpCard.getInput());
        if (!targetSig.equals(header.getSignature())) {
            throw new SignatureException();
        }
    }

    private String signature(String timestamp, String nonce, String token, String body) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        String s = timestamp + nonce + token + body;
        byte[] digest = messageDigest.digest(s.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString().toLowerCase();
    }
}
