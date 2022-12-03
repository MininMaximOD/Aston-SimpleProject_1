package org.aston.persistance.repository;
import org.aston.persistance.entity.AbstractModifyEntity;
import org.springframework.util.Assert;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Collection;

public abstract class AbstractCRUDRepository<E extends AbstractModifyEntity, ID extends Serializable> implements CRUDRepository<E, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<E> entityClass;

    protected AbstractCRUDRepository(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void create(E entity) {
        Assert.notNull(entity, "entity must be a set");
        entityManager.persist(entity);
    }

    @Override
    public E read(ID id){
        return entityManager.find(entityClass, id);
    }

    @Override
    public void update(E entity) {
        Assert.notNull(entity, "entity must be a set");
        entityManager.merge(entity);
    }

    @Override
    public void delete(E entity) {

    }

    public Collection<E> findAll(){
        return entityManager.createQuery("select * from " +  entityClass.getSimpleName(), entityClass).getResultList();
    }
}
