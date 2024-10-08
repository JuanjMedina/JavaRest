package com.example.apirestjava.service;

import com.example.apirestjava.model.dto.ClienteDto;
import com.example.apirestjava.model.entity.Cliente;
import org.springframework.http.ResponseEntity;

public interface IClientService {
    Cliente save(ClienteDto cliente);

    Cliente findById(Integer id);

    void delete(Cliente cliente);

    boolean existsById(Integer id);

}
