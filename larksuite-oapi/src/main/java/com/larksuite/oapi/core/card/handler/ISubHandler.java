package com.larksuite.oapi.core.card.handler;

import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.card.mode.HTTPCard;

public interface ISubHandler {
    void handle(Context context, HTTPCard httpCard) throws Exception;
}
