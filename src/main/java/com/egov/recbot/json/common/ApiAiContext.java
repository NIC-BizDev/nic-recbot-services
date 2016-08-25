package com.egov.recbot.json.common;

import com.egov.recbot.json.JsonBase;

import java.util.List;
import java.util.Map;

public class ApiAiContext extends JsonBase {

  private String name;
  private Map<String,String> parameters;
  private Integer lifespan;


  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public Map<String, String> getParameters() {
    return parameters;
  }
  public void setParameters(Map<String, String> parameters) {
    this.parameters = parameters;
  }

  public Integer getLifespan() {
    return lifespan;
  }
  public void setLifespan(Integer lifespan) {
    this.lifespan = lifespan;
  }
}
