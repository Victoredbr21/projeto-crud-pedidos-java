package com.pedidos.service;

import com.pedidos.dto.*;
import com.pedidos.entity.Product;
import com.pedidos.exception.*;
import com.pedidos.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductResponseDTO> findAll() {
        return productRepository.findAll().stream()
            .map(ProductResponseDTO::from)
            .toList();
    }

    @Transactional(readOnly = true)
    public ProductResponseDTO findById(Long id) {
        return productRepository.findById(id)
            .map(ProductResponseDTO::from)
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + id));
    }

    @Transactional
    public ProductResponseDTO create(ProductRequestDTO dto) {
        Product product = Product.builder()
            .name(dto.name())
            .price(dto.price())
            .build();
        return ProductResponseDTO.from(productRepository.save(product));
    }

    @Transactional
    public ProductResponseDTO update(Long id, ProductRequestDTO dto) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + id));
        product.setName(dto.name());
        product.setPrice(dto.price());
        return ProductResponseDTO.from(productRepository.save(product));
    }

    @Transactional
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado com id: " + id);
        }
        productRepository.deleteById(id);
    }
}
