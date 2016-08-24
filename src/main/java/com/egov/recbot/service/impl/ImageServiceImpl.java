package com.egov.recbot.service.impl;

import com.egov.recbot.json.response.GoogleMapsResponse;
import com.egov.recbot.json.response.ImageServiceResponse;
import com.egov.recbot.service.ImageService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.activation.DataSource;
import java.net.URI;
import java.util.logging.Logger;

/**
 * Created by tosha on 8/24/16.
 */

@Service
public class ImageServiceImpl  implements ImageService {


    private static String endpoint = "https://api.500px.com/v1/photos/search.json";
    private String sdkKey = "14a189d76dde321cdf2b939c124062709ff1dbd2";
    private String consumerSecret = "gQw5nE80zcSRbqu1KABhTs3uA2nstG8QvkM8r5zS";

    //?

    @Override
    public ImageServiceResponse getImageFromPOI(String pointOfIntrest) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> httpEntity = this.generateHttpEntityForApiRequests(null);
        String params = "term="+pointOfIntrest+"&image_size=1&sort=undefined&only=Landscapes&_method=get&sdk_key=14a189d76dde321cdf2b939c124062709ff1dbd2&rpp=1";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.endpoint)
                .query(params);
        URI uri = builder.build().toUri();
        return restTemplate.exchange(uri, HttpMethod.GET, httpEntity, ImageServiceResponse.class).getBody();
    }

    @Override
    public ImageServiceResponse getImageFromLocation(Double latitude, Double longitude) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> httpEntity = this.generateHttpEntityForApiRequests(null);
        String params = "geo="+latitude.toString()+","+longitude.toString()+",km&image_size=3&sort=undefined&only=Landscapes&_method=get&sdk_key=14a189d76dde321cdf2b939c124062709ff1dbd2&rpp=1";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.endpoint)
                .query(params);
        URI uri = builder.build().toUri();
        return restTemplate.exchange(uri, HttpMethod.GET, httpEntity, ImageServiceResponse.class).getBody();
    }

    private HttpEntity<Object> generateHttpEntityForApiRequests(Object obj) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", MediaType.ALL_VALUE);
        httpHeaders.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<Object>(obj, httpHeaders);
    }
}
