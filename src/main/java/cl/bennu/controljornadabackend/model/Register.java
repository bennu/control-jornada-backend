
package cl.bennu.controljornadabackend.model;

import cl.bennu.commons.domain.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Register extends BaseDomain implements Serializable {

    private Integer employeeId;
    private LocalTime startOfTheDay;
    private LocalTime entry;
    private LocalTime exit;
    private LocalTime breakTime;
    private LocalTime backToWork;
    private LocalDate day;
    private Integer justificationId;
}
