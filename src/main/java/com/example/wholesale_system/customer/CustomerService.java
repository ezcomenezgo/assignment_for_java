package com.example.wholesale_system.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * service of customer
 */
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Iterable<Customer> getCustomerList(String keyword) {
        if (keyword != null) System.out.println(keyword);

        return customerRepository.findAll();
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer findCustomerById(Integer id) {
        Customer customer = null;
        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isPresent()) {
            customer = optional.get();
        } else {
            throw new RuntimeException(
                    "Customer is not found for id: " + id
            );
        }

        return customer;
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
