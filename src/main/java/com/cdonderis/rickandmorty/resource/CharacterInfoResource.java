package com.cdonderis.rickandmorty.resource;


import com.cdonderis.rickandmorty.model.CharacterInfo;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/character")
public class CharacterInfoResource {

    private final Logger log = LoggerFactory.getLogger(CharacterInfoResource.class);

    /**
     * Endpoint to verify status connection.
     *
     * @return
     */
    @GetMapping("/test")
    public ResponseEntity<String> connectionTest() {
        log.info("Rest connection enabled");
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity< List<CharacterInfo> > findByName(@PathVariable(value = "name") String name){
        return null;
    }
}
