package ru.university.model;

import lombok.Value;
import reactor.core.publisher.Mono;

@Value
public class CachedCurrencyCustomer {
    Mono<Customer> currencyCustomer;
}
