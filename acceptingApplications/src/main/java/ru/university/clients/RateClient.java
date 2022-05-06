package ru.university.clients;

import reactor.core.publisher.Mono;
import ru.university.model.CurrencyCustomer;

public interface RateClient {

    Mono<CurrencyCustomer> getCurrencyCustomer(Integer id);
}
