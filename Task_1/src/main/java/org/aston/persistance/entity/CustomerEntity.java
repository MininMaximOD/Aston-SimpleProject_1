package org.aston.persistance.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity extends AbstractHumanEntity{

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private List<ProjectEntity> projects = new ArrayList<>();

    public void addProject(ProjectEntity project) {
        if(project == null) return;
        if(projects == null) projects = new ArrayList<>();
        projects.add(project);
    }

    public void removeProject(ProjectEntity project){
        if(project == null && projects == null) return;
        if(projects.contains(project)) projects.remove(project);
        project.removeCustomer();
    }
}
