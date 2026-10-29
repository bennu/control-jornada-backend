package cl.bennu.controljornadabackend.mapper;

import cl.bennu.commons.mapper.base.BaseMapper;
import cl.bennu.controljornadabackend.model.Region;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RegionMapper extends BaseMapper<Region> {

    Region buscarPorNombre(@Param("name") String name);
}
