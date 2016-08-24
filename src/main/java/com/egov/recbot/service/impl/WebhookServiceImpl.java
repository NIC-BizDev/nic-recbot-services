package com.egov.recbot.service.impl;

import com.egov.recbot.json.request.WebhookRequest;
import com.egov.recbot.json.response.RidbResponse;
import com.egov.recbot.json.response.RidbResponseRecdata;
import com.egov.recbot.json.response.WebhookResponse;
import com.egov.recbot.json.response.WebhookResponseContext;
import com.egov.recbot.service.RidbService;
import com.egov.recbot.service.WebhookService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebhookServiceImpl implements WebhookService {

  private Logger logger = Logger.getLogger(this.getClass());

  @Autowired
  private RidbService ridbService;

  @Override
  public WebhookResponse processWebhookRequest(WebhookRequest request) {
    WebhookResponse response = new WebhookResponse();
    String speech = new String();
    String action = request.getResult().getAction();

    if (this.canActionBeHandled(action)) {
      String location = request.getResult().getParameters().get("Location");
      String activities = request.getResult().getParameters().get("Activities");
      RidbResponse ridbResponse = this.ridbService.getRecommendations(location);

      if (!(ridbResponse.getRecdata() == null || ridbResponse.getRecdata().isEmpty())) {
        String recLocations = ridbResponse.getRecdata().stream()
          .map(RidbResponseRecdata::getName)
          .collect(Collectors.joining(", "));

        speech = String.format("Here is a list of hiking locations in %s: %s.", location, recLocations);
        response.setSpeech(speech);
        response.setDisplayText(speech);
      } else {
        speech = String.format("Sorry, I was unable to find any locations in %s.", location);
        response.setSpeech(speech);
        response.setDisplayText(speech);
      }
    } else {
      speech = String.format("Sorry, I was unable to understand your request.");
      response.setSpeech(speech);
      response.setDisplayText(speech);
    }

    response.setSource("nic-recbot-service");
    return response;
  }

  private Boolean canActionBeHandled(String action) {
    return ("RecAreaSearch".equals(action));
  }

}
