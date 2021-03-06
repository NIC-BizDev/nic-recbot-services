package com.egov.recbot.json.response;

import com.egov.recbot.json.JsonBase;
import org.json.simple.JSONObject;
import java.util.List;
import java.util.Map;

public class WebhookResponse extends JsonBase {

  private String speech;
  private String displayText;
  private Map data;
  private List<WebhookResponseContext> contextOut;
  private String source;

  public String getSpeech() {
    return this.speech;
  }

  public void setSpeech(String speech) {
    this.speech = speech;
  }

  public String getDisplayText() {
    return this.displayText;
  }

  public void setDisplayText(String displayText) {
    this.displayText = displayText;
  }

  public Map getData() {
    return this.data;
  }

  public void setData(Map data) {
    this.data = data;
  }

  public List<WebhookResponseContext> getContextOut() {
    return this.contextOut;
  }

  public void setContextOut(List<WebhookResponseContext> contextOut) {
    this.contextOut = contextOut;
  }

  public String getSource() {
    return this.source;
  }

  public void setSource(String source) {
    this.source = source;
  }

}
