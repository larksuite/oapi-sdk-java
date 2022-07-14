package com.lark.oapi.service.im.v1.model.ext;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.utils.Jsons;
import java.util.List;

public class MessagePost {

  public static Builder newBuilder() {
    return new Builder();
  }

  public static void main(String arg[]) {
    MessagePostA postA1 = MessagePostA.newBuilder().href("www.baidu").text("text1").build();
    MessagePostA postA2 = MessagePostA.newBuilder().href("www.baidu").text("text2").build();

    MessagePostAt at = new MessagePostAt();
    at.setUserId("userid1");
    at.setUserName("userName");

    List<MessagePostElement> segment1 = MessagePostSegment.newBuilder()
        .element(MessagePostA.newBuilder()
            .href("www.baidu")
            .text("text1")
            .build())
        .element(postA2)
        .build();

    List<MessagePostElement> segment2 = MessagePostSegment
        .newBuilder()
        .element(postA1)
        .element(postA2).
        build();

    List<MessagePostElement> segment3 = MessagePostSegment
        .newBuilder()
        .element(at)
        .element(postA2)
        .build();

    String post = MessagePost.newBuilder()
        .zhCn(MessagePostContent.newBuilder()
            .title("zhcn")
            .segment(segment1)
            .segment(segment2)
            .build())
        .enUs(MessagePostContent.newBuilder()
            .title("enUs")
            .segment(segment1)
            .segment(segment3)
            .build())
        .build();
    System.out.println(post);

  }

  public static final class Builder {

    @SerializedName("zh_cn")
    private MessagePostContent zhCn;
    @SerializedName("en_us")
    private MessagePostContent enUs;
    @SerializedName("ja_jp")
    private MessagePostContent jaJp;

    public Builder zhCn(MessagePostContent content) {
      this.zhCn = content;
      return this;
    }

    public Builder enUs(MessagePostContent content) {
      this.enUs = content;
      return this;
    }

    public Builder jaJp(MessagePostContent content) {
      this.enUs = content;
      return this;
    }

    public String build() {
      return Jsons.LONG_TO_STR.toJson(this);
    }

  }

}
