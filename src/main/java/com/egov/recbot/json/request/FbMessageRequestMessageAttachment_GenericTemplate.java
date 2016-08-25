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

  private String type = "template";
  private String getType() {return this.type;}

  private FbGenericTemplate payload;

  public FbGenericTemplate getPayload() {
    return this.payload;
  }
  public void setPayload(FbGenericTemplate payload) {
    this.payload = payload;
  }
}
