package org.aston.service;

import org.aston.persistance.entity.CustomerEntity;
import org.aston.persistance.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public void save(CustomerEntity customer){
        if (customer == null){
            throw new IllegalArgumentException("Entity is null");
        }
        customerRepository.create(customer);
    }

    @Transactional
    public void delete(CustomerEntity customer){
        customerRepository.delete(customer);
    }

    @Transactional
    public void update(CustomerEntity customer){
        customerRepository.update(customer);
    }

    @Transactional
    public Collection<CustomerEntity> findAll(boolean withDependencies){
        if(withDependencies){
            final Collection<CustomerEntity> customers = customerRepository.findAll();
            customers.stream().forEach(s -> s.getProjects());
            return customers;
        }else {
            return customerRepository.findAll();
        }
    }
}
