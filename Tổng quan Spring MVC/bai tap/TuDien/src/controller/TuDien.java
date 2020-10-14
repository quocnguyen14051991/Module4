package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.FindWord;

@Controller
public class TuDien {
    @Autowired
    private FindWord findWord;

    @GetMapping({"", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("/find")
    public String findWord(@RequestParam String a, Model model) {
        String world = findWord.findw(a);
        model.addAttribute("world", world);
        return "find";
    }
}
