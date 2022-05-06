package ru.university.clients.currency_rate_client;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.university.clients.reactive_client.HttpClientReactive;
import ru.university.clients.base.HttpClientException;
import ru.university.config.CustomerClientConfig;
import ru.university.model.Customer;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerClientImpl implements CustomerClient {
//    public static final String DATE_FORMAT = "dd-MM-yyyy";
//    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    private final CustomerClientConfig config;

    private final HttpClientReactive httpClient;
    private final ObjectMapper objectMapper;

    @Override
    public Mono<Customer> getCustomer(Integer number) {
        log.info("getCustomer: {}", number);
        var urlWithParams = String.format("%s/%s", config.getUrl(), number);

        try {
            return httpClient.performRequest(urlWithParams)
                    .map(this::parse);
        } catch (HttpClientException ex) {
            throw new CustomerClientException("Error from Cbr Client host:" + ex.getMessage());
        } catch (Exception ex) {
            log.error("Getting customer error, number:{}", number, ex);
            throw new CustomerClientException("Can't get customer: " + number);
        }
    }

    private Customer parse(String rateAsString) {
        try {
            return objectMapper.readValue(rateAsString, Customer.class);
        } catch (Exception ex) {
            throw new CustomerClientException("Can't parse string:" + rateAsString);
        }
    }

}
