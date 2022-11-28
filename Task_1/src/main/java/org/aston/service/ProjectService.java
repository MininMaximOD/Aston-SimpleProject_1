package org.aston.service;

import org.aston.persistance.entity.CustomerEntity;
import org.aston.persistance.entity.ProjectEntity;
import org.aston.persistance.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Transactional
    public void create(ProjectEntity project){
        if (project == null){
            throw new IllegalArgumentException("Entity is null");
        }
        projectRepository.create(project);
    }

    @Transactional
    public void delete(ProjectEntity project){
        projectRepository.delete(project);
    }

    @Transactional
    public void update(ProjectEntity project){
        projectRepository.update(project);
    }

    @Transactional
    public Collection<ProjectEntity> findAll(boolean withDependencies){
        if(withDependencies){
            final Collection<ProjectEntity> projects = projectRepository.findAllWithDependencies();
            projects.stream().forEach(s -> s.getProjectInfo());
            return projects;
        }else{
            return projectRepository.findAll();
        }
    }
}
