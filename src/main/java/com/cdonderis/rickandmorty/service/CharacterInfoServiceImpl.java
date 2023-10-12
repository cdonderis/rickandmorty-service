package com.cdonderis.rickandmorty.service;

import com.cdonderis.rickandmorty.model.CharacterInfo;
import com.cdonderis.rickandmorty.utils.CharacterInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CharacterInfoServiceImpl implements CharacterInfoService {

    private final Logger log = LoggerFactory.getLogger(CharacterInfoServiceImpl.class);

    private final String BASE_URL = "https://rickandmortyapi.com/api/character";

    @Autowired
    RestTemplate restTemplate;

    //Constructor to init Rest Template
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public List<CharacterInfo> findCharactersById(String name) {
        log.info("Searching characters by name {}", name);
        try {
            if (name.isEmpty()) {
                log.info("Empty name");
                return null;
            }

            ResponseEntity<String> completeResponse = restTemplate.exchange(BASE_URL + "/?name=" + name,
                    HttpMethod.GET, null, String.class);

            List<CharacterInfo> mappedResult = CharacterInfoMapper.mapJsonToCharacterInfo(completeResponse.getBody());

            return mappedResult;


        } catch (Exception e) {
            log.error("We can't find a character named {}", name);
            return null;
        }
    }
}
