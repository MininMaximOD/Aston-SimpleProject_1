package org.aston.persistance.repository;

import org.aston.persistance.entity.CustomerEntity;

public class CustomerRepository extends AbstractCRUDRepository<CustomerEntity, Long>{

    protected CustomerRepository() {
        super(CustomerEntity.class);
    }
}
