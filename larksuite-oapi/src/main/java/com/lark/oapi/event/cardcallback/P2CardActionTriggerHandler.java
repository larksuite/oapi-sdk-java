package com.lark.oapi.event.cardcallback;

import com.lark.oapi.event.ICallBackHandler;
import com.lark.oapi.event.cardcallback.model.P2CardActionTrigger;
import com.lark.oapi.event.cardcallback.model.P2CardActionTriggerResponse;

public abstract class P2CardActionTriggerHandler implements ICallBackHandler<P2CardActionTrigger, P2CardActionTriggerResponse> {
    @Override
    public P2CardActionTrigger getEvent() {
        return new P2CardActionTrigger();
    }
}
