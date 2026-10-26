package cl.bennu.controljornadabackend.model;

import java.io.Serializable;

import cl.bennu.commons.domain.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode (callSuper = true)
@Data
@NoArgsConstructor
public class Commune extends BaseDomain implements Serializable {
    private Long cityId;
    private String name;
    private String siiCode;
    private String tgrCode;
}
