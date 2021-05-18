package mob.code.insurance.domain;

import mob.code.insurance.bean.PremiumDefinition;
import mob.code.insurance.dto.Proposal;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PremiumCalculatorTest {
    @Test
    public void calculateByAge() {
        PremiumCalculator calculator = new PremiumCalculator();
        List<PremiumDefinition> premiums = Arrays.asList(
                new PremiumDefinition().setAgeMin(0).setAgeMax(2).setPremium(BigDecimal.valueOf(55)),
                new PremiumDefinition().setAgeMin(3).setAgeMax(25).setPremium(BigDecimal.valueOf(15))
        );
        Proposal calculate = calculator.calculate(premiums, 1);
        assertEquals(BigDecimal.valueOf(55), calculate.getPremium());
    }
}