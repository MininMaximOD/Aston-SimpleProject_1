package org.aston.controller.rest;

import org.aston.persistance.entity.EmployeeEntity;
import org.aston.service.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private Admin admin;

    @RequestMapping(path="/employees")
    public String homeEmployeePage(Model model){
        Collection<EmployeeEntity> allEmployees = admin.findAllEmployees();
        model.addAllAttributes(allEmployees);
        return "employee_view";}

    @PostMapping("/employee/save")
    public RedirectView save(@ModelAttribute("employeeSave") EmployeeEntity employee) {
        admin.createEmployee(employee);
        return new RedirectView("employees");
    }

    @PostMapping("/employee/delete")
    public RedirectView delete(@ModelAttribute("employeeDelete") EmployeeEntity employee){
        admin.deleteEmployee(employee);
        return new RedirectView("employees");
    }

    @PostMapping("/employee/update")
    public RedirectView update(@ModelAttribute("employeeUpdate") EmployeeEntity employee){
        admin.updateEmployee(employee);
        return new RedirectView("employees");
    }
}
