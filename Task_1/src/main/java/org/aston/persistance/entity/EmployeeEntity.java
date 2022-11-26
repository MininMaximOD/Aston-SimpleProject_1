package org.aston.persistance.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity extends AbstractHumanEntity{

    @Column(name = "salary")
    private double salary;

    @ManyToOne()
    @JoinColumn(name = "position_id")
    private PositionEntity position;

    @ManyToMany
    @JoinTable(name = "employee_project",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<ProjectEntity> projects = new ArrayList<>();
}
