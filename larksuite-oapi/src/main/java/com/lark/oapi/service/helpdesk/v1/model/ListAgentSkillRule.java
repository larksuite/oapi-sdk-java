// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;

public class ListAgentSkillRule {

  @SerializedName("rules")
  private AgentSkillRule[] rules;

  public AgentSkillRule[] getRules() {
    return this.rules;
  }

  public void setRules(AgentSkillRule[] rules) {
    this.rules = rules;
  }

}
