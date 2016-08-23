package com.egov.recbot.json.response;

import com.egov.recbot.json.JsonBase;

import java.util.List;

public class RidbResponse extends JsonBase {

  private List<RidbResponseRecdata> RECDATA;

  public List<RidbResponseRecdata> getRECDATA() {
    return this.RECDATA;
  }

  public void setRECDATA(List<RidbResponseRecdata> RECDATA) {
    this.RECDATA = RECDATA;
  }

}
