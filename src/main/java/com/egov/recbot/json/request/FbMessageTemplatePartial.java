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

public class FbMessageTemplatePartial extends JsonBase {

private FbMessageRequestMessageAttachment_GenericTemplate attachment;

  public FbMessageRequestMessageAttachment_GenericTemplate getAttachment() {
    return attachment;
  }
  public void setAttachment(FbMessageRequestMessageAttachment_GenericTemplate attachment) {
    this.attachment = attachment;
  }
}
