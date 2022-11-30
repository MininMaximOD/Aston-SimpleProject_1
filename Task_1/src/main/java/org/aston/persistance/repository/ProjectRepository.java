package org.aston.persistance.repository;

import org.aston.persistance.entity.ProjectEntity;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public class ProjectRepository extends AbstractCRUDRepository<ProjectEntity, Long> {

    protected ProjectRepository() {
        super(ProjectEntity.class);
    }

    public Collection<ProjectEntity> findAllWithDependencies() {
        return entityManager.createQuery(
                "select * from ProjectEntity p join fetch p.customer c",
                ProjectEntity.class).getResultList();
    }
}
