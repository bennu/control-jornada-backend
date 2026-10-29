package cl.bennu.controljornadabackend.controller.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@CrossOrigin
public abstract class BaseController {

    protected static ResponseEntity<?> ok() {
        return ResponseEntity.ok(HttpStatus.OK);
    }

    protected static ResponseEntity<?> ok(Object o) {
        if (o instanceof String || o instanceof Number || o instanceof Boolean || o instanceof Date) {
            Map<String, Object> map = new HashMap<>();
            map.put("value", o);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(o, HttpStatus.OK);
        }
    }

}