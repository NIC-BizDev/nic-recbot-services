package com.egov.recbot.json.request;

public class WebhookRequestResultMetadata {

  private String intentId;
  private String intentName;

  public String getIntentId() {
    return this.intentId;
  }

  public void setIntentId(String intentId) {
    this.intentId = intentId;
  }

  public String getIntentName() {
    return this.intentName;
  }

  public void setIntentName(String intentName) {
    this.intentName = intentName;
  }

}
