package org.aston.controller.rest;

import org.aston.persistance.entity.PositionEntity;
import org.aston.service.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class PositionRestController {

    @Autowired
    private Admin admin;

    @RequestMapping(path="/positions", produces = MediaType.APPLICATION_JSON_VALUE)
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
