package ru.cbrrate.clients.currency_rate_client;

import reactor.core.publisher.Mono;
import ru.cbrrate.model.CurrencyRate;

import java.time.LocalDate;

public interface CurrencyRateClient {

    Mono<CurrencyRate> getCurrencyRate(String rateType, String currency, LocalDate date);
}
