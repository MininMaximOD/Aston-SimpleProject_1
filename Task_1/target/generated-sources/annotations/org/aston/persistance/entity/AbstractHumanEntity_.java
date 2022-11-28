package org.aston.persistance.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AbstractHumanEntity.class)
public abstract class AbstractHumanEntity_ extends org.aston.persistance.entity.AbstractModifyEntity_ {

	public static volatile SingularAttribute<AbstractHumanEntity, String> firstName;
	public static volatile SingularAttribute<AbstractHumanEntity, String> lastName;
	public static volatile SingularAttribute<AbstractHumanEntity, String> contactPhone;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String CONTACT_PHONE = "contactPhone";

}

