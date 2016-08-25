package com.egov.recbot.json.request;

import com.egov.recbot.json.JsonBase;
import java.util.List;


public class FbGenericTemplate extends JsonBase {

  private String template_type = "generic";
  private String getTemplate_Type() {return this.template_type;}

  private List<FbGenericTemplateElement> elements;


  public List<FbGenericTemplateElement> getElements() {
    return elements;
  }
  public void setElements(List<FbGenericTemplateElement> elements) {
    this.elements = elements;
  }
}
