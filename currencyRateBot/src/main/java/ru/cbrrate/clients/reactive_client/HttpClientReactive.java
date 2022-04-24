package ru.cbrrate.clients.reactive_client;

import reactor.core.publisher.Mono;

public interface HttpClientReactive {

    Mono<String> performRequest(String url);
}
