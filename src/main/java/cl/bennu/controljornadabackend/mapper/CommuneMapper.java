package cl.bennu.controljornadabackend.mapper;

import org.apache.ibatis.annotations.Mapper;

import cl.bennu.commons.mapper.base.BaseMapper;
import cl.bennu.controljornadabackend.model.Commune;

@Mapper 
public interface CommuneMapper extends BaseMapper<Commune> { /* impl. en XML */ }
