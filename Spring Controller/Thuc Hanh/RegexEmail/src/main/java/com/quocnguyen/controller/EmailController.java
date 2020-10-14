package com.quocnguyen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public EmailController(){
        pattern=Pattern.compile(EMAIL_REGEX);
    }
    @GetMapping("")
    String getIndex(){
        return "index";
    }
    @PostMapping("/validate")
    String ValidateEmail(@RequestParam("email") String email, Model model)
    {
        String message;
        boolean isvalid = this.validate(email);
        if(!isvalid){
            message="Fail Format";

        }else {
            message="Success";
            model.addAttribute("email",email);
            return "success";
        }
        model.addAttribute("message",message);
        return "index";
    }
    private boolean validate(String regex){
        matcher =pattern.matcher(regex);
        return matcher.matches();
    }
}
