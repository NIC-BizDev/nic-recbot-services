package com.egov.recbot.service.impl;

import com.egov.recbot.json.request.FbWebhookRequest;
import com.egov.recbot.service.FbWebhookService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class FbWebhookServiceImpl implements FbWebhookService {

  private Logger logger = Logger.getLogger(this.getClass());



  @Override
  public void processWebhookRequest(FbWebhookRequest request) {
    this.logger.warn(request);

    // TODO:  Foreward request to API.AI

    // TODO:  Post response to Facebook

  }

  private Boolean canActionBeHandled(String action) {
    return ("RecAreaSearch".equals(action));
  }

}
