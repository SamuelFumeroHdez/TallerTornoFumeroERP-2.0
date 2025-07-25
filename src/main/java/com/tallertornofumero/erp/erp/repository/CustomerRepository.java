package com.tallertornofumero.erp.erp.repository;

import com.tallertornofumero.erp.erp.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    boolean existsByNif(String nif);
    Customer findByNif(String nif);
}
