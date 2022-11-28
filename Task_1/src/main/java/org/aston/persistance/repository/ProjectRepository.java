package org.aston.persistance.repository;

import org.aston.persistance.entity.ProjectEntity;

public class ProjectRepository extends AbstractCRUDRepository<ProjectEntity, Long> {
    protected ProjectRepository() {
        super(ProjectEntity.class);
    }
}
