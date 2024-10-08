package com.example.apirestjava.model.dao;

import com.example.apirestjava.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository <Cliente, Integer>{
}
