package com.pedidos.dto;

import com.pedidos.entity.Client;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record ClientResponseDTO(
    Long id,
    String name,
    String email,
    LocalDate birthDate,
    LocalDateTime createdAt
) {
    public static ClientResponseDTO from(Client c) {
        return new ClientResponseDTO(c.getId(), c.getName(), c.getEmail(), c.getBirthDate(), c.getCreatedAt());
    }
}
