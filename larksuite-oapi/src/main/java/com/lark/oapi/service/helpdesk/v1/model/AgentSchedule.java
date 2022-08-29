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

package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;

public class AgentSchedule {

  /**
   * 客服状态, 1 - online客服, 2 - offline(手动)客服, 3 - off duty(下班)自动处于非服务时间段
   * <p> 示例值：1
   */
  @SerializedName("status")
  private Integer status;
  /**
   * 客服信息
   * <p> 示例值：
   */
  @SerializedName("agent")
  private AgentUser agent;
  /**
   * 工作日程列表
   * <p> 示例值：
   */
  @SerializedName("schedule")
  private WeekdaySchedule[] schedule;
  /**
   * 客服技能
   * <p> 示例值：
   */
  @SerializedName("agent_skills")
  private AgentSkillLessInfo[] agentSkills;

  // builder 开始
  public AgentSchedule() {
  }

  public AgentSchedule(Builder builder) {
    /**
     * 客服状态, 1 - online客服, 2 - offline(手动)客服, 3 - off duty(下班)自动处于非服务时间段
     * <p> 示例值：1
     */
    this.status = builder.status;
    /**
     * 客服信息
     * <p> 示例值：
     */
    this.agent = builder.agent;
    /**
     * 工作日程列表
     * <p> 示例值：
     */
    this.schedule = builder.schedule;
    /**
     * 客服技能
     * <p> 示例值：
     */
    this.agentSkills = builder.agentSkills;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public AgentUser getAgent() {
    return this.agent;
  }

  public void setAgent(AgentUser agent) {
    this.agent = agent;
  }

  public WeekdaySchedule[] getSchedule() {
    return this.schedule;
  }

  public void setSchedule(WeekdaySchedule[] schedule) {
    this.schedule = schedule;
  }

  public AgentSkillLessInfo[] getAgentSkills() {
    return this.agentSkills;
  }

  public void setAgentSkills(AgentSkillLessInfo[] agentSkills) {
    this.agentSkills = agentSkills;
  }

  public static class Builder {

    /**
     * 客服状态, 1 - online客服, 2 - offline(手动)客服, 3 - off duty(下班)自动处于非服务时间段
     * <p> 示例值：1
     */
    private Integer status;
    /**
     * 客服信息
     * <p> 示例值：
     */
    private AgentUser agent;
    /**
     * 工作日程列表
     * <p> 示例值：
     */
    private WeekdaySchedule[] schedule;
    /**
     * 客服技能
     * <p> 示例值：
     */
    private AgentSkillLessInfo[] agentSkills;

    /**
     * 客服状态, 1 - online客服, 2 - offline(手动)客服, 3 - off duty(下班)自动处于非服务时间段
     * <p> 示例值：1
     *
     * @param status
     * @return
     */
    public Builder status(Integer status) {
      this.status = status;
      return this;
    }


    /**
     * 客服信息
     * <p> 示例值：
     *
     * @param agent
     * @return
     */
    public Builder agent(AgentUser agent) {
      this.agent = agent;
      return this;
    }


    /**
     * 工作日程列表
     * <p> 示例值：
     *
     * @param schedule
     * @return
     */
    public Builder schedule(WeekdaySchedule[] schedule) {
      this.schedule = schedule;
      return this;
    }


    /**
     * 客服技能
     * <p> 示例值：
     *
     * @param agentSkills
     * @return
     */
    public Builder agentSkills(AgentSkillLessInfo[] agentSkills) {
      this.agentSkills = agentSkills;
      return this;
    }


    public AgentSchedule build() {
      return new AgentSchedule(this);
    }
  }
}