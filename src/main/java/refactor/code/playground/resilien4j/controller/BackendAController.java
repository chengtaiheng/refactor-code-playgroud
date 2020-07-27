package refactor.code.playground.resilien4j.controller;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import refactor.code.playground.resilien4j.service.Service;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/backendA")
public class BackendAController {

    private final Service businessASerivice;

    public BackendAController(@Qualifier("backendAservice") Service businessASerivice) {
        this.businessASerivice = businessASerivice;
    }

    @GetMapping("/failure")
    public String failure() {
        return businessASerivice.failure();
    }

    @GetMapping("/success")
    public String success() {
        return businessASerivice.success();
    }

    @GetMapping("/successException")
    public String successException() {
        return businessASerivice.successException();
    }

    @GetMapping("/ignore")
    public String ignore() {
        return businessASerivice.ignoreException();
    }

    @GetMapping("/monoSuccess")
    public Mono<String> monoSuccess() {
        return businessASerivice.monoSuccess();
    }

    @GetMapping("/monoFailure")
    public Mono<String> monoFailure() {
        return businessASerivice.monoFailure();
    }

    @GetMapping("/fluxSuccess")
    public Flux<String> fluxString() {
        return businessASerivice.fluxSuccess();
    }

    @GetMapping("/monoTimeout")
    public Mono<String> monoTimeout() {
        return businessASerivice.monoTimeout();
    }

    @GetMapping("/futureFailure")
    public CompletableFuture<String> futureFailure() {
        return businessASerivice.futureFailure();
    }

    @GetMapping("/futureSuccess")
    public CompletableFuture<String> futureSuccess() {
        return businessASerivice.futureSuccess();
    }

    @GetMapping("/futureTimeout")
    public CompletableFuture<String> futureTimeout() {
        return businessASerivice.futureTimeout();
    }


    @GetMapping("/fluxFailure")
    public Flux<String> fluxFailure() {
        return businessASerivice.fluxFailure();
    }

    @GetMapping("/fallback")
    public String failureWithFallBack() {
        return businessASerivice.failureWithFallback();
    }


}
