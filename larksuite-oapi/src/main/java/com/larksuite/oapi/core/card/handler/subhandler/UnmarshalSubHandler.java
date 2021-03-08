package com.larksuite.oapi.core.card.handler.subhandler;

import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Constants;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.card.handler.ISubHandler;
import com.larksuite.oapi.core.card.mode.Challenge;
import com.larksuite.oapi.core.card.mode.HTTPCard;
import com.larksuite.oapi.core.exception.TokenInvalidException;
import com.larksuite.oapi.core.utils.Jsons;

public class UnmarshalSubHandler implements ISubHandler {
    @Override
    public void handle(Context context, HTTPCard httpCard) throws Exception {
        Challenge challenge = Jsons.DEFAULT_GSON.fromJson(httpCard.getInput(), Challenge.class);
        httpCard.setType(challenge.getType());
        httpCard.setChallenge(challenge.getChallenge());
        if (Constants.URL_VERIFICATION.equals(httpCard.getType())) {
            if (!Config.ByCtx(context).getAppSettings().getVerificationToken().equals(challenge.getToken())) {
                throw new TokenInvalidException(challenge.getToken());
            }
        }
    }
}
