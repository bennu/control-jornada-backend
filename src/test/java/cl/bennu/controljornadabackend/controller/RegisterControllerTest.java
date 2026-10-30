
package cl.bennu.controljornadabackend.controller;

import cl.bennu.controljornadabackend.constants.Constants;
import cl.bennu.controljornadabackend.controller.base.BaseController;
import cl.bennu.controljornadabackend.model.Register;
import cl.bennu.controljornadabackend.service.RegisterService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        path = Constants.BASE_API,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class RegisterControllerTest extends BaseController {

    private static final String ENDPOINT = "/registers";

    private final RegisterService registerService;

    public RegisterControllerTest(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping(ENDPOINT)
    public ResponseEntity<?> getAll() {
        List<Register> registers = registerService.listar();
        return ok(registers);
    }

    @GetMapping(ENDPOINT + "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ok(registerService.encontrarPorId(id));
    }

    @PostMapping(
            path = ENDPOINT,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> save(@RequestBody Register register) {
        return ok(registerService.crear(register));
    }

    @PutMapping(
            path = ENDPOINT + "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody Register register
    ) {
        return ok(registerService.actualizar(id, register));
    }

    @DeleteMapping(ENDPOINT + "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        registerService.eliminar(id);
        return ok();
    }
}
