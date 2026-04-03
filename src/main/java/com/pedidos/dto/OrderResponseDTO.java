package com.pedidos.dto;

import com.pedidos.entity.Order;
import com.pedidos.enums.OrderStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderResponseDTO(
    Long id,
    LocalDateTime moment,
    OrderStatus status,
    ClientResponseDTO client,
    List<OrderItemResponseDTO> items,
    BigDecimal total,
    LocalDateTime updatedAt
) {
    public static OrderResponseDTO from(Order o) {
        return new OrderResponseDTO(
            o.getId(),
            o.getMoment(),
            o.getStatus(),
            ClientResponseDTO.from(o.getClient()),
            o.getItems().stream().map(OrderItemResponseDTO::from).toList(),
            o.getTotal(),
            o.getUpdatedAt()
        );
    }
}
