package org.aston.persistance.repository;


public interface CRUDRepository<E, ID> {

    void create(E entity);

    E read(ID id);

    void update(E entity);

    void delete(E entity);



}
