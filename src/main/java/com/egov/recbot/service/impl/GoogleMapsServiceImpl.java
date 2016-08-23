package com.egov.recbot.service.impl;

import com.egov.recbot.json.response.GoogleMapsResponse;
import com.egov.recbot.service.GoogleMapsService;

import java.net.URI;

import org.apache.log4j.Logger;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GoogleMapsServiceImpl implements GoogleMapsService {

  private Logger logger = Logger.getLogger(this.getClass());

  private String googleMapsApiUrl = "https://maps.googleapis.com/maps/api/geocode/json";

  @Override
  public GoogleMapsResponse getCoordinates(String city) {
    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<?> httpEntity = this.generateHttpEntityForApiRequests(null);
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(googleMapsApiUrl)
      .queryParam("address", city);
    URI uri = builder.build().toUri();
    return restTemplate.exchange(uri, HttpMethod.GET, httpEntity, GoogleMapsResponse.class).getBody();
  }

  private HttpEntity<Object> generateHttpEntityForApiRequests(Object obj) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.set("Accept", MediaType.ALL_VALUE);
    httpHeaders.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
    return new HttpEntity<Object>(obj, httpHeaders);
  }

}
