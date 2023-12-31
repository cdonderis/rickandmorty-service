package com.cdonderis.rickandmorty.utils;

import com.cdonderis.rickandmorty.model.CharacterInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class CharacterInfoMapper {

    public static List<CharacterInfo> mapJsonToCharacterInfo(String jsonResponse) {
        try {
            List<CharacterInfo> characterList = new ArrayList<>();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode mainNode = objectMapper.readTree(jsonResponse);
            JsonNode resultsNode = mainNode.get("results");

            for (JsonNode resultNode : resultsNode) {
                CharacterInfo result = objectMapper.treeToValue(resultNode, CharacterInfo.class);
                characterList.add(result);
            }

            return characterList;

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
