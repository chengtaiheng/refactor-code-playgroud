package refactor.code.playground;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.net.URI;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.permanentRedirect;

@EnableWebMvc
@SpringBootApplication
@EnableJpaRepositories(basePackages = "refactor.code.playground.repositories")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    RouterFunction<ServerResponse> redirectRoot() {
        return route(GET("/"), req -> permanentRedirect(URI.create("/actuator")).build());
    }
}
