package com.example.demo.controller;

import com.example.demo.entity.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("mycounter")
public class CountController {
    @ModelAttribute("mycounter")
    public MyCounter setUpCounter() {
        return new MyCounter();
    }
    @GetMapping("/view")
    public String get(@ModelAttribute("mycounter") MyCounter myCounter){
        myCounter.increment();
        return "index";
    }
}
