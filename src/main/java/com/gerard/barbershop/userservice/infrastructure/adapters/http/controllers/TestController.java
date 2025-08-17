package com.gerard.barbershop.userservice.infrastructure.http.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@RestController
public class TestController {

    @GetMapping("test")
    public Flux<String> fooPublishers(){

        Flux<String> names = Flux.just("Jhon", "Carlos", "Juan").delayElements(Duration.ofSeconds(1));

        names.subscribe(name -> System.out.println(name));

        System.out.println("Non blocking code");

        return names;
    }

    @GetMapping("test2")
    public Flux<String> fooPublisher2(){
        // Flux takes 1 to n elements.

        List<String> names = List.of("Juan","Pedro", "Carlos", "Jhon");

        Flux<String> namePublisher = Flux.fromIterable(names).delayElements(Duration.ofSeconds(2)).log();

        return namePublisher;
    }

    @GetMapping("test3")
    public Mono<String> singlePublisher(){

        //Mono just takes 1 element.
        Mono<String> singleMonoPublisher = Mono.just("Juan");

        singleMonoPublisher.subscribe(str -> System.out.println(str));

        return singleMonoPublisher;
    }

}
