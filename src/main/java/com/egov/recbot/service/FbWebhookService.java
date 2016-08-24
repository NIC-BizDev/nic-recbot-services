package com.egov.recbot.service;

import com.egov.recbot.json.request.FbWebhookRequest;

public interface FbWebhookService {

  void processWebhookRequest(FbWebhookRequest request);

}
