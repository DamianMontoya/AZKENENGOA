package azkena.azkena.model.dao;

import azkena.azkena.model.identity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IClienteDAO extends CrudRepository<Cliente,Long> {

    @Query(value = "SELECT * FROM clientes WHERE nombre LIKE %:nombre%",
            nativeQuery=true)
    List<Cliente> findByNombre(@Param("nombre") String nombre);

    // Se pueden definir métodos que empiecen por "findBy" y continuen con el nombre del campo.
    public Cliente findByUsername(String username);
}
