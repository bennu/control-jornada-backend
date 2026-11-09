package cl.bennu.controljornadabackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.bennu.controljornadabackend.mapper.JobSchedulerMapper;
import cl.bennu.controljornadabackend.model.JobScheduler;

@Service
public class JobSchedulerService {
    private @Autowired JobSchedulerMapper jobSchedulerMapper;

    public List<JobScheduler> getAll() {
        return jobSchedulerMapper.getAll();
    }

    public JobScheduler getById(Long id) {
        return jobSchedulerMapper.get(id);
    }
}