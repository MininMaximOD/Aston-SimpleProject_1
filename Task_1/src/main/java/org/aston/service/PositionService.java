package org.aston.service;

import org.aston.persistance.entity.PositionEntity;
import org.aston.persistance.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Transactional
    public void save(PositionEntity position){
        if (position == null){
            throw new IllegalArgumentException("Entity is null");
        }
        positionRepository.create(position);
    }

    @Transactional
    public void delete(PositionEntity position){
        positionRepository.delete(position);
    }

    @Transactional
    public void update(PositionEntity position){
        positionRepository.update(position);
    }

    @Transactional
    public Collection<PositionEntity> findAll(boolean withDependencies){
        return positionRepository.findAll();
    }
}
