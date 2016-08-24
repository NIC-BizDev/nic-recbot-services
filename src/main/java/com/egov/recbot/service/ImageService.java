package com.egov.recbot.service;

import com.egov.recbot.json.response.ImageServiceResponse;

/**
 * Created by tosha on 8/24/16.
 */
public interface ImageService {

     ImageServiceResponse getImageFromPOI(String pointOfIntrest);
     ImageServiceResponse getImageFromLocation(Double latitude, Double longitude);

}
