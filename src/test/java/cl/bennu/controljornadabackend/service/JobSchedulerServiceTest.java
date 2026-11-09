package cl.bennu.controljornadabackend.service;

import cl.bennu.controljornadabackend.mapper.JobSchedulerMapper;
import cl.bennu.controljornadabackend.model.JobScheduler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JobSchedulerServiceTest {

    @Mock
    private JobSchedulerMapper jobSchedulerMapper;

    @InjectMocks
    private JobSchedulerService jobSchedulerService;

    @Test
    void getAll_returnList() {
        JobScheduler j1 = new JobScheduler();
        j1.setId(1L);
        j1.setName("Standard Day");

        when(jobSchedulerMapper.getAll()).thenReturn(List.of(j1));

        List<JobScheduler> result = jobSchedulerService.getAll();

        assertEquals(1, result.size());
        assertEquals("Standard Day", result.get(0).getName());
        verify(jobSchedulerMapper).getAll();
    }

    @Test
    void getById_existing_returnJobScheduler() {
        JobScheduler j = new JobScheduler();
        j.setId(1L);
        j.setName("Standard Day");

        when(jobSchedulerMapper.get(1L)).thenReturn(j);

        JobScheduler result = jobSchedulerService.getById(1L);

        assertEquals(1L, result.getId());
        assertEquals("Standard Day", result.getName());
        verify(jobSchedulerMapper).get(1L);
    }

    @Test
    void getById_notFound_returnNull() {
        when(jobSchedulerMapper.get(99L)).thenReturn(null);

        JobScheduler result = jobSchedulerService.getById(99L);

        assertNull(result);
        verify(jobSchedulerMapper).get(99L);
    }
}