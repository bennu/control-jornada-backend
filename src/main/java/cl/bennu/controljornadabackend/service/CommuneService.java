package cl.bennu.controljornadabackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.bennu.controljornadabackend.mapper.CommuneMapper;
import cl.bennu.controljornadabackend.model.Commune;

@Service 
public class CommuneService {
    private @Autowired CommuneMapper communeMapper;

    public List<Commune> getAll() {
        return communeMapper.getAll();
    }

    @Transactional
    public void save(Commune commune) {
        if (null == commune.getId()) {
            communeMapper.insert(commune);
        } else {
            communeMapper.update(commune);
        }
    }

    public Commune getById(Long id) {
        return communeMapper.get(id);
    }

    public void delete(Long id) {
        communeMapper.delete(id);
    }
}
