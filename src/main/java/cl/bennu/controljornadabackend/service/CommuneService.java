package cl.bennu.controljornadabackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.bennu.controljornadabackend.controller.advice.ResourceNotFoundException;
import cl.bennu.controljornadabackend.mapper.CommuneMapper;
import cl.bennu.controljornadabackend.model.Commune;

@Service 
public class CommuneService {
    private @Autowired CommuneMapper communeMapper;

    public List<Commune> getAll() {
        return communeMapper.getAll();
    }

    public void create(Commune commune) {
        communeMapper.insert(commune);
    }

    @Transactional 
    public void update(Commune commune) {
        if(!communeMapper.exists(commune.getId())) {
            throw new ResourceNotFoundException("No se encontró el ID: " + commune.getId());
        }

        communeMapper.update(commune);
    }

    public Commune getById(Long id) {
        Commune commune = communeMapper.get(id);

        if(commune == null) {
            throw new ResourceNotFoundException("No se encontró el ID: " + id);
        }

        return commune;
    }

    public void delete(Long id) {
        if(!communeMapper.exists(id)) {
            throw new ResourceNotFoundException("No se encontró el ID: " + id);
        }

        communeMapper.delete(id);
    }
}
