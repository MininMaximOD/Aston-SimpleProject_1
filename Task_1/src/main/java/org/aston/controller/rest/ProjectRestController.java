package org.aston.controller.rest;

import org.aston.persistance.entity.ProjectEntity;
import org.aston.service.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;

@RestController
@RequestMapping("/projects")
public class ProjectRestController {

    @Autowired
    private Admin admin;

    @GetMapping
    public Collection<ProjectEntity> homeProjectPage(Model model){
        Collection<ProjectEntity> allProjects = admin.findAllProjects();
        model.addAllAttributes(allProjects);
        return allProjects;}

    @PostMapping("/save")
    public RedirectView save(@ModelAttribute("projectSave") ProjectEntity project) {
        admin.saveProject(project);
        return new RedirectView("projects");
    }

    @PostMapping("/delete")
    public RedirectView delete(@ModelAttribute("projectDelete") ProjectEntity project){
        admin.deleteProject(project);
        return new RedirectView("projects");
    }

    @PostMapping("/update")
    public RedirectView update(@ModelAttribute("projectUpdate") ProjectEntity project){
        admin.updateProject(project);
        return new RedirectView("projects");
    }
}
