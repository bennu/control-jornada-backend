
package cl.bennu.controljornadabackend.controller;

import cl.bennu.controljornadabackend.constants.Constants;
import cl.bennu.controljornadabackend.controller.base.BaseController;
import cl.bennu.controljornadabackend.model.Justification;
import cl.bennu.controljornadabackend.service.JustificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(
        path = Constants.BASE_API,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class JustificationController extends BaseController {

    private static final String ENDPOINT = "/justification";

    private @Autowired JustificationService justificationService;

    @GetMapping(ENDPOINT)
    public ResponseEntity<List<Map<String, Object>>> getAll() {
        List<Map<String, Object>> justifications =
                justificationService.getAllJustificationsConTipo();

        return ResponseEntity.ok(justifications);
    }

    @PostMapping(ENDPOINT)
    public ResponseEntity<Justification> create(
            @RequestBody Justification justification) {

        justificationService.createJustification(justification);
        return ResponseEntity.ok(justification);
    }

    @PutMapping(ENDPOINT + "/{id}")
    public ResponseEntity<Justification> update(
            @PathVariable Long id,
            @RequestBody Justification justification) {

        justificationService.updateJustification(id, justification);
        return ResponseEntity.ok(justification);
    }

    @GetMapping(ENDPOINT + "/{id}")
    public ResponseEntity<Justification> getById(@PathVariable Long id) {

        Justification justification =
                justificationService.getJustificationById(id);

        if (justification == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(justification);
    }

    @DeleteMapping(ENDPOINT + "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        justificationService.deleteJustification(id);
        return ResponseEntity.ok().build();
    }
}
