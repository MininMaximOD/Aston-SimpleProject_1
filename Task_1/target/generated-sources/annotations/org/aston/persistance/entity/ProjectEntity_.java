package org.aston.persistance.entity;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProjectEntity.class)
public abstract class ProjectEntity_ extends org.aston.persistance.entity.AbstractModifyEntity_ {

	public static volatile SingularAttribute<ProjectEntity, ProjectInfo> projectInfo;
	public static volatile SingularAttribute<ProjectEntity, Instant> dateline;
	public static volatile SingularAttribute<ProjectEntity, String> type;
	public static volatile ListAttribute<ProjectEntity, EmployeeEntity> employees;
	public static volatile SingularAttribute<ProjectEntity, CustomerEntity> customer;

	public static final String PROJECT_INFO = "projectInfo";
	public static final String DATELINE = "dateline";
	public static final String TYPE = "type";
	public static final String EMPLOYEES = "employees";
	public static final String CUSTOMER = "customer";

}

