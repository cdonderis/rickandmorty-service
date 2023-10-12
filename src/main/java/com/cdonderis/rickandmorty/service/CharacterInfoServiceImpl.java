package com.cdonderis.rickandmorty.service;

import com.cdonderis.rickandmorty.model.CharacterInfo;
import com.cdonderis.rickandmorty.model.Episode;
import com.cdonderis.rickandmorty.utils.CharacterInfoMapper;
import com.cdonderis.rickandmorty.utils.DateFormatter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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

            if (mappedResult == null || mappedResult.isEmpty()){
                log.info("We can't find results for character named {} ", name);
                return  null;
            }

            setEpisodesInCharacter(mappedResult);

            return mappedResult;

        } catch (Exception e) {
            log.error("We can't find a character named {}", name);
            return null;
        }
    }

    /**
     * Function to set episode information in each character
     *
     * @param characters
     */
    private void setEpisodesInCharacter(List<CharacterInfo> characters) throws JsonProcessingException, ParseException {
        for (CharacterInfo character : characters) {
            List<Episode> episodeList = new ArrayList<>();
            for (String episode : character.getEpisodePath()) {
                Episode episodeInfo = getEpisodeInfo(episode);
                episodeList.add(episodeInfo);
            }
            character.setEpisodes(episodeList);
            character.setFirstApppearance(searchFirstAppareance(episodeList));
        }
    }

    /**
     * Function to get episode Information from path
     *
     * @param pathEpisode
     * @return Episode
     */
    private Episode getEpisodeInfo(String pathEpisode) throws JsonProcessingException {
        ResponseEntity<String> episodeResponse = restTemplate.exchange(pathEpisode,
                HttpMethod.GET, null, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode mainNode = objectMapper.readTree(episodeResponse.getBody());

        Episode result = objectMapper.treeToValue(mainNode, Episode.class);

        return result;
    }

    /**
     * Function to obtain first Appareance
     * @param episodeList
     * @return
     * @throws ParseException
     */
    private Date searchFirstAppareance(List<Episode> episodeList) throws ParseException {
        Date firsAppareance = DateFormatter.dateFormatString(episodeList.get(0).getAirDate());

        for(Episode episode : episodeList){
            Date episodeDate = DateFormatter.dateFormatString(episode.getAirDate());
            if (episodeDate.before(firsAppareance)){
                firsAppareance = episodeDate;
            }
        }
        return firsAppareance;
    }
}
