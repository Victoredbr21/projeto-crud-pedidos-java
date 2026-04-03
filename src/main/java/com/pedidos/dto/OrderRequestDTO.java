package com.pedidos.dto;

import com.pedidos.enums.OrderStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;

public record OrderRequestDTO(
    @NotNull(message = "ID do cliente é obrigatório")
    Long clientId,

    @NotNull(message = "Status é obrigatório")
    OrderStatus status,

    @NotNull @NotEmpty(message = "Pedido deve ter ao menos um item")
    @Valid
    List<OrderItemRequestDTO> items
) {}
