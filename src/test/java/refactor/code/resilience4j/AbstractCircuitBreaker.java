package refactor.code.resilience4j;

import static org.assertj.core.api.Assertions.assertThat;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;

class AbstractCircuitBreakerTest extends AbstractIntegrationTest {

    protected  void  checkHealthStatus(String circuitBreakerName, CircuitBreaker.State state){
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker(circuitBreakerName);
        assertThat(circuitBreaker.getState()).isEqualTo(state);
    }

}
