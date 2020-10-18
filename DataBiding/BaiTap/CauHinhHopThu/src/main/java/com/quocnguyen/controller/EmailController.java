package com.quocnguyen.controller;

import com.quocnguyen.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @GetMapping({"", "/main"})
    public String emailSettings(ModelMap model) {
        model.addAttribute("email", new Email("Vietnamese",15,false,"quoc"));
        return "main";
    }

    @PostMapping("/edit")
    public String submit(@ModelAttribute("email") Email email, Model model) {
        model.addAttribute("language", email.getLanguage());
        model.addAttribute("pageSize", email.getPageSize());
        model.addAttribute("spams", email.getSpams());
        model.addAttribute("signature", email.getSignature());
        return "show";
    }
}
