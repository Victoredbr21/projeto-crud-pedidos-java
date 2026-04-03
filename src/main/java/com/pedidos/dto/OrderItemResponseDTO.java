package com.pedidos.dto;

import com.pedidos.entity.OrderItem;
import java.math.BigDecimal;

public record OrderItemResponseDTO(
    Long id,
    Long productId,
    String productName,
    Integer quantity,
    BigDecimal price,
    BigDecimal subTotal
) {
    public static OrderItemResponseDTO from(OrderItem oi) {
        return new OrderItemResponseDTO(
            oi.getId(),
            oi.getProduct().getId(),
            oi.getProduct().getName(),
            oi.getQuantity(),
            oi.getPrice(),
            oi.getSubTotal()
        );
    }
}
