package com.egov.recbot.service;

import com.egov.recbot.json.response.GoogleMapsResponse;

public interface GoogleMapsService {

  GoogleMapsResponse getCoordinates(String city);

}
