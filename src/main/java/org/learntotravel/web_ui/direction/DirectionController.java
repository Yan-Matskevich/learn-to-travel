package org.learntotravel.web_ui.direction;

import org.learntotravel.web_ui.repository.DirectionReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DirectionController {

    @Autowired
    @Qualifier("DirectionRepositoryList")
    DirectionReposiotry reposiotry;

    @GetMapping("/direction/add")
    public String greetingForm(Model model) {
        model.addAttribute("direction", new Direction());
        return "direction";
    }

    @GetMapping("/direction/{id}/edit")
    public String greetingEdit(@PathVariable(name = "id") int id, Model model) {
        Direction direction = reposiotry.getDirection(id);
        model.addAttribute("direction", direction);
        return "edit";
    }

    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    @PostMapping(value = "/direction/save",  produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object>  greetingSubmit(@RequestBody Direction direction, Model model) throws IOException {
        long id;
        if (direction.getId()>0){
            id = reposiotry.updateDirection(direction);
        } else {
            id = reposiotry.addDirection(direction);
        }
        Map<String, Object> resposne = new HashMap<>();
        resposne.put("id", id);
        return resposne;
    }
}
