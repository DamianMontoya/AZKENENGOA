package azkena.azkena.model.dao;

import azkena.azkena.model.identity.Evento;
import org.springframework.data.repository.CrudRepository;

public interface IEventoDAO extends CrudRepository<Evento, Long> {
}
