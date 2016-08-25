package com.egov.recbot.json.request;

import com.egov.recbot.json.JsonBase;
import java.util.List;

public class FbGenericTemplateElement extends JsonBase {

private String title;
  private String image_url;
  private String subtitle;
  private List<FbGenericTemplateUrlButton> buttons;


  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  public String getImage_url() {
    return image_url;
  }
  public void setImage_url(String image_url) {
    this.image_url = image_url;
  }

  public String getSubtitle() {
    return subtitle;
  }
  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

  public List<FbGenericTemplateUrlButton> getButtons() {
    return buttons;
  }
  public void setButtons(List<FbGenericTemplateUrlButton> buttons) {
    this.buttons = buttons;
  }
}
