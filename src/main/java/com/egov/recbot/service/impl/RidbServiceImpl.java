package com.egov.recbot.service.impl;

import com.egov.recbot.json.response.GoogleMapsResponse;
import com.egov.recbot.json.response.RidbResponse;
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

  private String ridbApiUrl = "https://ridb.recreation.gov/api/v1/recareas.json";
  private String ridbApiKey = "387C6E5C74694A29BF1E696498D85945";

  @Autowired
  private GoogleMapsService googleMapsService;

  @Override
  public RidbResponse getRecommendations(String city) {
    GoogleMapsResponse googleMapsResponse = this.googleMapsService.getCoordinates(city);
    this.logger.warn(googleMapsResponse);

    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<?> httpEntity = this.generateHttpEntityForApiRequests(null);
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.ridbApiUrl)
      .queryParam("radius", "100")
      .queryParam("latitude", googleMapsResponse.getResults().get(0).getGeometry().getLocation().get("lat"))
      .queryParam("longitude", googleMapsResponse.getResults().get(0).getGeometry().getLocation().get("lng"))
      .queryParam("activity", "14");  //hardcoded for now
    URI uri = builder.build().toUri();
    return restTemplate.exchange(uri, HttpMethod.GET, httpEntity, RidbResponse.class).getBody();
  }

  private HttpEntity<Object> generateHttpEntityForApiRequests(Object obj) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.set("Accept", MediaType.ALL_VALUE);
    httpHeaders.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
    httpHeaders.set("apikey", this.ridbApiKey);
    return new HttpEntity<Object>(obj, httpHeaders);
  }

}
