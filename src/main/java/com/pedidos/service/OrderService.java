package com.pedidos.service;

import com.pedidos.dto.*;
import com.pedidos.entity.*;
import com.pedidos.enums.OrderStatus;
import com.pedidos.exception.*;
import com.pedidos.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderResponseDTO> findAll() {
        return orderRepository.findAllWithDetails().stream()
            .map(OrderResponseDTO::from)
            .toList();
    }

    @Transactional(readOnly = true)
    public OrderResponseDTO findById(Long id) {
        return orderRepository.findByIdWithDetails(id)
            .map(OrderResponseDTO::from)
            .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado com id: " + id));
    }

    @Transactional(readOnly = true)
    public List<OrderResponseDTO> findByClient(Long clientId) {
        if (!clientRepository.existsById(clientId)) {
            throw new ResourceNotFoundException("Cliente não encontrado com id: " + clientId);
        }
        return orderRepository.findByClientId(clientId).stream()
            .map(OrderResponseDTO::from)
            .toList();
    }

    @Transactional(readOnly = true)
    public List<OrderResponseDTO> findByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status).stream()
            .map(OrderResponseDTO::from)
            .toList();
    }

    @Transactional
    public OrderResponseDTO create(OrderRequestDTO dto) {
        Client client = clientRepository.findById(dto.clientId())
            .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + dto.clientId()));

        Order order = Order.builder()
            .status(dto.status())
            .client(client)
            .build();

        for (OrderItemRequestDTO itemDto : dto.items()) {
            Product product = productRepository.findById(itemDto.productId())
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + itemDto.productId()));

            OrderItem item = OrderItem.builder()
                .product(product)
                .quantity(itemDto.quantity())
                .price(product.getPrice())
                .build();
            order.addItem(item);
        }

        return OrderResponseDTO.from(orderRepository.save(order));
    }

    @Transactional
    public OrderResponseDTO updateStatus(Long id, UpdateOrderStatusDTO dto) {
        Order order = orderRepository.findByIdWithDetails(id)
            .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado com id: " + id));

        if (order.getStatus() == OrderStatus.CANCELED) {
            throw new BusinessException("Não é possível alterar status de um pedido cancelado.");
        }
        if (order.getStatus() == OrderStatus.DELIVERED) {
            throw new BusinessException("Não é possível alterar status de um pedido já entregue.");
        }

        order.setStatus(dto.status());
        return OrderResponseDTO.from(orderRepository.save(order));
    }

    @Transactional
    public void delete(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pedido não encontrado com id: " + id);
        }
        orderRepository.deleteById(id);
    }
}
