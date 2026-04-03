package com.pedidos.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ProductRequestDTO(
    @NotBlank(message = "Nome do produto é obrigatório")
    @Size(max = 200)
    String name,

    @NotNull(message = "Preço é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "Preço deve ser maior que zero")
    BigDecimal price
) {}
