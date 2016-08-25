package com.egov.recbot.json.request;

import com.egov.recbot.json.JsonBase;

/*
public enum attachmentType
{
  image,
  audio,
  video,
  file,
  template
}
*/

public class FbMessageRequestMessageAttachment_GenericTemplate extends JsonBase {

  public FbMessageRequestMessageAttachment_GenericTemplate()
  {
    this.setType("template");
  }

  private String type;
  private FbGenericTemplate payload;

  public FbGenericTemplate getPayload() {
    return this.payload;
  }
  public void setPayload(FbGenericTemplate payload) {
    this.payload = payload;
  }

  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
}
