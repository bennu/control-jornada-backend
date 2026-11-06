package cl.bennu.controljornadabackend.service;

import cl.bennu.controljornadabackend.mapper.JustificationMapper;
import cl.bennu.controljornadabackend.model.Justification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import org.apache.commons.collections4.MapUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JustificationService {

    private @Autowired JustificationMapper justificationMapper;
    private @Autowired JustificationTypeService justificationTypeService;

    public List<Justification> getAllJustifications() {
        return justificationMapper.getAll();
    }

    public List<Map<String, Object>> getAllJustificationsConTipo() {
        var typeNames = justificationTypeService.getAll().stream().collect(Collectors.toMap(type -> type.getId(), type -> type.getName()));
        return getAllJustifications().stream().map(justification -> MapUtils.putAll(new LinkedHashMap<String, Object>(), new Object[]{
                "id", justification.getId(), "comments", justification.getComments(), "attachment", justification.getAttachment(), "justificationTypeId", justification.getJustificationTypeId(), "justificationTypeName", typeNames.get(justification.getJustificationTypeId().longValue())})).toList();
    }



    @Transactional
    public void createJustification(Justification justification) {
        justificationMapper.insert(justification);
    }

    @Transactional
    public void updateJustification(Long id, Justification justification) {
        if (justificationMapper.get(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe una justificación con ese id");
        }

        justification.setId(id);
        justificationMapper.update(justification);
    }

    public Justification getJustificationById(Long id) {
        return justificationMapper.get(id);
    }

    public void deleteJustification(Long id) {
        justificationMapper.delete(id);
    }
}
