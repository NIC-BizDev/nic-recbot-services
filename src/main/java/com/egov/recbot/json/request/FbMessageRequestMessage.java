package com.egov.recbot.json.request;

import com.egov.recbot.json.JsonBase;

public class FbMessageRequestMessage extends JsonBase {

  private String text;
  private FbMessageRequestMessageAttachment_GenericTemplate attachment;
  private String metadata;


  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }

  public FbMessageRequestMessageAttachment_GenericTemplate getAttachment() {
    return attachment;
  }
  public void setAttachment(FbMessageRequestMessageAttachment_GenericTemplate attachment) {
    this.attachment = attachment;
  }

  public String getMetadata() {
    return metadata;
  }
  public void setMetadata(String metadata) {
    this.metadata = metadata;
  }

}
