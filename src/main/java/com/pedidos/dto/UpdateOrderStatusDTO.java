package com.pedidos.dto;

import com.pedidos.enums.OrderStatus;
import jakarta.validation.constraints.NotNull;

public record UpdateOrderStatusDTO(
    @NotNull(message = "Status é obrigatório")
    OrderStatus status
) {}
