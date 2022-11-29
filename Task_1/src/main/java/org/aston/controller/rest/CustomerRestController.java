package org.aston.controller.rest;

import org.aston.persistance.entity.CustomerEntity;
import org.aston.service.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private Admin admin;

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
