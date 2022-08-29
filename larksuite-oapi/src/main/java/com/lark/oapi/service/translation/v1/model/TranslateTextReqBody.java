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

package com.lark.oapi.service.translation.v1.model;

import com.google.gson.annotations.SerializedName;

public class TranslateTextReqBody {

  /**
   * 源语言
   * <p> 示例值：zh
   */
  @SerializedName("source_language")
  private String sourceLanguage;
  /**
   * 源文本
   * <p> 示例值：尝试使用一下飞书吧
   */
  @SerializedName("text")
  private String text;
  /**
   * 目标语言
   * <p> 示例值：en
   */
  @SerializedName("target_language")
  private String targetLanguage;
  /**
   * 请求级术语表，携带术语，仅在本次翻译中生效（最多能携带 128个术语词）
   * <p> 示例值：
   */
  @SerializedName("glossary")
  private Term[] glossary;

  // builder 开始
  public TranslateTextReqBody() {
  }

  public TranslateTextReqBody(Builder builder) {
    /**
     * 源语言
     * <p> 示例值：zh
     */
    this.sourceLanguage = builder.sourceLanguage;
    /**
     * 源文本
     * <p> 示例值：尝试使用一下飞书吧
     */
    this.text = builder.text;
    /**
     * 目标语言
     * <p> 示例值：en
     */
    this.targetLanguage = builder.targetLanguage;
    /**
     * 请求级术语表，携带术语，仅在本次翻译中生效（最多能携带 128个术语词）
     * <p> 示例值：
     */
    this.glossary = builder.glossary;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getSourceLanguage() {
    return this.sourceLanguage;
  }

  public void setSourceLanguage(String sourceLanguage) {
    this.sourceLanguage = sourceLanguage;
  }

  public String getText() {
    return this.text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getTargetLanguage() {
    return this.targetLanguage;
  }

  public void setTargetLanguage(String targetLanguage) {
    this.targetLanguage = targetLanguage;
  }

  public Term[] getGlossary() {
    return this.glossary;
  }

  public void setGlossary(Term[] glossary) {
    this.glossary = glossary;
  }

  public static class Builder {

    /**
     * 源语言
     * <p> 示例值：zh
     */
    private String sourceLanguage;
    /**
     * 源文本
     * <p> 示例值：尝试使用一下飞书吧
     */
    private String text;
    /**
     * 目标语言
     * <p> 示例值：en
     */
    private String targetLanguage;
    /**
     * 请求级术语表，携带术语，仅在本次翻译中生效（最多能携带 128个术语词）
     * <p> 示例值：
     */
    private Term[] glossary;

    /**
     * 源语言
     * <p> 示例值：zh
     *
     * @param sourceLanguage
     * @return
     */
    public Builder sourceLanguage(String sourceLanguage) {
      this.sourceLanguage = sourceLanguage;
      return this;
    }


    /**
     * 源文本
     * <p> 示例值：尝试使用一下飞书吧
     *
     * @param text
     * @return
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }


    /**
     * 目标语言
     * <p> 示例值：en
     *
     * @param targetLanguage
     * @return
     */
    public Builder targetLanguage(String targetLanguage) {
      this.targetLanguage = targetLanguage;
      return this;
    }


    /**
     * 请求级术语表，携带术语，仅在本次翻译中生效（最多能携带 128个术语词）
     * <p> 示例值：
     *
     * @param glossary
     * @return
     */
    public Builder glossary(Term[] glossary) {
      this.glossary = glossary;
      return this;
    }


    public TranslateTextReqBody build() {
      return new TranslateTextReqBody(this);
    }
  }
}