package com.cdonderis.rickandmorty.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entity to obtain main Episode information
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Episode {
    private String name;

    @JsonProperty("air_date")
    private String airDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public Episode() {
    }

    public Episode(String name, String airDate) {
        this.name = name;
        this.airDate = airDate;
    }
}
