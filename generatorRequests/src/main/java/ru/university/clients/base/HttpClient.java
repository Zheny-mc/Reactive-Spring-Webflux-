package ru.university.clients.base;

import reactor.core.publisher.Mono;

public interface HttpClient {

    Mono<String> performRequest(String url);
}
