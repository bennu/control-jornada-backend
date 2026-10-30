
package cl.bennu.controljornadabackend.service;

import cl.bennu.controljornadabackend.mapper.RegisterMapper;
import cl.bennu.controljornadabackend.model.Register;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class RegisterService {

    private final RegisterMapper registerMapper;

    public RegisterService(RegisterMapper registerMapper) {
        this.registerMapper = registerMapper;
    }

    public List<Register> listar() {
        return registerMapper.getAll();
    }

    public Register encontrarPorId(Long id) {
        Register register = registerMapper.get(id);

        if (register == null) {
            throw new ResponseStatusException(
                    NOT_FOUND,
                    "No existe un registro con ID " + id
            );
        }

        return register;
    }

    @Transactional
    public Register crear(Register register) {
        registerMapper.insert(register);
        return encontrarPorId(register.getId());
    }

    @Transactional
    public Register actualizar(Long id, Register data) {
        encontrarPorId(id);

        data.setId(id);
        registerMapper.update(data);

        return encontrarPorId(id);
    }

    @Transactional
    public void eliminar(Long id) {
        encontrarPorId(id);
        registerMapper.delete(id);
    }
}
