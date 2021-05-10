package cucumber.util;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.Collections;

public class RestfulHelper {
    private static final String LOCALHOST = "http://localhost:";

    private TestRestTemplate restTemplate = new TestRestTemplate();
    private HttpHeaders headers = new HttpHeaders();
    private HttpEntity<String> emptyEntity = new HttpEntity<String>(null, headers);
    private int port;

    public static RestfulHelper connect(int port) {
        return new RestfulHelper(port);
    }

    public RestfulHelper(int port) {
        this.port = port;
    }

    public ResponseEntity<String> get(String url) {
        return exchange(url, HttpMethod.GET, emptyEntity);
    }

    public ResponseEntity<String> post(String url) {
        return exchange(url, HttpMethod.POST, emptyEntity);
    }

    public ResponseEntity<String> post(String url, String data) {
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(data, headers);
        return exchange(url, HttpMethod.POST, entity);
    }

    private ResponseEntity<String> exchange(String url, HttpMethod method, HttpEntity<String> entity) {
        return restTemplate.exchange(fullUrl(url), method, entity, String.class);
    }

    private String fullUrl(String entry) {
        return LOCALHOST + port + entry;
    }

}
