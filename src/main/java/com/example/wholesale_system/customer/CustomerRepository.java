// Student name: Jia-Wen Li  Student number: 23628542

package com.example.wholesale_system.customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO of customer
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
