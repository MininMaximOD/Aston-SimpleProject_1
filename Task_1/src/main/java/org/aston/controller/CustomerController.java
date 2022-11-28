package org.aston.controller;

import org.aston.controller.dto.CustomerDto;
import org.aston.persistance.entity.CustomerEntity;
import org.aston.service.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;

@Controller
public class CustomerController {

    private final Admin admin;

    public CustomerController(Admin admin) {
        this.admin = admin;
    }

    @GetMapping(path="/customers")
    public String homeCustomerPage(Model model){
        Collection<CustomerEntity> allCustomers = admin.findAllCustomers();
        model.addAllAttributes(allCustomers);
        return "customer_view";}

    @PostMapping("/customer/save")
    public RedirectView save(@ModelAttribute("customerSave") CustomerEntity customerEntity) {
        admin.createCustomer(customerEntity);
        return new RedirectView("customers");
    }

    @PostMapping("/customer/delete")
    public RedirectView delete(@ModelAttribute("customerDelete") CustomerEntity customerEntity){
        admin.deleteCustomer(customerEntity);
        return new RedirectView("customers");
    }

    @PostMapping("/customer/update")
    public RedirectView update(@ModelAttribute("customerUpdate") CustomerEntity customerEntity){
        admin.updateCustomer(customerEntity);
        return new RedirectView("customers");
    }
}
