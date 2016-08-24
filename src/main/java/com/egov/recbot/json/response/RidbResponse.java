package com.egov.recbot.json.response;

import com.egov.recbot.json.JsonBase;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RidbResponse extends JsonBase {

  @JsonProperty("RECDATA")
  private List<RidbResponseRecdata> recdata;

  public List<RidbResponseRecdata> getRecdata() {
    return this.recdata;
  }

  public void setRecdata(List<RidbResponseRecdata> recdata) {
    this.recdata = recdata;
  }

}
