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
        String params = "term="+pointOfIntrest+"&image_size=1&sort=undefined&only=Landscapes&_method=get&sdk_key=&rpp=1";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.endpoint)
                .query(params);
        URI uri = builder.build().toUri();
        return restTemplate.exchange(uri, HttpMethod.GET, httpEntity, ImageServiceResponse.class).getBody();
    }

    /*



RESTClient

    File
    Authentication
    Headers
    View

    Favorite Requests
    Setting

[-] Request
Method URL
Body
[-] Response

    Response Headers
    Response Body (Raw)
    Response Body (Highlight)
    Response Body (Preview)

    {
        "current_page": 1,
        "total_pages": 51,
        "total_items": 51,
        "photos":
        [
            {
                "id": 82692919,
                "user_id": 466815,
                "name": "Morning Row",
                "description": "Shot this on the Austin Boardwalk at Lady Bird Lake.  I had my Tokina 16-28 on and decided to turn around and shoot to the sun as it was amazing.  I couldn't get any detail so I swapped to the Tamron 70-200 2.8 and started snapping.  A few seconds later this rower comes out of the clearing and crosses the lake.

    Fate was on my side, this added the perfect element to the shot.

    Minor adjustments in Lightroom 5 and Photoshop CC 2014.",
                "camera": "NIKON D610",
                "lens": "Tamron 70-200 f 2.8",
                "focal_length": "200",
                "iso": "200",
                "shutter_speed": "1/640",
                "aperture": "9",
                "times_viewed": 3397,
                "rating": 48.3,
                "status": 1,
                "created_at": "2014-09-09T09:50:28-04:00",
                "category": 8,
                "location": null,
                "latitude": 30.2459292912158,
                "longitude": -97.7231483417563,
                "taken_at": "2014-09-05T19:20:08-04:00",
                "hi_res_uploaded": 2,
                "for_sale": true,
                "width": 7216,
                "height": 3704,
                "votes_count": 82,
                "favorites_count": 28,
                "comments_count": 9,
                "nsfw": false,
                "sales_count": 0,
                "for_sale_date": null,
                "highest_rating": 95.7,
                "highest_rating_date": "2014-09-10T08:51:00-04:00",
                "license_type": 0,
                "converted": 27,
                "collections_count": 1,
                "crop_version": 6,
                "privacy": false,
                "profile": true,
                "image_url": "https://drscdn.500px.org/photo/82692919/w%3D70_h%3D70/536c63206bb2a8daacf42ca4faaa35c3?v=6",
                "images":
                [
                    {
                        "size": 1,
                        "url": "https://drscdn.500px.org/photo/82692919/w%3D70_h%3D70/536c63206bb2a8daacf42ca4faaa35c3?v=6",
                        "https_url": "https://drscdn.500px.org/photo/82692919/w%3D70_h%3D70/536c63206bb2a8daacf42ca4faaa35c3?v=6",
                        "format": "jpeg"
                    }
                ],
                "url": "/photo/82692919/morning-row-by-cody-ash",
                "positive_votes_count": 82,
                "converted_bits": 27,
                "watermark": false,
                "image_format": "jpeg",
                "licensing_requested": false,
                "licensing_suggested": false,
                "is_free_photo": false,
                "user":
                {
                    "id": 466815,
                    "username": "Cody_ash",
                    "firstname": "Cody",
                    "lastname": "Ash",
                    "city": "Pflugerville",
                    "country": "United States",
                    "usertype": 0,
                    "fullname": "Cody Ash",
                    "userpic_url": "https://pacdn.500px.org/466815/3e38cf5f5fdfbf98cbb20ec3145ea42b25715109/1.jpg?37",
                    "userpic_https_url": "https://pacdn.500px.org/466815/3e38cf5f5fdfbf98cbb20ec3145ea42b25715109/1.jpg?37",
                    "cover_url": "https://pacdn.500px.org/466815/3e38cf5f5fdfbf98cbb20ec3145ea42b25715109/cover_2048.jpg?22",
                    "upgrade_status": 0,
                    "store_on": true,
                    "affection": 1988,
                    "avatars":
                    {
                        "default":
                        {
                            "https": "https://pacdn.500px.org/466815/3e38cf5f5fdfbf98cbb20ec3145ea42b25715109/1.jpg?37"
                        },
                        "large":
                        {
                            "https": "https://pacdn.500px.org/466815/3e38cf5f5fdfbf98cbb20ec3145ea42b25715109/2.jpg?37"
                        },
                        "small":
                        {
                            "https": "https://pacdn.500px.org/466815/3e38cf5f5fdfbf98cbb20ec3145ea42b25715109/3.jpg?37"
                        },
                        "tiny":
                        {
                            "https": "https://pacdn.500px.org/466815/3e38cf5f5fdfbf98cbb20ec3145ea42b25715109/4.jpg?37"
                        }
                    },
                    "followers_count": 60
                }
            }
        ]
    }




Home | Github | Issues | Donate

Back to top




     */

    @Override
    public ImageServiceResponse getImageFromLocation(Double latitude, Double longitude) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> httpEntity = this.generateHttpEntityForApiRequests(null);
        String params = "geo="+latitude.toString()+","+longitude.toString()+",km&image_size=3&sort=undefined&only=Landscapes&_method=get&sdk_key=&rpp=1";
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
