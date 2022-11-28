package org.aston.controller;

import org.aston.persistance.entity.CustomerEntity;
import org.aston.persistance.entity.PositionEntity;
import org.aston.service.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;

@Controller
public class PositionController {

    private final Admin admin;

    public PositionController(Admin admin) {
        this.admin = admin;
    }

    @RequestMapping(path="/positions")
    public String homePositionPage(Model model){
        Collection<PositionEntity> allPositions = admin.findAllPositions();
        model.addAllAttributes(allPositions);
        return "position_view";}

    @PostMapping("/position/save")
    public RedirectView save(@ModelAttribute("positionSave") PositionEntity position) {
        admin.createPosition(position);
        return new RedirectView("positions");
    }

    @PostMapping("/position/delete")
    public RedirectView delete(@ModelAttribute("positionDelete") PositionEntity position){
        admin.deletePosition(position);
        return new RedirectView("positions");
    }

    @PostMapping("/position/update")
    public RedirectView update(@ModelAttribute("positionUpdate") PositionEntity position){
        admin.updatePosition(position);
        return new RedirectView("positions");
    }
}
