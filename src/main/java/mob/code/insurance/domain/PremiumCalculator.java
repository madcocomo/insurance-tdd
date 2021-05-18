package mob.code.insurance.domain;

import mob.code.insurance.bean.PremiumDefinition;
import mob.code.insurance.dto.Proposal;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class PremiumCalculator {
    public Proposal calculate(List<PremiumDefinition> premiums, int age) {
        BigDecimal find = BigDecimal.ZERO;
        for (PremiumDefinition premium : premiums) {
            if (premium.getAgeMin() <= age && premium.getAgeMax() >= age) {
                 find = premium.getPremium();
            }
        }
        return new Proposal().setPremium(find);
//        return new Proposal().setPremium(BigDecimal.valueOf(28));
    }
}
