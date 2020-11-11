package com.example.keystudy.controller;

import com.example.keystudy.entity.customer.Customer;
import com.example.keystudy.entity.customer.CustomerType;
import com.example.keystudy.service.CustomerService;
import com.example.keystudy.service.TypeCustomerService;
import com.example.keystudy.service.impl.CustomerTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TypeCustomerService typeCustomerService;

    @GetMapping({"", "/listCustomer"})
    public String listCustomer(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> text) {
        String keywordOld = "";
        if (text.isPresent()) {
            keywordOld = text.get();
            Page<Customer> customers = this.customerService.findByCusName(keywordOld, pageable);
            model.addAttribute("customers", customers);
        } else {
            Page<Customer> customers = this.customerService.findAll(pageable);
            model.addAttribute("customers", customers);
        }

        model.addAttribute("keywordOld", keywordOld);
        return "customer";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(RedirectAttributes redirectAttributes, @PathVariable String id) {
        Customer customer = this.customerService.findById(id);
        this.customerService.delete(customer);
        redirectAttributes.addFlashAttribute("message", "delete is ok");
        return "redirect:/customers/listCustomer";
    }

    @GetMapping("/create")
    public String createCustomer(Model model) {
        List<CustomerType> customerTypes = this.typeCustomerService.findAll();
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        model.addAttribute("customerTypes", customerTypes);
        return "create-customer";
    }

    @PostMapping("/create")
    public String createCustomerPost(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            List<CustomerType> customerTypes = this.typeCustomerService.findAll();
            model.addAttribute("customerTypes", customerTypes);
            return "create-customer";
        }else
        {
            this.customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "create Customer Success");
            return "redirect:/customers/listCustomer";
        }
    }

    @GetMapping("/edit/{id}")
    public String editCustomer(Model model, @PathVariable String id) {
        String gender;
        Customer customer = this.customerService.findById(id);
        model.addAttribute("customer", customer);
        List<CustomerType> customerTypes = this.typeCustomerService.findAll();
        model.addAttribute("customerTypes", customerTypes);
        return "edit-customer";
    }

    @PostMapping("/edit")
    public String editCustomerPost(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes, @RequestParam CustomerType typeCustomer) {
        customer.setCustomerType(typeCustomer);
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "edit success");
        return "redirect:/customers/listCustomer";
    }

//    @GetMapping("/searchByName")
//    public String searchByName(@RequestParam Optional<String> text, Model model, @PageableDefault(size = 5) Pageable pageable) {
//        String keywordOld = "";
//        if (text.isPresent()) {
//            keywordOld = text.get();
//            Page<Customer> customers = this.customerService.findByCusName(keywordOld, pageable);
//            model.addAttribute("customers", customers);
//        }
//        model.addAttribute("keywordOld", keywordOld);
//
//        return "customer";
//    }
}
