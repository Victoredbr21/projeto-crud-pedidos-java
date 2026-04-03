package com.pedidos.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record ClientRequestDTO(
    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 150)
    String name,

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    String email,

    @NotNull(message = "Data de nascimento é obrigatória")
    @Past(message = "Data de nascimento deve ser no passado")
    LocalDate birthDate
) {}
