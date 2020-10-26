package com.quocnguyen.controller;

import com.quocnguyen.entity.UserRegex;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Controller
public class UserController {
    @GetMapping({"", "/registerUser"})
    public String registerView(Model model) {
        UserRegex userRegex = new UserRegex();
        model.addAttribute("userReg", userRegex);
        return "index";
    }

    @PostMapping("/checkRegex")
    public String register(@Valid @ModelAttribute("userReg") UserRegex userRegex, BindingResult bindingResult, Model model) {
        new UserRegex().validate(userRegex, bindingResult);
        if (bindingResult.hasErrors())
        {
            return "index";
        }
        else {
            String firstName=userRegex.getFirstsNameUser();
            model.addAttribute("firstName",firstName);
            return "result";
        }
    }
}
