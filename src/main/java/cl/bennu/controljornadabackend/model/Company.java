package cl.bennu.controljornadabackend.model;


import cl.bennu.commons.domain.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class Company extends BaseDomain implements Serializable {
    private Long communeId;
    private String code;
    private String name;
    private String address;
    private String phone;
    private String alias;
    private String giro;
    private String email;
    private Boolean geolocation;
    private Boolean selfie;
    private Boolean lag;

}
