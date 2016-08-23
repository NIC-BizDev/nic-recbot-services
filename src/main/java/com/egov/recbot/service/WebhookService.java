package com.egov.recbot.service;

import com.egov.recbot.json.request.WebhookRequest;
import com.egov.recbot.json.response.WebhookResponse;

public interface WebhookService {

  WebhookResponse processWebhookRequest(WebhookRequest request);

}
