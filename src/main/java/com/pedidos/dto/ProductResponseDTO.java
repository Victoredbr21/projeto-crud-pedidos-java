package com.pedidos.dto;

import com.pedidos.entity.Product;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductResponseDTO(
    Long id,
    String name,
    BigDecimal price,
    LocalDateTime createdAt
) {
    public static ProductResponseDTO from(Product p) {
        return new ProductResponseDTO(p.getId(), p.getName(), p.getPrice(), p.getCreatedAt());
    }
}
