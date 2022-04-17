package ru.cbrrate.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.cbrrate.model.CurrencyCustomer;
import ru.cbrrate.services.CurrencyCustomerEndpointService;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "${app.rest.api.prefix}/customer")
public class CurrencyCustomerEndpointController {

    public final CurrencyCustomerEndpointService currencyRateEndpointService;

    @GetMapping("/{id}")
    public Mono<CurrencyCustomer> getCurrencyCustomer(@PathVariable Integer id)  {
        log.info("getCurrencyCustomer in client, id:{}", id);
        return currencyRateEndpointService.getCurrencyRate(id);
    }
}