package com.lark.oapi.service.im.v1.model.ext;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class MessagePostContent {

  @SerializedName("text")
  private String title;
  @SerializedName("content")
  private MessagePostElement[][] content;

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private String title;
    private List<List<MessagePostElement>> content = new ArrayList();

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder segment(List<MessagePostElement> segment) {
      content.add(segment);
      return this;
    }

    public MessagePostContent build() {
      MessagePostContent postContent = new MessagePostContent();
      postContent.title = this.title;
      postContent.content = new MessagePostElement[content.size()][];
      int i = 0;
      for (List<MessagePostElement> list : content) {
        postContent.content[i++] = list.toArray(new MessagePostElement[0]);
      }

      return postContent;
    }
  }
}
