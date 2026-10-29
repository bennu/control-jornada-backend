package cl.bennu.controljornadabackend.model;

import cl.bennu.commons.domain.base.BaseDomain;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Justification extends BaseDomain implements Serializable {

    private String comments;
    private byte[] attachment;
    private Integer justificationTypeId;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static Justification valueOf(Long id) {
        Justification justification = new Justification();
        justification.setId(id);
        return justification;
    }
}
