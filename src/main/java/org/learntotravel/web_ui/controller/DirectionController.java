package org.learntotravel.web_ui.controller;

import org.learntotravel.web_ui.direction.Direction;
import org.learntotravel.web_ui.direction.SourceType;
import org.learntotravel.web_ui.repository.DirectionReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DirectionController {

    @Autowired
    @Qualifier("DirectionRepositoryList")
    DirectionReposiotry repository;

    @GetMapping("/direction/add")
    public String directionAdd(Model model) {
        model.addAttribute("direction", new Direction());
        addDefaultVariables(model);
        return "manageDirection";
    }

    @GetMapping("/direction/{id}/edit")
    public String directionEdit(@PathVariable(name = "id") int id, Model model) {
        Direction direction = repository.getDirection(id);

        if (direction == null) {
            return "404";
        }

        model.addAttribute("direction", direction);
        addDefaultVariables(model);
        return "manageDirection";
    }

    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @PostMapping(value = "/direction/save",  produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> directionSave(@RequestBody Direction direction, Model model) throws IOException {
        long id;
        if (direction.getId()>0){
            id = repository.updateDirection(direction);
        } else {
            id = repository.addDirection(direction);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("id", id);
        return response;
    }

    private void addDefaultVariables(Model model) {
        Map<String, String> sourceTypes = new HashMap<>();

        for (SourceType source : SourceType.values()) {
            sourceTypes.put(source.toString(), source.getName());
        }

        model.addAttribute("sourceTypes", sourceTypes);
    }
}
