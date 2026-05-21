package com.lark.oapi.channel.safety;

import com.lark.oapi.channel.model.NormalizedMessage;

public interface OnMessageDispatch {
    void onMessage(NormalizedMessage merged);
}
