package org.aston.controller;

import org.aston.persistance.entity.EmployeeEntity;
import org.aston.service.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;

@Controller
public class EmployeeController {

    private final Admin admin;

    public EmployeeController(Admin admin) {
        this.admin = admin;
    }

    @RequestMapping(path="/employees")
    public String homeEmployeePage(Model model){
        Collection<EmployeeEntity> allEmployees = admin.findAllEmployees();
        model.addAllAttributes(allEmployees);
        return "employee_view";}

    @PostMapping("/employee/save")
    public RedirectView save(@ModelAttribute("employeeSave") EmployeeEntity employee) {
        admin.saveEmployee(employee);
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
