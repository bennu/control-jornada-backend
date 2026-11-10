package cl.bennu.controljornadabackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.bennu.controljornadabackend.controller.advice.ResourceNotFoundException;
import cl.bennu.controljornadabackend.mapper.JustificationTypeMapper;
import cl.bennu.controljornadabackend.model.JustificationType;

@Service 
public class JustificationTypeService {
    private @Autowired JustificationTypeMapper justificationTypeMapper;

    public List<JustificationType> getAll() {
        return justificationTypeMapper.getAll();
    }

    public void create(JustificationType justType) {
        justificationTypeMapper.insert(justType);
    }

    @Transactional 
    public void update(JustificationType justType) {
        if(!justificationTypeMapper.exists(justType.getId())) {
            throw new ResourceNotFoundException("No se encontró el ID: " + justType.getId());
        }

        justificationTypeMapper.update(justType);
    }

    public JustificationType getById(Long id) {
        JustificationType justType = justificationTypeMapper.get(id);

        if(justType == null) {
            throw new ResourceNotFoundException("No se encontró el ID: " + id);
        }

        return justType;
    }

    @Transactional 
    public void delete(Long id) {
        if(!justificationTypeMapper.exists(id)) {
            throw new ResourceNotFoundException("No se encontró el ID: " + id);
        }

        justificationTypeMapper.delete(id);
    }
}
