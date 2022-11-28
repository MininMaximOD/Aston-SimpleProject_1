package org.aston.persistance.repository;

import org.aston.persistance.entity.PositionEntity;

public class PositionRepository extends AbstractCRUDRepository<PositionEntity, Long>{
    protected PositionRepository() {
        super(PositionEntity.class);
    }
}
