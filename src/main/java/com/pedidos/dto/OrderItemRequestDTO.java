package com.pedidos.dto;

import jakarta.validation.constraints.*;

public record OrderItemRequestDTO(
    @NotNull(message = "ID do produto é obrigatório")
    Long productId,

    @NotNull(message = "Quantidade é obrigatória")
    @Min(value = 1, message = "Quantidade mínima é 1")
    Integer quantity
) {}
