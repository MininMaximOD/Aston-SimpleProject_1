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

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private PositionEntity position;

    @ManyToMany()
    @JoinTable(name = "employee_project",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<ProjectEntity> projects = new ArrayList<>();


    public void addProject(ProjectEntity project) {
        if(project == null) return;
        projects.add(project);
    }

    public void removeProject(ProjectEntity project) {
        if(project == null) return;
        if(projects.contains(project)) projects.remove(project);
    }

    public void setPosition(PositionEntity position){
        if(position == null) return;
        this.position = position;
    }

    public void removePosition(){
        position = null;
    }
}
