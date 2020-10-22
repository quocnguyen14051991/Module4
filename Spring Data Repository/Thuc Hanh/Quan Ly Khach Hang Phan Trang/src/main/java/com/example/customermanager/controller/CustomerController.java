package com.example.customermanager.controller;

import com.example.customermanager.entity.Customer;
import com.example.customermanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping({"", "/listCustomer"})
    public String listCustomer(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keywordOld = "";
        if (keyword.isPresent()) {
            keywordOld=keyword.get();
            model.addAttribute("listCustomer", customerService.findByNameContaining(pageable, keywordOld));
        }
        else {
            model.addAttribute("listCustomer", customerService.findAll(pageable));
        }
        model.addAttribute("keywordOld", keywordOld);

        return "list_customer";
    }
}
