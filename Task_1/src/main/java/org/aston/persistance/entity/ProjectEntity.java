package org.aston.persistance.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

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

    @OneToOne(mappedBy = "project_full_info")
    private ProjectInfo projectInfo;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;



}
