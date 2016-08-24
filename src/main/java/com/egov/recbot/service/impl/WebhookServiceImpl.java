package com.egov.recbot.service.impl;

import com.egov.recbot.json.request.WebhookRequest;
import com.egov.recbot.json.request.WebhookRequestResultContext;
import com.egov.recbot.json.response.*;
import com.egov.recbot.service.ImageService;
import com.egov.recbot.service.RidbService;
import com.egov.recbot.service.WebhookService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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

  @Autowired
  private ImageService imageService;

  @Override
  public WebhookResponse processWebhookRequest(WebhookRequest request) {
    this.logger.warn(request);
    WebhookResponse response = new WebhookResponse();
    String speech = new String();
    String action = request.getResult().getAction();

    if (this.canActionBeHandled(action)) {
      WebhookRequestResultContext context = request.getResult().getContexts().stream()
        .filter(c -> "recareasearchcontext".equals(c.getName()))
        .findFirst().get();
      String location = context.getParameters().get("Location");
      String activities = context.getParameters().get("Activities");
      String activityName = context.getParameters().get("Activities.original");
      RidbResponse ridbResponse = this.ridbService.getRecommendations(location,activities);

      if (!(ridbResponse.getRecdata() == null || ridbResponse.getRecdata().isEmpty())) {
        String recLocations = ridbResponse.getRecdata().stream()
          .map(RidbResponseRecdata::getName)
          .collect(Collectors.joining(", "));

        speech = String.format(
          "I found %s %s locations in %s: %s",
          ridbResponse.getRecdata().size(),
          activityName,
          location,
          recLocations
        );

        /*JSONObject obj = new JSONObject();
        obj.put("size", ridbResponse.getRecdata().size());
        obj.put("activityName", activityName);

        JSONArray recJsonLocations = new JSONArray();

        for(int index=0 ; index< ridbResponse.getRecdata().size(); index++)
        {
          JSONObject recObj = new JSONObject();
          recObj.put("Name", ridbResponse.getRecdata().get(index).getName());
          recObj.put("Description", ridbResponse.getRecdata().get(index).getDescription());
          recObj.put("Latitude", ridbResponse.getRecdata().get(index).getLatitude().toString());
          recObj.put("Longitude", ridbResponse.getRecdata().get(index).getLongitude().toString());

          ImageServiceResponse imageServiceResponse = imageService.getImageFromPOI(ridbResponse.getRecdata().get(index).getName());
          recObj.put("Image", imageServiceResponse.getPhotosDataList().get(0).getImage_url());
          recJsonLocations.add(recObj);

        }

        obj.put("Recreation List", recJsonLocations);

        response.setData(obj);*/

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
