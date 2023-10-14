package com.cdonderis.rickandmorty.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterInfo {

    private String name;


    @JsonProperty("episode")
    private List<String> episodePath;

    private List<Episode> episodes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public List<String> getEpisodePath() { return episodePath; }

    public void setEpisodePath(List<String> episodePath) { this.episodePath = episodePath; }

}
