package azkena.azkena.model.service;

import azkena.azkena.model.dao.IClienteDAO;
import azkena.azkena.model.identity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IClienteServiceImp implements IClienteService {
    @Autowired
    private IClienteDAO clienteDAO;

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>)clienteDAO.findAll();
    }

    @Override
    public void save(Cliente cliente) {
        clienteDAO.save(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteDAO.deleteById(id);
    }

    @Override
    public Cliente findOne(Long id) {
        return clienteDAO.findById(id).orElse(null);
    }

    //Busca por username y devuelve el cliente buscado
    @Override
    public Cliente findByUsername(String username) {
        List<Cliente> clientes = (List<Cliente>)clienteDAO.findAll();
        for (Cliente cliente : clientes)
            if (cliente.getUsername().equalsIgnoreCase(username))
                return cliente;
        return null;
    }

    //Devuelve listado con todos los firstname usados

    @Override
    public List<Cliente> findByNombre(String nombre) {
        List<Cliente> clientes = (List<Cliente>) clienteDAO.findAll();
        List<Cliente> byNombre = new ArrayList<>();
        for(Cliente cliente : clientes)
            if (cliente.getNombre().contains(nombre))
                byNombre.add(cliente);
        return byNombre;
    }
}
