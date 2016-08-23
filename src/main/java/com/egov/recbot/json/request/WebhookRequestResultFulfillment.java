package com.egov.recbot.json.request;

import com.egov.recbot.json.JsonBase;

public class WebhookRequestResultFulfillment extends JsonBase {

  private String speech;

  public String getSpeech() {
    return this.speech;
  }

  public void setSpeech(String speech) {
    this.speech = speech;
  }

}
