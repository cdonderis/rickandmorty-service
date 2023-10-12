package com.cdonderis.rickandmorty.model;

import java.util.List;

public class CharacterInfo {

    private String name;

    private List<Episode> episodes;

    private String firstApppearance;

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

    public String getFirstApppearance() {
        return firstApppearance;
    }

    public void setFirstApppearance(String firstApppearance) {
        this.firstApppearance = firstApppearance;
    }
}