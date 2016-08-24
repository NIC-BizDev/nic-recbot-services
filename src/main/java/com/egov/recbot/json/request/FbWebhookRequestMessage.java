package com.egov.recbot.json.request;

import com.egov.recbot.json.JsonBase;

import java.util.Map;

public class FbWebhookRequestMessage extends JsonBase {

  private String mid;
  private Integer seq;
  private String text;
  private Integer lifespan;

  public void setMid(String mid) {this.mid = mid;}
  public String getMid() {
    return this.mid;
  }


  public void setSeq(Integer seq){ this.seq = seq;}
  public Integer getSeq(){ return this.seq;}

  public void setText(String text) {this.text = text;}
  public String getText() {
    return this.text;
  }

  /*
  ----- Not Mapped -----
  attachment    attachment[]
  quick_reply   quick_reply

   */

}
