package com.pedidos.service;

import com.pedidos.dto.*;
import com.pedidos.entity.Client;
import com.pedidos.exception.*;
import com.pedidos.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<ClientResponseDTO> findAll() {
        return clientRepository.findAll().stream()
            .map(ClientResponseDTO::from)
            .toList();
    }

    @Transactional(readOnly = true)
    public ClientResponseDTO findById(Long id) {
        return clientRepository.findById(id)
            .map(ClientResponseDTO::from)
            .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + id));
    }

    @Transactional
    public ClientResponseDTO create(ClientRequestDTO dto) {
        if (clientRepository.existsByEmail(dto.email())) {
            throw new BusinessException("Email já cadastrado: " + dto.email());
        }
        Client client = Client.builder()
            .name(dto.name())
            .email(dto.email())
            .birthDate(dto.birthDate())
            .build();
        return ClientResponseDTO.from(clientRepository.save(client));
    }

    @Transactional
    public ClientResponseDTO update(Long id, ClientRequestDTO dto) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + id));

        if (!client.getEmail().equals(dto.email()) && clientRepository.existsByEmail(dto.email())) {
            throw new BusinessException("Email já em uso: " + dto.email());
        }
        client.setName(dto.name());
        client.setEmail(dto.email());
        client.setBirthDate(dto.birthDate());
        return ClientResponseDTO.from(clientRepository.save(client));
    }

    @Transactional
    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente não encontrado com id: " + id);
        }
        clientRepository.deleteById(id);
    }
}
