package com.egov.recbot.json.request;

import com.egov.recbot.json.JsonBase;

import java.util.Date;

public class WebhookRequest extends JsonBase {

  private String id;
  private Date timestamp;
  private WebhookRequestResult result;

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getTimestamp() {
    return this.timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public WebhookRequestResult getResult() {
    return this.result;
  }

  public void setResult(WebhookRequestResult result) {
    this.result = result;
  }

}
