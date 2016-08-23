package com.egov.recbot.service.impl;

import com.egov.recbot.json.request.WebhookRequest;
import com.egov.recbot.json.response.WebhookResponse;
import com.egov.recbot.json.response.WebhookResponseContext;
import com.egov.recbot.service.WebhookService;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebhookServiceImpl implements WebhookService {

  private Logger logger = Logger.getLogger(this.getClass());

  @Override
  public WebhookResponse processWebhookRequest(WebhookRequest request) {
    WebhookResponse webhookResponse = new WebhookResponse();

    webhookResponse.setSpeech("This is the response from the webhook!");
    webhookResponse.setDisplayText("This is the display text from the webhook!");
    webhookResponse.setSource("nic-recbot-service");

    return webhookResponse;
  }

}
