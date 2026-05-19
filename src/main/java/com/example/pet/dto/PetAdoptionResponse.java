package com.example.pet.dto;

import java.util.Date;

public record PetAdoptionResponse(
    String transactionId,
    Date createdAt,
    String nombre,
    String status
) {}
