package azkena.azkena.model.service;

import azkena.azkena.model.identity.Cliente;
import azkena.azkena.model.identity.Evento;
import azkena.azkena.model.identity.Rol;

import java.util.List;

public interface IRolService {

    List<Rol> findAll();
    public Rol findByRol(String rol);
}
