package org.learntotravel.web_ui.direction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
public class DirectionController {

    @GetMapping("/direction/add")
    public String greetingForm(Model model) {
        model.addAttribute("direction", new Direction());
        return "direction";
    }

    @PostMapping("/direction/save")
    public String greetingSubmit(@RequestBody Map<String, Object> payload) {
        return "result";
    }
}
