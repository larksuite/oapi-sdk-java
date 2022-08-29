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

package com.lark.oapi.service.wiki.v2.model;

import com.google.gson.annotations.SerializedName;

public class Space {

  /**
   * 知识空间名称
   * <p> 示例值：知识空间
   */
  @SerializedName("name")
  private String name;
  /**
   * 知识空间描述
   * <p> 示例值：知识空间描述
   */
  @SerializedName("description")
  private String description;
  /**
   * 知识空间id
   * <p> 示例值：1565676577122621
   */
  @SerializedName("space_id")
  private String spaceId;
  /**
   * 表示知识空间类型（团队空间 或 个人空间）
   * <p> 示例值：team
   */
  @SerializedName("space_type")
  private String spaceType;
  /**
   * 表示知识空间可见性（公开空间 或 私有空间）
   * <p> 示例值：private
   */
  @SerializedName("visibility")
  private String visibility;

  // builder 开始
  public Space() {
  }

  public Space(Builder builder) {
    /**
     * 知识空间名称
     * <p> 示例值：知识空间
     */
    this.name = builder.name;
    /**
     * 知识空间描述
     * <p> 示例值：知识空间描述
     */
    this.description = builder.description;
    /**
     * 知识空间id
     * <p> 示例值：1565676577122621
     */
    this.spaceId = builder.spaceId;
    /**
     * 表示知识空间类型（团队空间 或 个人空间）
     * <p> 示例值：team
     */
    this.spaceType = builder.spaceType;
    /**
     * 表示知识空间可见性（公开空间 或 私有空间）
     * <p> 示例值：private
     */
    this.visibility = builder.visibility;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSpaceId() {
    return this.spaceId;
  }

  public void setSpaceId(String spaceId) {
    this.spaceId = spaceId;
  }

  public String getSpaceType() {
    return this.spaceType;
  }

  public void setSpaceType(String spaceType) {
    this.spaceType = spaceType;
  }

  public String getVisibility() {
    return this.visibility;
  }

  public void setVisibility(String visibility) {
    this.visibility = visibility;
  }

  public static class Builder {

    /**
     * 知识空间名称
     * <p> 示例值：知识空间
     */
    private String name;
    /**
     * 知识空间描述
     * <p> 示例值：知识空间描述
     */
    private String description;
    /**
     * 知识空间id
     * <p> 示例值：1565676577122621
     */
    private String spaceId;
    /**
     * 表示知识空间类型（团队空间 或 个人空间）
     * <p> 示例值：team
     */
    private String spaceType;
    /**
     * 表示知识空间可见性（公开空间 或 私有空间）
     * <p> 示例值：private
     */
    private String visibility;

    /**
     * 知识空间名称
     * <p> 示例值：知识空间
     *
     * @param name
     * @return
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }


    /**
     * 知识空间描述
     * <p> 示例值：知识空间描述
     *
     * @param description
     * @return
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }


    /**
     * 知识空间id
     * <p> 示例值：1565676577122621
     *
     * @param spaceId
     * @return
     */
    public Builder spaceId(String spaceId) {
      this.spaceId = spaceId;
      return this;
    }


    /**
     * 表示知识空间类型（团队空间 或 个人空间）
     * <p> 示例值：team
     *
     * @param spaceType
     * @return
     */
    public Builder spaceType(String spaceType) {
      this.spaceType = spaceType;
      return this;
    }

    /**
     * 表示知识空间类型（团队空间 或 个人空间）
     * <p> 示例值：team
     *
     * @param spaceType {@link com.lark.oapi.service.wiki.v2.enums.SpaceSpaceTypeEnum}
     * @return
     */
    public Builder spaceType(com.lark.oapi.service.wiki.v2.enums.SpaceSpaceTypeEnum spaceType) {
      this.spaceType = spaceType.getValue();
      return this;
    }


    /**
     * 表示知识空间可见性（公开空间 或 私有空间）
     * <p> 示例值：private
     *
     * @param visibility
     * @return
     */
    public Builder visibility(String visibility) {
      this.visibility = visibility;
      return this;
    }

    /**
     * 表示知识空间可见性（公开空间 或 私有空间）
     * <p> 示例值：private
     *
     * @param visibility {@link com.lark.oapi.service.wiki.v2.enums.SpaceSpaceVisibilityEnum}
     * @return
     */
    public Builder visibility(
        com.lark.oapi.service.wiki.v2.enums.SpaceSpaceVisibilityEnum visibility) {
      this.visibility = visibility.getValue();
      return this;
    }


    public Space build() {
      return new Space(this);
    }
  }
}