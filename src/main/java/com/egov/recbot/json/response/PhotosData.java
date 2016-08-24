package com.egov.recbot.json.response;

import com.egov.recbot.json.JsonBase;
import com.fasterxml.jackson.annotation.JsonProperty;

//**** Created by tosha on 8/24/16.

public class PhotosData extends JsonBase {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("image_url")
    private String image_url;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
