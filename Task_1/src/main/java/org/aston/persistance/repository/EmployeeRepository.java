package org.aston.persistance.repository;

import com.sun.xml.bind.v2.model.core.ID;
import org.aston.persistance.entity.AbstractModifyEntity;
import org.aston.persistance.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;

@Repository
public class EmployeeRepository extends AbstractCRUDRepository<EmployeeEntity, Long>{

    protected EmployeeRepository() {
        super(EmployeeEntity.class);
    }

}
