package cucumber.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.util.RestfulHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableTypeRegistryTableConverter;
import io.cucumber.datatable.TableTransformer;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.DocStringType;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import io.cucumber.spring.CucumberContextConfiguration;
import mob.code.insurance.InsuranceApplication;
import mob.code.insurance.bean.Assured;
import mob.code.insurance.bean.Plan;
import mob.code.insurance.repo.AssuredRepository;
import mob.code.insurance.repo.PlanRepository;
import org.hamcrest.CoreMatchers;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;

@ContextConfiguration(classes = InsuranceApplication.class, loader = SpringBootContextLoader.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
public class InsuranceStep {

    @LocalServerPort
    private int port;

    @Autowired
    private AssuredRepository assuredRepository;

    @Autowired
    private PlanRepository planRepository;

    private ResponseEntity<String> response;

    @当("我连接服务")
    public void ping() {
        response = RestfulHelper.connect(port).get("/ping");
    }

    @那么("服务将会响应")
    public void willResponse() {
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("pong", response.getBody());
    }

    @那么("^服务将会响应:$")
    public void willResponseWithBody(String body) throws JSONException {
        assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals(body, response.getBody(), false);
    }

    @当("为客户展示保险组合{string}")
    public void showPortfolio(String portfolioCode) {
        response = RestfulHelper.connect(port).get("/portfolio/" + portfolioCode);
    }

    @当("客户选择计划:")
    public void selectProposal(String data) {
        response = RestfulHelper.connect(port).post("/proposal", data);
    }


    @DataTableType
    public Assured transform(Map<String, String> entry) {
        return new Assured().setName(entry.get("name")).setAge(Integer.parseInt(entry.get("age")));
    }

    @假如("存在被保险人:")
    public void existAssured(List<Assured> assureds) {
        assuredRepository.deleteAll();
        assuredRepository.save(assureds.get(0));
    }

    private final ObjectMapper objectMapper = new ObjectMapper();

    @DocStringType
    public Plan plan(String docString) throws IOException {
        return objectMapper.readValue(docString, Plan.class);
    }

    @Before
    public void cleanData() {
        planRepository.deleteAll();
    }

    @假如("定义有保险计划:")
    public void existPlan(Plan plan) {
        planRepository.save(plan);
    }
}
