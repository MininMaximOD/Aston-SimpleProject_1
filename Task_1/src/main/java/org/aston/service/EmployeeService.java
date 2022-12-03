package org.aston.service;

import org.aston.persistance.entity.EmployeeEntity;
import org.aston.persistance.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void save(EmployeeEntity employee){
        if (employee == null){
            throw new IllegalArgumentException("Entity is null");
        }
        employeeRepository.create(employee);
    }

    @Transactional
    public void delete(EmployeeEntity employee){
        employeeRepository.delete(employee);
    }

    @Transactional
    public void update(EmployeeEntity employee){
        employeeRepository.update(employee);
    }

    @Transactional
    public Collection<EmployeeEntity> findAll(boolean withDependencies){
        return employeeRepository.findAll();
    }
}
