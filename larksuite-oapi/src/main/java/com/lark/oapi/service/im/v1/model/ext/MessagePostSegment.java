package com.lark.oapi.service.im.v1.model.ext;

import java.util.ArrayList;
import java.util.List;

public class MessagePostSegment {

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private List<MessagePostElement> elementList = new ArrayList<>();

    public Builder element(MessagePostElement e) {
      elementList.add(e);
      return this;
    }

    public List<MessagePostElement> build() {
      return elementList;
    }
  }
}
