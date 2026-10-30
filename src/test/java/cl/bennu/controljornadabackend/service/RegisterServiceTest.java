
package cl.bennu.controljornadabackend.service;

import cl.bennu.controljornadabackend.mapper.RegisterMapper;
import cl.bennu.controljornadabackend.model.Register;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegisterServiceTest {

    @Mock
    private RegisterMapper registerMapper;

    @InjectMocks
    private RegisterService registerService;

    private Register register;

    @BeforeEach
    void setUp() {
        register = new Register();
        register.setId(1L);
        register.setEmployeeId(10);
        register.setStartOfTheDay(LocalTime.of(8, 0));
        register.setEntry(LocalTime.of(8, 30));
        register.setExit(LocalTime.of(17, 0));
        register.setBreakTime(LocalTime.of(12, 0));
        register.setBackToWork(LocalTime.of(13, 0));
        register.setDay(LocalDate.of(2026, 10, 27));
        register.setJustificationId(null);
    }

    @Test
    void listarDebeDevolverTodosLosRegistros() {
        when(registerMapper.getAll()).thenReturn(List.of(register));

        List<Register> resultado = registerService.listar();

        assertEquals(1, resultado.size());
        assertEquals(1L, resultado.get(0).getId());
        verify(registerMapper).getAll();
    }

    @Test
    void encontrarPorIdDebeDevolverElRegistroExistente() {
        when(registerMapper.get(1L)).thenReturn(register);

        Register resultado = registerService.encontrarPorId(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals(10, resultado.getEmployeeId());
        verify(registerMapper).get(1L);
    }

    @Test
    void crearDebeGuardarElRegistro() {
        when(registerMapper.get(1L)).thenReturn(register);

        Register resultado = registerService.crear(register);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());

        verify(registerMapper).insert(register);
        verify(registerMapper).get(1L);
    }

    @Test
    void actualizarDebeActualizarElRegistroExistente() {
        when(registerMapper.get(1L)).thenReturn(register);

        Register resultado = registerService.actualizar(1L, register);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());

        verify(registerMapper, times(2)).get(1L);
        verify(registerMapper).update(register);
    }

    @Test
    void eliminarDebeEliminarElRegistroExistente() {
        when(registerMapper.get(1L)).thenReturn(register);

        registerService.eliminar(1L);

        verify(registerMapper).get(1L);
        verify(registerMapper).delete(1L);
    }

    @Test
    void actualizarDebeFallarSiElRegistroNoExiste() {
        when(registerMapper.get(99L)).thenReturn(null);

        assertThrows(
                ResponseStatusException.class,
                () -> registerService.actualizar(99L, register)
        );

        verify(registerMapper, never()).update(any(Register.class));
    }

    @Test
    void eliminarDebeFallarSiElRegistroNoExiste() {
        when(registerMapper.get(99L)).thenReturn(null);

        assertThrows(
                ResponseStatusException.class,
                () -> registerService.eliminar(99L)
        );

        verify(registerMapper, never()).delete(99L);
    }
}
