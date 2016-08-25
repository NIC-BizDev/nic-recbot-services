package com.egov.recbot.json.request;

import com.egov.recbot.json.JsonBase;

public class FbMessageRequestRecipient extends JsonBase {

  private String phone_number;
  private String id;


  public String getPhone_number() {
    return phone_number;
  }
  public void setPhone_number(String phone_number) {
    this.phone_number = phone_number;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

}
