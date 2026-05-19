package com.example.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pet.dto.PetAdoptionResponse;
import com.example.pet.entity.Pet;
import com.example.pet.service.PetServiceInterface;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/pet")
@Tag(name = "Pets", description = "API for managing pets")
public class PetController {

    @Autowired
    private PetServiceInterface petService;

    @GetMapping("/{petID}")
    @Operation(summary = "Get pet by ID", description = "Retrieves a pet by its ID")
    public ResponseEntity<Pet> getPetById(@PathVariable("petID") Long petID) {
        return petService.findById(petID)
            .map(pet -> ResponseEntity.ok(pet))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    @Operation(summary = "Create pet", description = "Creates a new pet record")
    public ResponseEntity<PetAdoptionResponse> savePet(@RequestBody Pet pet) {
        PetAdoptionResponse savedPet = petService.save(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPet);
    }


}
