package org.learntotravel.web_ui.controller;

import org.learntotravel.web_ui.direction.Direction;
import org.learntotravel.web_ui.direction.SourceType;
import org.learntotravel.web_ui.repository.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Controller
public class DirectionController {

    @Autowired
    DirectionRepository repository;

    @GetMapping("/direction/add")
    public String directionAdd(Model model) {
        model.addAttribute("direction", new Direction());
        addDefaultVariables(model);
        return "manageDirection";
    }

    @GetMapping("/direction/{id}/edit")
    public String directionEdit(@PathVariable(name = "id") String id, Model model) {
        Optional<Direction> foundDirection = repository.findById(UUID.fromString(id));

        if (foundDirection.get() == null) {
            return "404";
        }

        model.addAttribute("direction", foundDirection.get());
        addDefaultVariables(model);
        return "manageDirection";
    }

    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @PostMapping(value = "/direction/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> directionSave(@RequestBody Direction direction, Model model) throws IOException {
        UUID id = repository.save(direction).getId();
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
