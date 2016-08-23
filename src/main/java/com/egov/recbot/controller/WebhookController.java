package com.egov.recbot.controller;

import com.egov.recbot.json.request.WebhookRequest;
import com.egov.recbot.json.response.WebhookResponse;

import org.apache.log4j.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

  private Logger logger = Logger.getLogger(this.getClass());

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<?> handleWebhook(@RequestBody WebhookRequest request) {
    return ResponseEntity.ok(new WebhookResponse());
  }
}
