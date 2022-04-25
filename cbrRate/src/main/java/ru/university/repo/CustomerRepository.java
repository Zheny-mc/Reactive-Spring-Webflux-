package ru.university.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.university.model.Customer;

public interface CustomerRepository extends ReactiveCrudRepository<Customer,Integer> {

}
