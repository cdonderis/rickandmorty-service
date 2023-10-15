package com.cdonderis.rickandmorty.resource;


import com.cdonderis.rickandmorty.model.CharacterInfo;
import com.cdonderis.rickandmorty.model.dto.CharacterDTO;
import com.cdonderis.rickandmorty.service.CharacterInfoService;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Resource with character end-points
 */
@RestController
@RequestMapping("/character")
public class CharacterInfoResource {

    @Autowired
    CharacterInfoService characterInfoService;

    private final Logger log = LoggerFactory.getLogger(CharacterInfoResource.class);


    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<CharacterDTO>> findByName(@PathVariable(value = "name") String name) {
        List<CharacterDTO> characters = characterInfoService.findCharactersByName(name);

        if (characters == null || characters.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(characters);
    }
}
