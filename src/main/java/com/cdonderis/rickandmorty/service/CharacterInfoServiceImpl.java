package com.cdonderis.rickandmorty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CharacterInfoServiceImpl {

    @Autowired
    RestTemplate restTemplate;

    //Constructor to init Rest Template
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }


}
