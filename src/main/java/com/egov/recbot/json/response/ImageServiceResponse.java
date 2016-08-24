package com.egov.recbot.json.response;

import com.egov.recbot.json.JsonBase;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by tosha on 8/24/16.
 */
public class ImageServiceResponse extends JsonBase {

    @JsonProperty("photos")
    private List<PhotosData> photosDataList;

    public List<PhotosData> getPhotosDataList() {
        return photosDataList;
    }

    public void setPhotosDataList(List<PhotosData> photosDataList) {
        this.photosDataList = photosDataList;
    }
}
