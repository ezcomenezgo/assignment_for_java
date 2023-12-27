// Student name: Jia-Wen Li  Student number: 23628542

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

    /**
     * get all customers
     *
     * @return: use customer's DAO to find all customer
     */
    public Iterable<Customer> getCustomerList() {
        return customerRepository.findAll();
    }

    /**
     * save customer
     *
     * @param customer: the customer to save after adding/updating
     */
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    /**
     * Find customer by id
     *
     * @param id: the specific customer id to find
     * @return: the customer after find by id
     */
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

    /**
     * delete the customer
     *
     * @param id: the specific food product id to delete
     */
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
