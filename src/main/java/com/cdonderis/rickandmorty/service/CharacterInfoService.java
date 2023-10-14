package com.cdonderis.rickandmorty.service;

import com.cdonderis.rickandmorty.model.CharacterInfo;
import com.cdonderis.rickandmorty.model.dto.CharacterDTO;

import java.util.List;

public interface CharacterInfoService {

    /**
     * Method to return a list of characters
     * @param characterName
     * @return List of characters
     */
    List<CharacterDTO> findCharactersByName(String characterName);


}
