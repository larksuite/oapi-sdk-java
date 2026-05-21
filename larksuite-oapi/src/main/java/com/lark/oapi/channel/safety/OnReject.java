package com.lark.oapi.channel.safety;

import com.lark.oapi.channel.model.RejectEvent;

public interface OnReject {
    void onReject(RejectEvent event);
}
