package cl.bennu.controljornadabackend.service;

import cl.bennu.controljornadabackend.mapper.RegionMapper;
import cl.bennu.controljornadabackend.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RegionService {

    private @Autowired RegionMapper regionMapper;

    public List<Region> getAllRegions() {
        return regionMapper.getAll();
    }

    @Transactional
    public void saveRegion(Region region) {
        Region regionConEseNombre = regionMapper.buscarPorNombre(region.getName());
        if (regionConEseNombre != null && !regionConEseNombre.getId().equals(region.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe una región con ese nombre");
        }

        if (region.getId() == null) {
            regionMapper.insert(region);
        } else {
            regionMapper.update(region);
        }
    }

    public Region getRegionById(Long id) {
        return regionMapper.get(id);
    }

    public void deleteRegion(Long id) {
        regionMapper.delete(id);
    }
}
