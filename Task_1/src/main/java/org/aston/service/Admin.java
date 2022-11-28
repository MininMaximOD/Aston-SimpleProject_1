package org.aston.service;


import lombok.NoArgsConstructor;
import org.aston.persistance.entity.CustomerEntity;
import org.aston.persistance.entity.EmployeeEntity;
import org.aston.persistance.entity.PositionEntity;
import org.aston.persistance.entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@NoArgsConstructor
@Component
public class Admin {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private ProjectService projectService;

    public Collection<EmployeeEntity> findAllEmployeesWithDependencies(){
        return employeeService.findAll(true);
    }

    public Collection<EmployeeEntity> findAllEmployees(){
        return employeeService.findAll(false);
    }

    public void createEmployee(EmployeeEntity employee){
        employeeService.create(employee);
    }
    public void updateEmployee(EmployeeEntity employee){
        employeeService.update(employee);
    }
    public void deleteEmployee(EmployeeEntity employee){
        employeeService.delete(employee);
    }

    public Collection<CustomerEntity> findAllCustomersWithDependencies(){
        return customerService.findAll(true);
    }

    public Collection<CustomerEntity> findAllCustomers(){
        return customerService.findAll(false);
    }

    public void createCustomer(CustomerEntity customer){
        customerService.create(customer);
    }
    public void updateCustomer(CustomerEntity customer){
        customerService.update(customer);
    }
    public void deleteCustomer(CustomerEntity customer){
        customerService.delete(customer);
    }

    public Collection<PositionEntity> findAllPositionsWithDependencies(){
        return positionService.findAll(true);
    }

    public Collection<PositionEntity> findAllPositions(){
        return positionService.findAll(false);
    }

    public void createPosition(PositionEntity position){
        positionService.create(position);
    }
    public void updatePosition(PositionEntity position){
        positionService.update(position);
    }
    public void deletePosition(PositionEntity position){
        positionService.delete(position);
    }

    public Collection<ProjectEntity> findAllProjectsWithDependencies(){
        return projectService.findAll(true);
    }

    public Collection<ProjectEntity> findAllProjects(){
        return projectService.findAll(false);
    }

    public void createProject(ProjectEntity project){
        projectService.create(project);
    }
    public void updateProject(ProjectEntity project){
        projectService.update(project);
    }
    public void deleteProject(ProjectEntity project){
        projectService.delete(project);
    }
}
