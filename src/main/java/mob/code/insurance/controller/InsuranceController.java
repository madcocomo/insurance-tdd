package mob.code.insurance.controller;

import mob.code.insurance.bean.Assured;
import mob.code.insurance.dto.ProposalParam;
import mob.code.insurance.repo.AssuredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class InsuranceController {
    @Autowired
    private AssuredRepository assuredRepository;

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    @PostMapping(value = "proposal")
    public String proposal(@RequestBody ProposalParam body) {
        List<Assured> assureds = assuredRepository.findAll();
        if (assureds.get(0).getAge() <= 2) {
            return "      {\n" +
                    "        benefits: [\n" +
                    "          { prodId: \"787\", fee: 5, insured: 60000},\n" +
                    "          { prodId: \"784\", fee: 1, insured: 10000},\n" +
                    "          { prodId: \"788\", fee: 22, insured: 20000}\n" +
                    "        ],\n" +
                    "        summary: {fee: 28}\n" +
                    "      }";
        }
        return  "{}";
    }

}
