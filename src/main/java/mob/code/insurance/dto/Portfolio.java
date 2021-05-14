package mob.code.insurance.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import mob.code.insurance.bean.Plan;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class Portfolio {
    private List<Plan> plans;
}
