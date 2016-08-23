package com.egov.recbot.json.request;

import com.egov.recbot.json.JsonBase;

import java.util.List;
import java.util.Map;

public class WebhookRequestResult extends JsonBase {

  private String source;
  private String resolvedQuery;
  private String action;
  private Boolean actionIncomplete;
  private Map<String, String> parameters;
  private List<WebhookRequestResultContext> contexts;
  private WebhookRequestResultMetadata metadata;
  private WebhookRequestResultFulfillment fulfillment;

  public String getSource() {
    return this.source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getResolvedQuery() {
    return this.resolvedQuery;
  }

  public void setResolvedQuery(String resolvedQuery) {
    this.resolvedQuery = resolvedQuery;
  }

  public String getAction() {
    return this.action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public Boolean getActionIncomplete() {
    return this.actionIncomplete;
  }

  public void setActionIncomplete(Boolean actionIncomplete) {
    this.actionIncomplete = actionIncomplete;
  }

  public Map<String, String> getParameters() {
    return this.parameters;
  }

  public void setParameters(Map<String, String> parameters) {
    this.parameters = parameters;
  }

  public List<WebhookRequestResultContext> getContexts() {
    return this.contexts;
  }

  public void setContexts(List<WebhookRequestResultContext> contexts) {
    this.contexts = contexts;
  }

  public WebhookRequestResultMetadata getMetadata() {
    return this.metadata;
  }

  public void setMetadata(WebhookRequestResultMetadata metadata) {
    this.metadata = metadata;
  }

  public WebhookRequestResultFulfillment getFulfillment() {
    return this.fulfillment;
  }

  public void setFulfillment(WebhookRequestResultFulfillment fulfillment) {
    this.fulfillment = fulfillment;
  }

}
