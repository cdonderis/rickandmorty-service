package com.cdonderis.rickandmorty.resource;


import com.cdonderis.rickandmorty.model.CharacterInfo;
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


@RestController
@RequestMapping("/character")
public class CharacterInfoResource {

    @Autowired
    CharacterInfoService characterInfoService;

    private final Logger log = LoggerFactory.getLogger(CharacterInfoResource.class);


    @GetMapping("/findByName/{name}")
    public ResponseEntity< List<CharacterInfo> > findByName(@PathVariable(value = "name") String name){
        List<CharacterInfo> characters = characterInfoService.findCharactersById(name);

        if (characters == null || characters.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(characters);
    }
}
