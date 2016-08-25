package com.egov.recbot.json.request;

import com.egov.recbot.json.JsonBase;
import java.util.List;


public class FbGenericTemplate extends JsonBase {

  private String template_type;
  private List<FbGenericTemplateElement> elements;

  public FbGenericTemplate()
  {
    this.setTemplate_type("generic");
  }


  public List<FbGenericTemplateElement> getElements() {
    return elements;
  }
  public void setElements(List<FbGenericTemplateElement> elements) {
    this.elements = elements;
  }

  public String getTemplate_type() {
    return template_type;
  }
  public void setTemplate_type(String template_type) {
    this.template_type = template_type;
  }
}
