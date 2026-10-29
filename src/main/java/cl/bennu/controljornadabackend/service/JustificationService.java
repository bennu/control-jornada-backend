package cl.bennu.controljornadabackend.service;

import cl.bennu.controljornadabackend.mapper.JustificationMapper;
import cl.bennu.controljornadabackend.model.Justification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JustificationService {

    private @Autowired JustificationMapper justificationMapper;

    public List<Justification> getAllJustifications() {
        return justificationMapper.getAll();
    }

    @Transactional
    public void saveJustification(Justification justification) {
        if (justification.getId() == null) {
            justificationMapper.insert(justification);
        } else {
            justificationMapper.update(justification);
        }
    }

    public Justification getJustificationById(Long id) {
        return justificationMapper.get(id);
    }

    public void deleteJustification(Long id) {
        justificationMapper.delete(id);
    }
}
