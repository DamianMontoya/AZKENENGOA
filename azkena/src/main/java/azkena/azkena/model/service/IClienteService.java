package azkena.azkena.model.service;

import azkena.azkena.model.identity.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> findAll();

    void save(Cliente cliente);

    void delete(Long id);
    Cliente findOne(Long id);
    public Cliente findByUsername(String username);

    public List<Cliente> findByNombre(String nombre);
    }


