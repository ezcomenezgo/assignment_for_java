// Student name: Jia-Wen Li  Student number: 23628542

package com.example.wholesale_system;

import com.example.wholesale_system.customer.Address;
import com.example.wholesale_system.customer.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTests {
    @Test
    public void testGetterSetterOfId() {
        Customer customer = new Customer();
        customer.setId(1);
        Integer exp = 1;
        Integer act = customer.getId();

        assertEquals(exp, act);
    }

    @Test
    public void testGetterSetterOfBusinessName() {
        Customer customer = new Customer();
        customer.setBusinessName("test business name");
        String exp = "test business name";
        String act = customer.getBusinessName();

        assertEquals(exp, act);
    }

    @Test
    public void testGetterSetterOfAddress() {
        Customer customer = new Customer();
        Address testAddress = new Address();
        customer.setAddress(testAddress);
        Address exp = testAddress;
        Address act = customer.getAddress();

        assertEquals(exp, act);
    }

    @Test
    public void testGetterSetterOfTelephoneNumber() {
        Customer customer = new Customer();
        customer.setTelephoneNumber("test telephone number");
        String exp = "test telephone number";
        String act = customer.getTelephoneNumber();

        assertEquals(exp, act);
    }
}
