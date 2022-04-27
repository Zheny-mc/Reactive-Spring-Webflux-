package ru.university.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.server.Http2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.university.model.Customer;
import ru.university.repo.CustomerRepository;
import ru.university.services.CurrencyCustomerService;

import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CurrencyRateController {

	public final CurrencyCustomerService currencyCustomerService;
	private final CustomerRepository repository;

	@GetMapping
	public Flux<Customer> getCustomers(){
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Mono<Customer> getCustomer(@PathVariable Integer id){
		return currencyCustomerService.getCustomer(id);
	}

	@PostMapping
	public Mono<Customer> createCustomer(@RequestBody Customer customer){
		return  repository.save(customer);
	}

	@PutMapping("/{id}")
	public Mono<Customer> updateCustomer(@RequestBody String name, @PathVariable Integer id){
		return repository.findById(id)
				.map((c) -> {
					c.setName(name);
					return c;
				}).flatMap( c -> repository.save(c));
	}

	@DeleteMapping("/{id}")
	public Mono<Void> deleteCustomer(@PathVariable Integer id){
		log.info("delete customer id: {}", id);
		return repository.findById(id)
				.map(c -> {
					log.info("name: {}", c.getName());
					return c;
				}).flatMap(c -> repository.deleteById(c.getId()));
	}

}