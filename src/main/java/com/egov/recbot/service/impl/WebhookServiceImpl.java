package com.egov.recbot.service.impl;

import com.egov.recbot.json.request.*;
import com.egov.recbot.json.response.*;
import com.egov.recbot.service.ImageService;
import com.egov.recbot.service.RidbService;
import com.egov.recbot.service.WebhookService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;
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

        JSONObject obj = new JSONObject();
        obj.put("size", ridbResponse.getRecdata().size());
        obj.put("activityName", activityName);

        JSONArray recJsonLocations = new JSONArray();

        FbMessageTemplatePartial fbMsg = new FbMessageTemplatePartial();
        FbMessageRequestMessageAttachment_GenericTemplate fbTemplate = new FbMessageRequestMessageAttachment_GenericTemplate();
        FbGenericTemplate fbPayload = new FbGenericTemplate();
        List<FbGenericTemplateElement> fbElements = new ArrayList<FbGenericTemplateElement>();

        for(int index=0 ; index< ridbResponse.getRecdata().size(); index++)
        {
          FbGenericTemplateElement fbElement = new FbGenericTemplateElement();
          List<FbGenericTemplateUrlButton> fbButtons = new ArrayList<FbGenericTemplateUrlButton>();

          JSONObject recObj = new JSONObject();

          String poi = ridbResponse.getRecdata().get(index).getName();
          recObj.put("Name", poi);
          fbElement.setTitle(poi);

          recObj.put("Description", ridbResponse.getRecdata().get(index).getDescription());
          fbElement.setSubtitle(ridbResponse.getRecdata().get(index).getDescription());

          recObj.put("Latitude", ridbResponse.getRecdata().get(index).getLatitude().toString());
          recObj.put("Longitude", ridbResponse.getRecdata().get(index).getLongitude().toString());

          FbGenericTemplateUrlButton fbDirectionsButton = new FbGenericTemplateUrlButton();
          fbDirectionsButton.setTitle("Get Directions");
          fbDirectionsButton.setUrl("www.google.com");
          fbButtons.add(fbDirectionsButton);



          ImageServiceResponse imageServiceResponse = imageService.getImageFromPOI(poi);
          this.logger.warn("Image service is "+imageServiceResponse.getPhotosDataList().size());
          this.logger.debug("Size is " + imageServiceResponse.getPhotosDataList().size());
          if(imageServiceResponse.getPhotosDataList().size() > 0) {
            recObj.put("Image", imageServiceResponse.getPhotosDataList().get(0).getImage_url());
            this.logger.debug("URL is " + imageServiceResponse.getPhotosDataList().get(0).getImage_url());
          }
          else
          {
            //Display default image
            recObj.put("Image", "https://drscdn.500px.org/photo/117018577/w%3D70_h%3D70/34a44931e6bc70ca1b6a3de00cd62fdc?v=1");
          }
          fbElement.setImage_url(recObj.get("Image").toString());

          recJsonLocations.add(recObj);

          if(index < 10) //FB has a 10 item limit
          {
            fbElement.setButtons(fbButtons);
            fbElements.add(fbElement);
          }

        }

        //obj.put("Recreation List", recJsonLocations);


        fbPayload.setElements(fbElements);
        fbTemplate.setPayload(fbPayload);
        fbMsg.setAttachment(fbTemplate);
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("raw",recJsonLocations);
        data.put("facebook",fbMsg);




        response.setData(data);

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
