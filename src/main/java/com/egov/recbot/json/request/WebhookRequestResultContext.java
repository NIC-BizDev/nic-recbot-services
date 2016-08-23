package com.egov.recbot.json.request;

import java.util.Map;

public class WebhookRequestResultContext {

  private String name;
  private Map<String, String> parameters;
  private Integer lifespan;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Map<String, String> getParameters() {
    return this.parameters;
  }

  public void setParameters(Map<String, String> parameters) {
    this.parameters = parameters;
  }

  public Integer getLifespan() {
    return this.lifespan;
  }

  public void setLifespan(Integer lifespan) {
    this.lifespan = lifespan;
  }

}
