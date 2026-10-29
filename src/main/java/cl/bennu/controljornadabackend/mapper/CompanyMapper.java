package cl.bennu.controljornadabackend.mapper;

import cl.bennu.commons.mapper.base.BaseMapper;
import cl.bennu.controljornadabackend.model.Company;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper extends BaseMapper<Company> {
}
