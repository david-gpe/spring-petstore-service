package com.example.pet.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.pet.dto.PetStorePet;

@Component
public class PetStoreClient {

    private static final String BASE_URL = "https://petstore.swagger.io/v2/";
    private final RestTemplate restTemplate;

    @Autowired
    public PetStoreClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PetStorePet getPetById(Long petId) {
        try {
            return restTemplate.getForObject(BASE_URL + "pet/" + petId, PetStorePet.class);
        } catch (HttpClientErrorException.NotFound ex) {
            return null;
        }
    }

    public PetStorePet savePet(PetStorePet pet) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<PetStorePet> request = new HttpEntity<>(pet, headers);
        return restTemplate.postForObject(BASE_URL + "pet", request, PetStorePet.class);
    }
}
