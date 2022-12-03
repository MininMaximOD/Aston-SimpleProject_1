package org.aston.persistance.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aston.persistance.entity.enums.Departments;
import org.aston.persistance.entity.enums.SkillLevel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "position")
public class PositionEntity extends AbstractModifyEntity {

    @Column(name = "department")
    private Departments department;

    @Column(name = "name")
    private String namePosition;

    @Column(name = "skill_level")
    private SkillLevel skillLevel;
}
