package com.egov.recbot.controller;

import com.egov.recbot.json.request.WebhookRequest;
import com.egov.recbot.service.WebhookService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fbwebhook")
public class FbWebhookController {

  private Logger logger = Logger.getLogger(this.getClass());

  @Autowired
  private WebhookService webhookService;

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<?> handleWebhook(@RequestBody WebhookRequest request) {
    return ResponseEntity.ok(null);
  }
}
