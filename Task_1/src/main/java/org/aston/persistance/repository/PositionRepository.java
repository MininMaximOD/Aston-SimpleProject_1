package org.aston.persistance.repository;

import org.aston.persistance.entity.PositionEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PositionRepository extends AbstractCRUDRepository<PositionEntity, Long>{
    protected PositionRepository() {
        super(PositionEntity.class);
    }


}
