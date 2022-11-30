package org.aston.controller.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.aston.persistance.entity.CustomerEntity;
import org.aston.service.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;

@RestController
@RequestMapping("/customers")
@Api(tags = {"Заказчики"})
public class CustomerRestController {

    @Autowired
    private Admin admin;

    @GetMapping
    @ApiOperation(value = "список всех заказчиков")
    public Collection<CustomerEntity> homeCustomerPage(Model model){
        Collection<CustomerEntity> allCustomers = admin.findAllCustomers();
        model.addAllAttributes(allCustomers);
        return allCustomers;}

    @PostMapping("/save")
    @ApiOperation(value = "добавить нового заказчика")
    public RedirectView save(@ModelAttribute("customerSave") CustomerEntity customerEntity) {
        admin.saveCustomer(customerEntity);
        return new RedirectView("customers");
    }

    @PostMapping("/delete")
    @ApiOperation(value = "удалить заказчика")
    public RedirectView delete(@ModelAttribute("customerDelete") CustomerEntity customerEntity){
        admin.deleteCustomer(customerEntity);
        return new RedirectView("customers");
    }

    @PostMapping("/update")
    @ApiOperation(value = "обновить информацию о заказчике")
    public RedirectView update(@ModelAttribute("customerUpdate") CustomerEntity customerEntity){
        admin.updateCustomer(customerEntity);
        return new RedirectView("customers");
    }
 }
