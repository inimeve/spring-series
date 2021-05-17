package com.example.accessingdatamongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {

    public CustomerEntity findByFirstName(String firstName);
    public List<CustomerEntity> findByLastName(String lastName);

}