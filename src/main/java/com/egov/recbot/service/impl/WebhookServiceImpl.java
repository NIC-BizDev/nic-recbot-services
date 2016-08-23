package com.egov.recbot.service.impl;

import com.egov.recbot.json.request.WebhookRequest;
import com.egov.recbot.json.response.WebhookResponse;
import com.egov.recbot.json.response.WebhookResponseContext;
import com.egov.recbot.service.WebhookService;

import org.springframework.stereotype.Service;

@Service
public class WebhookServiceImpl implements WebhookService {

  @Override
  public WebhookResponse processWebhookRequest(WebhookRequest request) {
    WebhookResponse webhookResponse = new WebhookResponse();

    webhookResponse.setSpeech("This is the response from the webhook!");
    webhookResponse.setDisplayText("This is the display text from the webhook!");
    webhookResponse.setSource("nic-recbot-service");

    return webhookResponse;
  }

}
