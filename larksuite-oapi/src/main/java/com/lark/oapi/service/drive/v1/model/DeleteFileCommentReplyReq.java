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

package com.lark.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

public class DeleteFileCommentReplyReq {

  /**
   * 文档类型
   * <p> 示例值：doc
   */
  @Query
  @SerializedName("file_type")
  private String fileType;
  /**
   * 文档token
   * <p> 示例值：doccnHh7U87HOFpii5u5G*****
   */
  @Path
  @SerializedName("file_token")
  private String fileToken;
  /**
   * 评论ID
   * <p> 示例值：6916106822734578184
   */
  @Path
  @SerializedName("comment_id")
  private String commentId;
  /**
   * 回复ID
   * <p> 示例值：6916106822734594568
   */
  @Path
  @SerializedName("reply_id")
  private String replyId;
  // builder 开始
  public DeleteFileCommentReplyReq() {
  }
  public DeleteFileCommentReplyReq(Builder builder) {
    /**
     * 文档类型
     * <p> 示例值：doc
     */
    this.fileType = builder.fileType;
    /**
     * 文档token
     * <p> 示例值：doccnHh7U87HOFpii5u5G*****
     */
    this.fileToken = builder.fileToken;
    /**
     * 评论ID
     * <p> 示例值：6916106822734578184
     */
    this.commentId = builder.commentId;
    /**
     * 回复ID
     * <p> 示例值：6916106822734594568
     */
    this.replyId = builder.replyId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getFileType() {
    return this.fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public String getFileToken() {
    return this.fileToken;
  }

  public void setFileToken(String fileToken) {
    this.fileToken = fileToken;
  }

  public String getCommentId() {
    return this.commentId;
  }

  public void setCommentId(String commentId) {
    this.commentId = commentId;
  }

  public String getReplyId() {
    return this.replyId;
  }

  public void setReplyId(String replyId) {
    this.replyId = replyId;
  }

  public static class Builder {

    private String fileType; // 文档类型
    private String fileToken; // 文档token
    private String commentId; // 评论ID
    private String replyId; // 回复ID

    /**
     * 文档类型
     * <p> 示例值：doc
     *
     * @param fileType
     * @return
     */
    public Builder fileType(String fileType) {
      this.fileType = fileType;
      return this;
    }

    /**
     * 文档类型
     * <p> 示例值：doc
     *
     * @param fileType {@link com.lark.oapi.service.drive.v1.enums.DeleteFileCommentReplyFileTypeEnum}
     * @return
     */
    public Builder fileType(
        com.lark.oapi.service.drive.v1.enums.DeleteFileCommentReplyFileTypeEnum fileType) {
      this.fileType = fileType.getValue();
      return this;
    }

    /**
     * 文档token
     * <p> 示例值：doccnHh7U87HOFpii5u5G*****
     *
     * @param fileToken
     * @return
     */
    public Builder fileToken(String fileToken) {
      this.fileToken = fileToken;
      return this;
    }


    /**
     * 评论ID
     * <p> 示例值：6916106822734578184
     *
     * @param commentId
     * @return
     */
    public Builder commentId(String commentId) {
      this.commentId = commentId;
      return this;
    }


    /**
     * 回复ID
     * <p> 示例值：6916106822734594568
     *
     * @param replyId
     * @return
     */
    public Builder replyId(String replyId) {
      this.replyId = replyId;
      return this;
    }

    public DeleteFileCommentReplyReq build() {
      return new DeleteFileCommentReplyReq(this);
    }
  }
}