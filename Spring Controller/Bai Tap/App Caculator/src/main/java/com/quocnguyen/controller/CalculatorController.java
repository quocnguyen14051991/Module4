package com.quocnguyen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CalculatorController {
    @PostMapping("/calculator")
    public String cal(@RequestParam String num1, String num2, @RequestParam String[] a, Model model) {
        String result = "";
        int A = Integer.parseInt(num1);
        int B = Integer.parseInt(num2);
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals("Addition(+)")) {
                result = String.valueOf(A + B);
            } else if (a[i].equals("Addition(-)")) {
                result = String.valueOf(A - B);
            } else if (a[i].equals("Addition(X)")) {
                result = String.valueOf(A * B);
            } else {
                result = String.valueOf(A / B);
            }
        }
        model.addAttribute("result", result);
        model.addAttribute("A", A);
        model.addAttribute("B", B);
        return "main";
    }
    @GetMapping({"","/"})
    public String main(){
        return "main";
    }
}
