package ru.cbrrate.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.cbrrate.model.Customer;

public interface CustomerRepository extends ReactiveCrudRepository<Customer,Integer> {

}
