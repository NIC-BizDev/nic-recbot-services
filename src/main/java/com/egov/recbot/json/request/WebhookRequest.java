package com.egov.recbot.json.request;

import java.util.Date;

public class WebhookRequest {

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

}
