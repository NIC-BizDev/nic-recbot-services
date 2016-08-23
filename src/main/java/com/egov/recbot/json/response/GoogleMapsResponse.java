package com.egov.recbot.json.response;

import com.egov.recbot.json.JsonBase;

import java.util.List;

public class GoogleMapsResponse extends JsonBase {

  private List<GoogleMapsResponseResult> results;

  public List<GoogleMapsResponseResult> getResults() {
    return this.results;
  }

  public void setResults(List<GoogleMapsResponseResult> results) {
    this.results = results;
  }

}
