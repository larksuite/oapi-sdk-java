// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;

public class ListAgentSchedule {

  @SerializedName("agent_schedules")
  private AgentSchedule[] agentSchedules;

  public AgentSchedule[] getAgentSchedules() {
    return this.agentSchedules;
  }

  public void setAgentSchedules(AgentSchedule[] agentSchedules) {
    this.agentSchedules = agentSchedules;
  }

}
