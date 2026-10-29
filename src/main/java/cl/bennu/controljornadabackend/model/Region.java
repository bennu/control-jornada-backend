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
public class Region extends BaseDomain implements Serializable {

    private Integer countryId;
    private String name;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static Region valueOf(Long id) {
        Region region = new Region();
        region.setId(id);
        return region;
    }
}
