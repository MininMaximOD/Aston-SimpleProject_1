package org.aston.persistance.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "project_full_info")
public class ProjectInfo extends AbstractModifyEntity{

    @Column
    private String projectInfo;

    @OneToOne
    @MapsId
    @JoinColumn(name = "project_id")
    private ProjectEntity project;
}
