package azkena.azkena.model.service;

import azkena.azkena.model.dao.IEventoDAO;
import azkena.azkena.model.identity.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IEventoServiceImp implements IEventoService{
   @Autowired
   private IEventoDAO eventoDAO;
    @Override
    public List<Evento> findAll() {

        return (List<Evento>) eventoDAO.findAll();
    }

    @Override
    public void save(Evento evento) {
        eventoDAO.save(evento);
    }

    @Override
    public void delete(Long id) {
        eventoDAO.deleteById(id);
    }

    @Override
    public Evento findOne(Long id) {
        return eventoDAO.findById(id).orElse(null);
    }

    @Override
    public List<Evento> findByName(String name) {
        return null;
    }
}
