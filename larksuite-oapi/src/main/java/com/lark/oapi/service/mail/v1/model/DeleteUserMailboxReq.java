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

package com.lark.oapi.service.mail.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

public class DeleteUserMailboxReq {

  /**
   * 用于接受转移的邮箱地址
   * <p> 示例值：888888@abc.com
   */
  @Query
  @SerializedName("transfer_mailbox")
  private String transferMailbox;
  /**
   * 要释放的邮箱地址
   * <p> 示例值：111111@abc.com
   */
  @Path
  @SerializedName("user_mailbox_id")
  private String userMailboxId;

  // builder 开始
  public DeleteUserMailboxReq() {
  }

  public DeleteUserMailboxReq(Builder builder) {
    /**
     * 用于接受转移的邮箱地址
     * <p> 示例值：888888@abc.com
     */
    this.transferMailbox = builder.transferMailbox;
    /**
     * 要释放的邮箱地址
     * <p> 示例值：111111@abc.com
     */
    this.userMailboxId = builder.userMailboxId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getTransferMailbox() {
    return this.transferMailbox;
  }

  public void setTransferMailbox(String transferMailbox) {
    this.transferMailbox = transferMailbox;
  }

  public String getUserMailboxId() {
    return this.userMailboxId;
  }

  public void setUserMailboxId(String userMailboxId) {
    this.userMailboxId = userMailboxId;
  }

  public static class Builder {

    private String transferMailbox; // 用于接受转移的邮箱地址
    private String userMailboxId; // 要释放的邮箱地址

    /**
     * 用于接受转移的邮箱地址
     * <p> 示例值：888888@abc.com
     *
     * @param transferMailbox
     * @return
     */
    public Builder transferMailbox(String transferMailbox) {
      this.transferMailbox = transferMailbox;
      return this;
    }

    /**
     * 要释放的邮箱地址
     * <p> 示例值：111111@abc.com
     *
     * @param userMailboxId
     * @return
     */
    public Builder userMailboxId(String userMailboxId) {
      this.userMailboxId = userMailboxId;
      return this;
    }

    public DeleteUserMailboxReq build() {
      return new DeleteUserMailboxReq(this);
    }
  }
}