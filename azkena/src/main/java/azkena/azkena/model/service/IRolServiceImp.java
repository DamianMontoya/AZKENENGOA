package azkena.azkena.model.service;

import azkena.azkena.model.dao.IRolDAO;
import azkena.azkena.model.identity.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class  IRolServiceImp implements IRolService {
    @Autowired
    IRolDAO rolDAO;

    @Override
    public List<Rol> findAll() {

        return (List<Rol>) rolDAO.findAll();
    }

    @Override
    public Rol findByRol(String rol) {
        return rolDAO.findByRol(rol);
    }
}

