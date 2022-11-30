package org.aston.controller.rest;

import org.aston.persistance.entity.EmployeeEntity;
import org.aston.service.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    @Autowired
    private Admin admin;

    @GetMapping
    public Collection<EmployeeEntity> homeEmployeePage(Model model){
        Collection<EmployeeEntity> allEmployees = admin.findAllEmployees();
        model.addAllAttributes(allEmployees);
        return allEmployees;}

    @PostMapping("/save")
    public RedirectView save(@ModelAttribute("employeeSave") EmployeeEntity employee) {
        admin.saveEmployee(employee);
        return new RedirectView("employees");
    }

    @PostMapping("/delete")
    public RedirectView delete(@ModelAttribute("employeeDelete") EmployeeEntity employee){
        admin.deleteEmployee(employee);
        return new RedirectView("employees");
    }

    @PostMapping("/update")
    public RedirectView update(@ModelAttribute("employeeUpdate") EmployeeEntity employee){
        admin.updateEmployee(employee);
        return new RedirectView("employees");
    }
}
