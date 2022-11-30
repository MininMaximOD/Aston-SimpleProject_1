package org.aston.persistance.repository;

import org.aston.persistance.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
@Repository
public class CustomerRepository extends AbstractCRUDRepository<CustomerEntity, Long>{

    protected CustomerRepository() {
        super(CustomerEntity.class);
    }
}
