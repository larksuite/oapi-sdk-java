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

package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;

public class CreateImageReqBody {

  /**
   * 图片类型
   * <p> 示例值：message
   */
  @SerializedName("image_type")
  private String imageType;
  /**
   * 图片内容;; **注意：** 上传的图片大小不能超过10MB
   * <p> 示例值：二进制文件
   */
  @SerializedName("image")
  private java.io.File image;

  // builder 开始
  public CreateImageReqBody() {
  }

  public CreateImageReqBody(Builder builder) {
    /**
     * 图片类型
     * <p> 示例值：message
     */
    this.imageType = builder.imageType;
    /**
     * 图片内容;; **注意：** 上传的图片大小不能超过10MB
     * <p> 示例值：二进制文件
     */
    this.image = builder.image;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getImageType() {
    return this.imageType;
  }

  public void setImageType(String imageType) {
    this.imageType = imageType;
  }

  public java.io.File getImage() {
    return this.image;
  }

  public void setImage(java.io.File image) {
    this.image = image;
  }

  public static class Builder {

    /**
     * 图片类型
     * <p> 示例值：message
     */
    private String imageType;
    /**
     * 图片内容;; **注意：** 上传的图片大小不能超过10MB
     * <p> 示例值：二进制文件
     */
    private java.io.File image;

    /**
     * 图片类型
     * <p> 示例值：message
     *
     * @param imageType
     * @return
     */
    public Builder imageType(String imageType) {
      this.imageType = imageType;
      return this;
    }

    /**
     * 图片类型
     * <p> 示例值：message
     *
     * @param imageType {@link com.lark.oapi.service.im.v1.enums.CreateImageImageTypeEnum}
     * @return
     */
    public Builder imageType(com.lark.oapi.service.im.v1.enums.CreateImageImageTypeEnum imageType) {
      this.imageType = imageType.getValue();
      return this;
    }


    /**
     * 图片内容;; **注意：** 上传的图片大小不能超过10MB
     * <p> 示例值：二进制文件
     *
     * @param image
     * @return
     */
    public Builder image(java.io.File image) {
      this.image = image;
      return this;
    }


    public CreateImageReqBody build() {
      return new CreateImageReqBody(this);
    }
  }
}