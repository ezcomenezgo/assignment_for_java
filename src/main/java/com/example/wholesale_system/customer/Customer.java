// Student name: Jia-Wen Li  Student number: 23628542

package com.example.wholesale_system.customer;

import jakarta.persistence.*;

/**
 * class of customer
 * the properties contain id, businessName, address, telephoneNumber
 * also there are setter and getter of properties
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String businessName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    private String telephoneNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * Override toString() to print customer
     *
     * @return: information of customer in string
     */
    @Override
    public String toString() {
        return "Customer={id=" + id +
                ", business name='" + businessName +
                "', address='" + address.getAddressLine1() + " " + address.getAddressLine2() + " " + address.getAddressLine3() + " " + address.getPostCode() + " " + address.getCountry() +
                "', telephone number='" + telephoneNumber + "'}";
    }
}
