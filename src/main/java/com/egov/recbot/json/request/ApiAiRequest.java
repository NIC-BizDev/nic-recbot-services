package com.egov.recbot.json.request;

import com.egov.recbot.json.JsonBase;
import com.egov.recbot.json.common.ApiAiContext;

import java.util.List;
import java.util.Map;
import java.util.UUID;


public class ApiAiRequest extends JsonBase {

  private String query;
  private String sessionId = UUID.randomUUID().toString();
  private List<ApiAiContext> contexts;
  private String lang = "en";
  private Boolean resetContexts = false;
  private Map<String,String> metadata;

  // entities - populate entities
  // location - lat/long, may be useful to do pins?

  public String getQuery() {
    return query;
  }
  public void setQuery(String query) {
    this.query = query;
  }

  public String getSessionId() {
    return sessionId;
  }
  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public List<ApiAiContext> getContexts() {
    return contexts;
  }
  public void setContexts(List<ApiAiContext> contexts) {
    this.contexts = contexts;
  }

  public String getLang() {
    return lang;
  }
  public void setLang(String lang) {
    this.lang = lang;
  }
  public Boolean getResetContexts() {
    return resetContexts;
  }

  public void setResetContexts(Boolean resetContexts) {
    this.resetContexts = resetContexts;
  }
  public Map<String, String> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }



}
