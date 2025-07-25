package com.tallertornofumero.erp.erp.service;

import com.tallertornofumero.erp.erp.exception.CustomerAlreadyExistsException;
import com.tallertornofumero.erp.erp.exception.CustomerNotExistsException;
import com.tallertornofumero.erp.erp.exception.UsernameAlreadyExistsException;
import com.tallertornofumero.erp.erp.exception.UsernameNotExistsException;
import com.tallertornofumero.erp.erp.model.Customer;
import com.tallertornofumero.erp.erp.model.User;
import com.tallertornofumero.erp.erp.repository.CustomerRepository;
import com.tallertornofumero.erp.erp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerByNif(String nif){
        return customerRepository.findByNif(nif);
    }

    public Customer createCustomer(Customer customer){
        boolean exists = customerRepository.existsByNif(customer.getNif());
        if(exists){
            throw new CustomerAlreadyExistsException(customer.getNif());
        }
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(String nif, Customer customer){
        Customer customerDB = customerRepository.findByNif(nif);

        if(customerDB == null){
            throw new CustomerNotExistsException(customer.getNif());
        }


        customerDB.setAddress(customer.getAddress());
        customerDB.setNif(customer.getNif());
        customerDB.setName(customer.getName());
        customerDB.setEmail(customer.getEmail());
        customerDB.setPhoneNumber(customer.getPhoneNumber());
        customerDB.setLegalName(customer.getLegalName());
        customerDB.setStatus(customer.getStatus());

        return customerRepository.save(customerDB);
    }

    public void deleteCustomer(String nif){
        Customer customerDB = customerRepository.findByNif(nif);

        if(customerDB == null){
            throw new CustomerNotExistsException(nif);
        }

        customerRepository.delete(customerDB);
    }
}
