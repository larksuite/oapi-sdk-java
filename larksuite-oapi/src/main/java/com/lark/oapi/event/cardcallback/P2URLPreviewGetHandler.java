package com.lark.oapi.event.cardcallback;

import com.lark.oapi.event.ICallBackHandler;
import com.lark.oapi.event.cardcallback.model.P2URLPreviewGet;
import com.lark.oapi.event.cardcallback.model.P2URLPreviewGetResponse;

public abstract class P2URLPreviewGetHandler implements ICallBackHandler<P2URLPreviewGet, P2URLPreviewGetResponse> {
    @Override
    public P2URLPreviewGet getEvent() {
        return new P2URLPreviewGet();
    }
}
