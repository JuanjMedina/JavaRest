package com.example.apirestjava.service.impl;

import com.example.apirestjava.model.dao.ClienteDao;
import com.example.apirestjava.model.dto.ClienteDto;
import com.example.apirestjava.model.entity.Cliente;
import com.example.apirestjava.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteImpl implements IClientService {

    @Autowired
    private ClienteDao clienteDao;

    @Transactional
    @Override
    public Cliente save(ClienteDto clienteDto) {
        Cliente cliente = Cliente.builder()
                .idCliente(clienteDto.getIdCliente())
                .apellido(clienteDto.getApellido())
                .nombre(clienteDto.getNombre())
                .fechaRegistro(clienteDto.getFechaRegistro())
                .correo(clienteDto.getCorreo())
                .build();
        return clienteDao.save(cliente);
    }

    @Override
    public Cliente findById(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    public boolean existsById(Integer id) {
        return clienteDao.existsById(id);
    }
}
