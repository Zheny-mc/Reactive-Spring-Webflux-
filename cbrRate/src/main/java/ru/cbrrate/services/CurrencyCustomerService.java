package ru.cbrrate.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ehcache.Cache;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.cbrrate.model.CachedCurrencyCustomer;
import ru.cbrrate.model.Customer;
import ru.cbrrate.repo.CustomerRepository;


@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyCustomerService {

	private final CustomerRepository repository;
    private final Cache<Integer, CachedCurrencyCustomer> currencyCustomerCache;

    public Mono<Customer> getCustomer(Integer id){
	    log.info("getCurrencyCustomer. id:{}", id);
	    Mono<Customer> customer = null;

	    var cachedCurrencyCustomers =  currencyCustomerCache.get(id);
	    if (cachedCurrencyCustomers == null) {
		    customer = repository.findById(id);
		    log.info("Customer. id:{}", customer);
		    currencyCustomerCache.put( id, new CachedCurrencyCustomer(customer) );
	    } else {
		    customer = cachedCurrencyCustomers.getCurrencyCustomer();
	    }

    	return customer;
	}
}
