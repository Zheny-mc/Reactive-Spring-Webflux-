package ru.cbrrate.clients;

import reactor.core.publisher.Mono;
import ru.cbrrate.model.CurrencyCustomer;

import java.time.LocalDate;

public interface RateClient {

    Mono<CurrencyCustomer> getCurrencyCustomer(Integer id);
}
