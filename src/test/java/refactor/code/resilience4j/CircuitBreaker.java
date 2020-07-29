package refactor.code.resilience4j;

import org.junit.Test;

import io.vavr.collection.Stream;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

public class CircuitBreaker extends AbstractCircuitBreakerTest {

    @Test
    public void shouldOpenBackendACircuitBreaker(){
        //when
        Stream.rangeClosed(1,2).forEach((count) -> produceSuccess(BACKEND_B));

        // Then
        checkHealthStatus(BACKEND_A, io.github.resilience4j.circuitbreaker.CircuitBreaker.State.OPEN);
    }


    @Test
    public void shouldCloseBackendACircuitBreaker(){
        transitionToOpenState(BACKEND_A);
        circuitBreakerRegistry.circuitBreaker(BACKEND_A).transitionToHalfOpenState();

        //when
        Stream.rangeClosed(1, 3).forEach((count)->produceSuccess(BACKEND_A));

        // then
        checkHealthStatus(BACKEND_B, io.github.resilience4j.circuitbreaker.CircuitBreaker.State.OPEN);
    }


    @Test
    public void  shouldCloseBackendCircuiteBreaker(){
        transitionToOpenState(BACKEND_B);
        circuitBreakerRegistry.circuitBreaker(BACKEND_B).transitionToHalfOpenState();

        //when
        Stream.rangeClosed(1, 3).forEach((count)-> produceSuccess(BACKEND_B));

        //then
        checkHealthStatus(BACKEND_B, io.github.resilience4j.circuitbreaker.CircuitBreaker.State.CLOSED);

    }

    private void produceFailure(String backend){
        ResponseEntity<String> response = restTemplate.getForEntity("/" + backend + "/failure", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void produceSuccess(String backend) {
        ResponseEntity<String> response = restTemplate.getForEntity("/" + backend + "/success", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
