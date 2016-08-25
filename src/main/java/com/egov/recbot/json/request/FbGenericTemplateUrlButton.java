package com.egov.recbot.json.request;

import com.egov.recbot.json.JsonBase;


public class FbGenericTemplateUrlButton extends JsonBase {

  private String type = "web_url";
  private String url;
  private String title;


  public String getType() {
    return type;
  }

  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
}
