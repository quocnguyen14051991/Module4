package com.quocnguyen.controller;

import com.quocnguyen.entity.Customer;
import com.quocnguyen.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping({"", "/home"})
    public String listHome(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList", customerList);
        return "home";
    }

    @GetMapping("/create")
    public String createView(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create";
    }

    @PostMapping("/createNew")
    public String save(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("add success", "create Success");
        return "redirect:/home";
    }

    @GetMapping("edit/{id}")
    public String editView(Model model, @PathVariable int id) {
        Customer customerEdit = this.customerService.findById(id);
        model.addAttribute("customerEdit", customerEdit);
        return "edit";
    }

    @PostMapping("/editCustomer")
    public String edit(RedirectAttributes redirectAttributes, @ModelAttribute Customer customer) {
        this.customerService.edit(customer);
        redirectAttributes.addFlashAttribute("update Success", "update Success");
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id, RedirectAttributes redirectAttributes) {
        Customer customer = this.customerService.findById(id);
        this.customerService.delete(customer);
        redirectAttributes.addFlashAttribute("delete success", "delete ok");
        return "redirect:/home";
    }

    @GetMapping("view/{id}")
    public String view(Model model, @PathVariable int id) {
        model.addAttribute("customer", this.customerService.findById(id));
        return "view";
    }

}
