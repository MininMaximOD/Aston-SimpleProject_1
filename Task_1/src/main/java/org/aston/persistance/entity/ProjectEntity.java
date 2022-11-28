package org.aston.persistance.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "project")
public class ProjectEntity extends AbstractModifyEntity{

    @Column(name = "type")
    private String type;

    @Column(name = "deadline")
    private Instant dateline;

    @OneToOne(mappedBy = "project_full_info", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private ProjectInfo projectInfo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<EmployeeEntity> employees;

    public void setProjectInfo(ProjectInfo projectInfo){
        if(projectInfo == null){
            this.projectInfo = null;
        }
        projectInfo.setProject(this);
        this.projectInfo = projectInfo;
    }

    public void setCustomer(CustomerEntity customer){
        this.customer =customer;
    }

    public void removeCustomer(){
        customer = null;
    }

    public void addEmployee(EmployeeEntity employee){
        if(employee == null) return;
        if(employees == null) employees = new ArrayList<>();
        employees.add(employee);
        employee.addProject(this);
    }

    public void removeEmployee(EmployeeEntity employee){
        if(employee == null) return;
        if(employees.contains(employee)) employees.remove(employee);
        employee.removeProject(this);
    }




}
