package org.aston.controller;

import org.aston.persistance.entity.ProjectEntity;
import org.aston.service.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;

@Controller
public class ProjectController {

    private final Admin admin;

    public ProjectController(Admin admin) {
        this.admin = admin;
    }

    @RequestMapping(path="/projects")
    public String homeProjectPage(Model model){
        Collection<ProjectEntity> allProjects = admin.findAllProjects();
        model.addAllAttributes(allProjects);
        return "project_view";}

    @PostMapping("/project/save")
    public RedirectView save(@ModelAttribute("projectSave") ProjectEntity project) {
        admin.saveProject(project);
        return new RedirectView("projects");
    }

    @PostMapping("/project/delete")
    public RedirectView delete(@ModelAttribute("projectDelete") ProjectEntity project){
        admin.deleteProject(project);
        return new RedirectView("projects");
    }

    @PostMapping("/project/update")
    public RedirectView update(@ModelAttribute("projectUpdate") ProjectEntity project){
        admin.updateProject(project);
        return new RedirectView("projects");
    }
}
