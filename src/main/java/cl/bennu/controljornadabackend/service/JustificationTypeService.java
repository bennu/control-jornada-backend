package cl.bennu.controljornadabackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.bennu.controljornadabackend.mapper.JustificationTypeMapper;
import cl.bennu.controljornadabackend.model.JustificationType;

@Service 
public class JustificationTypeService {
    private @Autowired JustificationTypeMapper justificationTypeMapper;

    public List<JustificationType> getAll() {
        return justificationTypeMapper.getAll();
    }

    @Transactional
    public void save(JustificationType justType) {
        if (null == justType.getId()) {
            justificationTypeMapper.insert(justType);
        } else {
            justificationTypeMapper.update(justType);
        }
    }

    public JustificationType getById(Long id) {
        return justificationTypeMapper.get(id);
    }

    public void delete(Long id) {
        justificationTypeMapper.delete(id);
    }
}
