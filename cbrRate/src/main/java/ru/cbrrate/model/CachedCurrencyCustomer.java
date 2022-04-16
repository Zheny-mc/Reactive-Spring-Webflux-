package ru.cbrrate.model;

import lombok.Value;
import reactor.core.publisher.Mono;

import java.util.List;

@Value
public class CachedCurrencyCustomer {
    Mono<Customer> currencyCustomer;
}
