package com.cdonderis.rickandmorty.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * DTO to map Response
 */
public class CharacterDTO {

    public CharacterDTO(String name, List<String> episodes, Date firstApppearance) {
        this.name = name;
        this.episodes = episodes;
        this.firstApppearance = firstApppearance;
    }

    private String name;
    private List<String> episodes;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date firstApppearance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<String> episodes) {
        this.episodes = episodes;
    }

    public Date getFirstApppearance() {
        return firstApppearance;
    }

    public void setFirstApppearance(Date firstApppearance) {
        this.firstApppearance = firstApppearance;
    }
}
