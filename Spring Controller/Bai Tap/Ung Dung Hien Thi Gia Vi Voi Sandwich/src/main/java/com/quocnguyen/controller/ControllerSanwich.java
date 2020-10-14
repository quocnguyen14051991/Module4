package com.quocnguyen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerSanwich {
    @PostMapping({"/sanwich"})
    public String checkSandwich(@RequestParam String[] nameA, Model model) {
        List<String> arrList =new ArrayList<>();
        for (int i = 0; i <nameA.length ; i++) {
            arrList.add(nameA[i]);
        }
        model.addAttribute("arrList",arrList);
        return "list";
    }
    @GetMapping({"","/main"})
    public String main(){
        return "main";
    }
}
