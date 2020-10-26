package com.quocnguyen.controller;

import com.quocnguyen.entity.Phone;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping({"", "/phone"})
    public String customValid(Model model) {
        Phone phone =new Phone();
        model.addAttribute("phoneNumber",phone);
        return "index";
    }

    @PostMapping("/checkRegex")
    public String checkValidate(@Valid @ModelAttribute("phoneNumber") Phone phone, BindingResult bindingResult, Model model) {
        new Phone().validate(phone, bindingResult);
        if(bindingResult.hasErrors()){
            return "index";
        }
        else {
                 model.addAttribute("phoneNumber",phone.getNumber());
                 return "result";
        }
    }
}
