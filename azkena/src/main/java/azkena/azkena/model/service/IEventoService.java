package azkena.azkena.model.service;

import azkena.azkena.model.identity.Evento;

import java.util.List;

public interface IEventoService {
    List<Evento> findAll();

    void save(Evento evento);

    void delete(Long id);
    Evento findOne(Long id);
    List<Evento> findByName(String name);


}
