package mob.code.insurance.controller;

import mob.code.insurance.dto.ProposalParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class InsuranceController {

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    @PostMapping(value = "proposal")
    public String proposal(@RequestBody ProposalParam body) {
        return "      {\n" +
                "        benefits: [\n" +
                "          { prodId: \"787\", fee: 5, insured: 60000},\n" +
                "          { prodId: \"784\", fee: 1, insured: 10000},\n" +
                "          { prodId: \"788\", fee: 22, insured: 20000}\n" +
                "        ],\n" +
                "        summary: {fee: 28}\n" +
                "      }";
    }

}
