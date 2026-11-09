package cl.bennu.controljornadabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.bennu.controljornadabackend.constants.Constants;
import cl.bennu.controljornadabackend.controller.base.BaseController;
import cl.bennu.controljornadabackend.model.JobScheduler;
import cl.bennu.controljornadabackend.service.JobSchedulerService;

@RestController
@RequestMapping(path = Constants.BASE_API, produces = MediaType.APPLICATION_JSON_VALUE)
public class JobSchedulerController extends BaseController {
    private static final String ENDPOINT = "/job-scheduler";

    private @Autowired JobSchedulerService jobSchedulerService;

    @GetMapping(ENDPOINT)
    public ResponseEntity<?> getAll() {
        List<JobScheduler> jobSchedulers = jobSchedulerService.getAll();
        return ok(jobSchedulers);
    }

    @GetMapping(ENDPOINT + "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        JobScheduler jobScheduler = jobSchedulerService.getById(id);
        if (jobScheduler == null) {
            return ResponseEntity.notFound().build();
        }
        return ok(jobScheduler);
    }
}