package com.egov.recbot.json.response;

import com.egov.recbot.json.JsonBase;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RidbResponseRecdata extends JsonBase {

  @JsonProperty("RecAreaID")
  private Long id;

  @JsonProperty("RecAreaName")
  private String name;

  @JsonProperty("RecAreaDescription")
  private String description;

  @JsonProperty("RecAreaLatitude")
  private Double latitude;

  @JsonProperty("RecAreaLongitude")
  private Double longitude;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getLatitude() {
    return this.latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return this.longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

}
