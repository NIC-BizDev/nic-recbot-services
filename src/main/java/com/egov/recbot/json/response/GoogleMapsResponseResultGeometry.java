package com.egov.recbot.json.response;

import com.egov.recbot.json.JsonBase;

import java.util.Map;

public class GoogleMapsResponseResultGeometry extends JsonBase {

  private Map<String, Double> location;

  public Map<String, Double> getLocation() {
    return this.location;
  }

  public void setLocation(Map<String, Double> location) {
    this.location = location;
  }

}
