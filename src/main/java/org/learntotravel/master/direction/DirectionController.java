package org.learntotravel.master.direction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DirectionController {

    @GetMapping("/direction")
    public String greetingForm(Model model) {
        model.addAttribute("direction", new Direction());
        return "direction";
    }

    @PostMapping("/direction")
    public String greetingSubmit(@ModelAttribute Direction direction) {
        return "result";
    }
}
