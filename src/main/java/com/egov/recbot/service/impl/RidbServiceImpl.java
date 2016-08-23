package com.egov.recbot.service.impl;

import com.egov.recbot.json.response.GoogleMapsResponse;
import com.egov.recbot.service.GoogleMapsService;
import com.egov.recbot.service.RidbService;

import java.net.URI;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RidbServiceImpl implements RidbService {

  private Logger logger = Logger.getLogger(this.getClass());

  private String ridbApiUrl = "";

  @Autowired
  private GoogleMapsService googleMapsService;

  /*@Override
  public RidbResponse getRecommendations(String city) {
    GoogleMapsResponse googleMapsResponse = this.googleMapsService.getCoordinates("Nashville");
    this.logger.warn(googleMapsResponse);
  }*/

  private HttpEntity<Object> generateHttpEntityForApiRequests(Object obj) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.set("Accept", MediaType.ALL_VALUE);
    httpHeaders.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
    return new HttpEntity<Object>(obj, httpHeaders);
  }

}
