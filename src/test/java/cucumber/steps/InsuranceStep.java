package cucumber.steps;

import cucumber.util.RestfulHelper;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import io.cucumber.spring.CucumberContextConfiguration;
import mob.code.insurance.InsuranceApplication;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@ContextConfiguration(classes = InsuranceApplication.class, loader = SpringBootContextLoader.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
public class InsuranceStep {

    @LocalServerPort
    private int port;

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
        JSONAssert.assertEquals(body, response.getBody(), true);
    }

    @当("客户选择计划:")
    public void selectProposal(String data) {
        response = RestfulHelper.connect(port).post("/proposal", data);
    }

}
