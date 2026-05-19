package com.example.pet.dto;

import lombok.Builder;

@Builder
public record PetRequest(
    Long id,
    String nombre,
    String status
) {}
