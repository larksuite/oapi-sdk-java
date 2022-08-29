// Code generated by lark suite oapi sdk gen
/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lark.oapi.service.face_detection.v1.model;

import com.google.gson.annotations.SerializedName;

public class FaceAttribute {

  /**
   * 性别信息：0 男性，1 女性
   * <p> 示例值：
   */
  @SerializedName("gender")
  private AttributeItem gender;
  /**
   * 年龄大小
   * <p> 示例值：19
   */
  @SerializedName("age")
  private Integer age;
  /**
   * 情绪：0 自然， 1 高兴，2 惊讶，3 害怕，4 悲伤，5 生气， 6 厌恶
   * <p> 示例值：
   */
  @SerializedName("emotion")
  private AttributeItem emotion;
  /**
   * 颜值打分：[0, 100]
   * <p> 示例值：88
   */
  @SerializedName("beauty")
  private Integer beauty;
  /**
   * 人脸姿态
   * <p> 示例值：
   */
  @SerializedName("pose")
  private FacePose pose;
  /**
   * 帽子：0 未戴帽子，1 戴帽子
   * <p> 示例值：
   */
  @SerializedName("hat")
  private AttributeItem hat;
  /**
   * 眼镜：0 未戴眼镜，1 戴眼镜
   * <p> 示例值：
   */
  @SerializedName("glass")
  private AttributeItem glass;
  /**
   * 口罩：0 未戴口罩，1 戴口罩
   * <p> 示例值：
   */
  @SerializedName("mask")
  private AttributeItem mask;

  // builder 开始
  public FaceAttribute() {
  }

  public FaceAttribute(Builder builder) {
    /**
     * 性别信息：0 男性，1 女性
     * <p> 示例值：
     */
    this.gender = builder.gender;
    /**
     * 年龄大小
     * <p> 示例值：19
     */
    this.age = builder.age;
    /**
     * 情绪：0 自然， 1 高兴，2 惊讶，3 害怕，4 悲伤，5 生气， 6 厌恶
     * <p> 示例值：
     */
    this.emotion = builder.emotion;
    /**
     * 颜值打分：[0, 100]
     * <p> 示例值：88
     */
    this.beauty = builder.beauty;
    /**
     * 人脸姿态
     * <p> 示例值：
     */
    this.pose = builder.pose;
    /**
     * 帽子：0 未戴帽子，1 戴帽子
     * <p> 示例值：
     */
    this.hat = builder.hat;
    /**
     * 眼镜：0 未戴眼镜，1 戴眼镜
     * <p> 示例值：
     */
    this.glass = builder.glass;
    /**
     * 口罩：0 未戴口罩，1 戴口罩
     * <p> 示例值：
     */
    this.mask = builder.mask;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public AttributeItem getGender() {
    return this.gender;
  }

  public void setGender(AttributeItem gender) {
    this.gender = gender;
  }

  public Integer getAge() {
    return this.age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public AttributeItem getEmotion() {
    return this.emotion;
  }

  public void setEmotion(AttributeItem emotion) {
    this.emotion = emotion;
  }

  public Integer getBeauty() {
    return this.beauty;
  }

  public void setBeauty(Integer beauty) {
    this.beauty = beauty;
  }

  public FacePose getPose() {
    return this.pose;
  }

  public void setPose(FacePose pose) {
    this.pose = pose;
  }

  public AttributeItem getHat() {
    return this.hat;
  }

  public void setHat(AttributeItem hat) {
    this.hat = hat;
  }

  public AttributeItem getGlass() {
    return this.glass;
  }

  public void setGlass(AttributeItem glass) {
    this.glass = glass;
  }

  public AttributeItem getMask() {
    return this.mask;
  }

  public void setMask(AttributeItem mask) {
    this.mask = mask;
  }

  public static class Builder {

    /**
     * 性别信息：0 男性，1 女性
     * <p> 示例值：
     */
    private AttributeItem gender;
    /**
     * 年龄大小
     * <p> 示例值：19
     */
    private Integer age;
    /**
     * 情绪：0 自然， 1 高兴，2 惊讶，3 害怕，4 悲伤，5 生气， 6 厌恶
     * <p> 示例值：
     */
    private AttributeItem emotion;
    /**
     * 颜值打分：[0, 100]
     * <p> 示例值：88
     */
    private Integer beauty;
    /**
     * 人脸姿态
     * <p> 示例值：
     */
    private FacePose pose;
    /**
     * 帽子：0 未戴帽子，1 戴帽子
     * <p> 示例值：
     */
    private AttributeItem hat;
    /**
     * 眼镜：0 未戴眼镜，1 戴眼镜
     * <p> 示例值：
     */
    private AttributeItem glass;
    /**
     * 口罩：0 未戴口罩，1 戴口罩
     * <p> 示例值：
     */
    private AttributeItem mask;

    /**
     * 性别信息：0 男性，1 女性
     * <p> 示例值：
     *
     * @param gender
     * @return
     */
    public Builder gender(AttributeItem gender) {
      this.gender = gender;
      return this;
    }


    /**
     * 年龄大小
     * <p> 示例值：19
     *
     * @param age
     * @return
     */
    public Builder age(Integer age) {
      this.age = age;
      return this;
    }


    /**
     * 情绪：0 自然， 1 高兴，2 惊讶，3 害怕，4 悲伤，5 生气， 6 厌恶
     * <p> 示例值：
     *
     * @param emotion
     * @return
     */
    public Builder emotion(AttributeItem emotion) {
      this.emotion = emotion;
      return this;
    }


    /**
     * 颜值打分：[0, 100]
     * <p> 示例值：88
     *
     * @param beauty
     * @return
     */
    public Builder beauty(Integer beauty) {
      this.beauty = beauty;
      return this;
    }


    /**
     * 人脸姿态
     * <p> 示例值：
     *
     * @param pose
     * @return
     */
    public Builder pose(FacePose pose) {
      this.pose = pose;
      return this;
    }


    /**
     * 帽子：0 未戴帽子，1 戴帽子
     * <p> 示例值：
     *
     * @param hat
     * @return
     */
    public Builder hat(AttributeItem hat) {
      this.hat = hat;
      return this;
    }


    /**
     * 眼镜：0 未戴眼镜，1 戴眼镜
     * <p> 示例值：
     *
     * @param glass
     * @return
     */
    public Builder glass(AttributeItem glass) {
      this.glass = glass;
      return this;
    }


    /**
     * 口罩：0 未戴口罩，1 戴口罩
     * <p> 示例值：
     *
     * @param mask
     * @return
     */
    public Builder mask(AttributeItem mask) {
      this.mask = mask;
      return this;
    }


    public FaceAttribute build() {
      return new FaceAttribute(this);
    }
  }
}