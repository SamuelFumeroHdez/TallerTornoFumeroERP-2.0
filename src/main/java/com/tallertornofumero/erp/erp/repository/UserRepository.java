package com.tallertornofumero.erp.erp.repository;

import com.tallertornofumero.erp.erp.model.Customer;
import com.tallertornofumero.erp.erp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByUserName(String userName);
    User findByUserName(String userName);
}
