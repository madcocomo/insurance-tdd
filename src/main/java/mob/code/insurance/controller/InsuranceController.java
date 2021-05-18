package mob.code.insurance.controller;

import mob.code.insurance.bean.Plan;
import mob.code.insurance.domain.PremiumCalculator;
import mob.code.insurance.dto.Proposal;
import mob.code.insurance.dto.Portfolio;
import mob.code.insurance.dto.ProposalParam;
import mob.code.insurance.repo.AssuredRepository;
import mob.code.insurance.repo.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/")
public class InsuranceController {
    @Autowired
    private AssuredRepository assuredRepository;
    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private PremiumCalculator premiumCalculator;

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("portfolio/{code}")
    public Portfolio portfolio(@PathVariable String code) {
        return new Portfolio().setPlans(planRepository.findByPortfolioCode(code));
    }

    @PostMapping(value = "proposal")
    public Proposal proposal(@RequestBody ProposalParam param) {
        String portfolioId = param.getPortfolioId();
        Plan plan = planRepository.findByPortfolioId(portfolioId);
        if (plan.getName().equals("基础版")) {
            return premiumCalculator.calculate(plan.getPremiums(), 1);
        }
        return null;
    }

}
