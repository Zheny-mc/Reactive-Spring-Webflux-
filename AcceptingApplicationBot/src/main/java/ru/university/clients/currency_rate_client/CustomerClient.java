package ru.university.clients.currency_rate_client;

import reactor.core.publisher.Mono;
import ru.university.model.Customer;

public interface CustomerClient {

    Mono<Customer> getCustomer(Integer number);
}
