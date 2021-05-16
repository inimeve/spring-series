package com.example.accessingdatamongodb;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public static Customer from(CustomerEntity customerEntity) {
        Customer customer = new Customer(customerEntity.getFirstName(), customerEntity.getLastName());
        customer.setXmlValue(customerEntity.getXml());

        return customer;
    }

    public static List<Customer> from(List<CustomerEntity> customerEntityList) {
        return customerEntityList.stream()
                .map(entity -> from(entity))
                .collect(Collectors.toList());
    }

}
