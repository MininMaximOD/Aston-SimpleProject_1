package org.aston.persistance.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.aston.persistance.entity.enums.Departments;
import org.aston.persistance.entity.enums.SkillLevel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PositionEntity.class)
public abstract class PositionEntity_ extends org.aston.persistance.entity.AbstractModifyEntity_ {

	public static volatile SingularAttribute<PositionEntity, String> namePosition;
	public static volatile SingularAttribute<PositionEntity, Departments> department;
	public static volatile SingularAttribute<PositionEntity, SkillLevel> skillLevel;

	public static final String NAME_POSITION = "namePosition";
	public static final String DEPARTMENT = "department";
	public static final String SKILL_LEVEL = "skillLevel";

}

