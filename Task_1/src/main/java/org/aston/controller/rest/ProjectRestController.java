package org.aston.controller.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.aston.persistance.entity.ProjectEntity;
import org.aston.service.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;

@RestController
@RequestMapping("/projects")
@Api(tags = {"Заказы"})
public class ProjectRestController {

    @Autowired
    private Admin admin;

    @GetMapping
    @ApiOperation(value = "получить список всех заказов")
    public Collection<ProjectEntity> homeProjectPage(Model model){
        Collection<ProjectEntity> allProjects = admin.findAllProjects();
        model.addAllAttributes(allProjects);
        return allProjects;}

    @PostMapping("/save")
    @ApiOperation(value = "добавить новый заказ")
    public RedirectView save(@ModelAttribute("projectSave") ProjectEntity project) {
        admin.saveProject(project);
        return new RedirectView("projects");
    }

    @PostMapping("/delete")
    @ApiOperation(value = "удалить заказ")
    public RedirectView delete(@ModelAttribute("projectDelete") ProjectEntity project){
        admin.deleteProject(project);
        return new RedirectView("projects");
    }

    @PostMapping("/update")
    @ApiOperation(value = "обновить информацию о заказе")
    public RedirectView update(@ModelAttribute("projectUpdate") ProjectEntity project){
        admin.updateProject(project);
        return new RedirectView("projects");
    }
}
