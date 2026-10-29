package cl.bennu.controljornadabackend.model.query;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ExampleQuery implements Serializable {

    private String code;
    private LocalDate from;
    private LocalDate to;

}