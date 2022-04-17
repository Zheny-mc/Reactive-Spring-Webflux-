package ru.cbrrate.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.cbrrate.config.CbrRateClientConfig;
import ru.cbrrate.model.CurrencyCustomer;

@Service("user")
@RequiredArgsConstructor
@Slf4j
public class CbrCustomerClient implements RateClient {

    private final CbrRateClientConfig config;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    @Override
    public Mono<CurrencyCustomer> getCurrencyCustomer(Integer id) {
        log.info("implementing the request id: {}", id);
        var urlWithParams = String.format("%s/%s", config.getUrl(), id);

        try {
            return httpClient.performRequest(urlWithParams)
                    .map(this::parse);
        } catch (HttpClientException ex) {
            throw new CustomerClientException("Error from Cbr Client host:" + ex.getMessage());
        } catch (Exception ex) {
            log.error("Getting currencyCustomer error, id:{}", id, ex);
            throw new CustomerClientException("Can't get currencyCustomer. id:" + id);
        }
    }

    private CurrencyCustomer parse(String rateAsString) {
        try {
            return objectMapper.readValue(rateAsString, CurrencyCustomer.class);
        } catch (Exception ex) {
            throw new CustomerClientException("Can't parse string:" + rateAsString);
        }
    }
}
