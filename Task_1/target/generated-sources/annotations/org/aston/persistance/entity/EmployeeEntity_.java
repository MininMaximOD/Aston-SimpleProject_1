package org.aston.persistance.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmployeeEntity.class)
public abstract class EmployeeEntity_ extends org.aston.persistance.entity.AbstractHumanEntity_ {

	public static volatile ListAttribute<EmployeeEntity, ProjectEntity> projects;
	public static volatile SingularAttribute<EmployeeEntity, PositionEntity> position;
	public static volatile SingularAttribute<EmployeeEntity, Double> salary;

	public static final String PROJECTS = "projects";
	public static final String POSITION = "position";
	public static final String SALARY = "salary";

}

