package cl.bennu.controljornadabackend.mapper;

import org.apache.ibatis.annotations.Mapper;

import cl.bennu.commons.mapper.base.BaseMapper;
import cl.bennu.controljornadabackend.model.JobScheduler;

@Mapper
public interface JobSchedulerMapper extends BaseMapper<JobScheduler> { }