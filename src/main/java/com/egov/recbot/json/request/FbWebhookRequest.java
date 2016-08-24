package com.egov.recbot.json.request;

import com.egov.recbot.json.JsonBase;

import java.util.Date;

public class FbWebhookRequest extends JsonBase {

  private FbWebhookRequestMessage message;

  public void setMessage (FbWebhookRequestMessage message){this.message = message;}
  public FbWebhookRequestMessage getMessage() {
    return this.message;
  }


}
