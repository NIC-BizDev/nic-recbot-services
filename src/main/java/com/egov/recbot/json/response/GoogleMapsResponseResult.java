package com.egov.recbot.json.response;

import com.egov.recbot.json.JsonBase;

public class GoogleMapsResponseResult extends JsonBase {

  private GoogleMapsResponseResultGeometry geometry;

  public GoogleMapsResponseResultGeometry getGeometry() {
    return this.geometry;
  }

  public void setGeometry(GoogleMapsResponseResultGeometry geometry) {
    this.geometry = geometry;
  }

}
