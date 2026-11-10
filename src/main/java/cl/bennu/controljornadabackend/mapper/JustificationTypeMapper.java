package cl.bennu.controljornadabackend.mapper;

import org.apache.ibatis.annotations.Mapper;

import cl.bennu.commons.mapper.base.BaseMapper;
import cl.bennu.controljornadabackend.model.JustificationType;

@Mapper 
public interface JustificationTypeMapper extends BaseMapper<JustificationType>  {
    /* XML impl. */

    public boolean exists(Long id);
}

