package azkena.azkena.model.dao;

import azkena.azkena.model.identity.Rol;
import org.springframework.data.repository.CrudRepository;

public interface IRolDAO extends CrudRepository<Rol,Long> {

    public Rol findByRol(String rol);
}
