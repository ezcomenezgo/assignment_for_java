package com.example.wholesale_system;

import com.example.wholesale_system.customer.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTests {
    @Test
    public void testGetterSetterOfId() {
        Address address = new Address();
        address.setId(1);
        Integer exp = 1;
        Integer act = address.getId();

        assertEquals(exp, act);
    }

    @Test
    public void testGetterSetterOfAddressLine1() {
        Address address = new Address();
        address.setAddressLine1("test address line 1");
        String exp = "test address line 1";
        String act = address.getAddressLine1();

        assertEquals(exp, act);
    }

    @Test
    public void testGetterSetterOfAddressLine2() {
        Address address = new Address();
        address.setAddressLine2("test address line 2");
        String exp = "test address line 2";
        String act = address.getAddressLine2();

        assertEquals(exp, act);
    }

    @Test
    public void testGetterSetterOfAddressLine3() {
        Address address = new Address();
        address.setAddressLine3("test address line 3");
        String exp = "test address line 3";
        String act = address.getAddressLine3();

        assertEquals(exp, act);
    }

    @Test
    public void testGetterSetterOfPostcode() {
        Address address = new Address();
        address.setPostCode("test post code");
        String exp = "test post code";
        String act = address.getPostCode();

        assertEquals(exp, act);
    }

    @Test
    public void testGetterSetterOfCountry() {
        Address address = new Address();
        address.setCountry("test country");
        String exp = "test country";
        String act = address.getCountry();

        assertEquals(exp, act);
    }
}
