package cl.bennu.controljornadabackend.model;

import cl.bennu.commons.domain.base.BaseDomain;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Example extends BaseDomain implements Serializable {

    private String name;
    private String code;
    private LocalDate date;
    private LocalDateTime dateTime;
    private String description;


    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static Example valueOf(Long id) {
        Example o = new Example();
        o.setId(id);

        return o;
    }
}