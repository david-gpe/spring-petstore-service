package com.example.pet.service;

import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pet.client.PetStoreClient;
import com.example.pet.dto.PetAdoptionResponse;
import com.example.pet.dto.PetStorePet;
import com.example.pet.dto.PetStorePet.Category;
import com.example.pet.dto.PetStorePet.Tag;
import com.example.pet.entity.Pet;

@Service
public class PetServiceImpl implements PetServiceInterface {

    @Autowired
    private PetStoreClient petStoreClient;

    @Override
    public Optional<Pet> findById(Long id) {
        PetStorePet externalPet = petStoreClient.getPetById(id);
        if (externalPet == null) {
            return Optional.empty();
        }

        Pet pet = new Pet();
        pet.setId(externalPet.getId());
        pet.setNombre(externalPet.getName());
        pet.setStatus(externalPet.getStatus());
        return Optional.of(pet);
    }

    @Override
    public PetAdoptionResponse save(Pet pet) {
        
        PetStorePet savedExternalPet = petStoreClient.savePet(PetStorePet.builder()
            .id(pet.getId())
            .category(
                Category.builder()
                .id(pet.getId())
                .name(pet.getNombre()).build())
            .name(pet.getNombre())
            .photoUrls(java.util.List.of(pet.getNombre()))
            .tags(java.util.List.of(Tag.builder()
                .id(pet.getId())
                .name(pet.getNombre()).build()))
            .status(pet.getStatus())
            .build());

        return new PetAdoptionResponse(
            UUID.randomUUID().toString(),
            new Date(System.currentTimeMillis()),
            savedExternalPet.getName(),
            savedExternalPet.getStatus()
        );
    }

}
