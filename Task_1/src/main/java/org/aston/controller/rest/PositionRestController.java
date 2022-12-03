package org.aston.controller.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.aston.persistance.entity.PositionEntity;
import org.aston.service.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;

@RestController
@RequestMapping("/positions")
@Api(tags = {"Должности"})
public class PositionRestController {

    @Autowired
    private Admin admin;

    @GetMapping
    @ApiOperation(value = "получить список всех должностей")
    public Collection<PositionEntity> homePositionPage(Model model){
        Collection<PositionEntity> allPositions = admin.findAllPositions();
        model.addAllAttributes(allPositions);
        return allPositions;}

    @PostMapping("/save")
    @ApiOperation(value = "добавить новую должность")
    public RedirectView save(@ModelAttribute("positionSave") PositionEntity position) {
        admin.savePosition(position);
        return new RedirectView("positions");
    }

    @PostMapping("/delete")
    @ApiOperation(value = "удалить должность")
    public RedirectView delete(@ModelAttribute("positionDelete") PositionEntity position){
        admin.deletePosition(position);
        return new RedirectView("positions");
    }

    @PostMapping("/update")
    @ApiOperation(value = "обновить информацию должности")
    public RedirectView update(@ModelAttribute("positionUpdate") PositionEntity position){
        admin.updatePosition(position);
        return new RedirectView("positions");
    }
}
