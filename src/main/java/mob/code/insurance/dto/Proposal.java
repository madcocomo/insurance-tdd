package mob.code.insurance.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter @Setter
@Accessors(chain = true)
public class Proposal {
     BigDecimal premium;
}
