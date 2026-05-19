package com.example.pet.service;

import java.util.Optional;

import com.example.pet.dto.PetAdoptionResponse;
import com.example.pet.entity.Pet;

public interface PetServiceInterface {

    Optional<Pet> findById(Long id);

    PetAdoptionResponse save(Pet pet);

}
