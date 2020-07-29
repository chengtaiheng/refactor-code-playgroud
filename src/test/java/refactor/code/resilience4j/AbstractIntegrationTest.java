package refactor.code.resilience4j;


import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import refactor.code.playground.Application;

@RunWith(SpringRunner.class)
@AutoConfigureWebClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public abstract class AbstractIntegrationTest {

    protected static final String BACKEND_A = "backendA";

    protected static final String BACKEND_B = "backendB";

    @Autowired
    protected CircuitBreakerRegistry circuitBreakerRegistry;

    @Autowired
    protected TestRestTemplate restTemplate;

    @Autowired
    protected WebTestClient webTestClient;

    @Before
    public void setup() {
        transitionToOClosedState(BACKEND_A);
        transitionToOClosedState(BACKEND_B);
    }

    protected void transitionToOpenState(String circuitBreakerName) {
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker(circuitBreakerName);
        circuitBreaker.transitionToOpenState();
    }

    protected void transitionToOClosedState(String circuitBreakerName) {
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker(circuitBreakerName);
        circuitBreaker.transitionToClosedState();
    }

}
