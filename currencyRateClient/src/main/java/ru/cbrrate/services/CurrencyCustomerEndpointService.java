package ru.cbrrate.services;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.cbrrate.clients.RateClient;

import ru.cbrrate.model.CurrencyCustomer;
import ru.cbrrate.model.CustomerType;


import java.util.Map;

@Service
@Slf4j
public class CurrencyCustomerEndpointService {

    private final Map<String, RateClient> clients;

    public CurrencyCustomerEndpointService(Map<String, RateClient> clients) {
        this.clients = clients;
    }

    public Mono<CurrencyCustomer> getCurrencyRate(Integer id) {
        log.info("Query client id: {}", id);
        var client = clients.get(CustomerType.USER.getServiceName());
        return client.getCurrencyCustomer(id);
    }
}
