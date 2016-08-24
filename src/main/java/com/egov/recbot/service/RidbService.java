package com.egov.recbot.service;

import com.egov.recbot.json.response.RidbResponse;

public interface RidbService {

  RidbResponse getRecommendations(String city, String activities);

}
