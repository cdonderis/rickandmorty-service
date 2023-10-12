package com.cdonderis.rickandmorty.service;

import com.cdonderis.rickandmorty.model.CharacterInfo;

import java.util.List;

public interface CharacterInfoService {

    /**
     * Method to return a list of characters
     * @param characterName
     * @return List of characters
     */
    List<CharacterInfo> findByName(String characterName);


}
