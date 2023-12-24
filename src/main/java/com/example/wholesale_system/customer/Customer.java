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

    public void setAddress(
            String addressLine1,
            String addressLine2,
            String addressLine3,
            String postCode,
            String country
    ) {
        Address newAddress = new Address();
        newAddress.setAddressLine1(addressLine1);
        newAddress.setAddressLine2(addressLine2);
        newAddress.setAddressLine3(addressLine3);
        newAddress.setPostCode(postCode);
        newAddress.setCountry(country);

        this.address = newAddress;
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
