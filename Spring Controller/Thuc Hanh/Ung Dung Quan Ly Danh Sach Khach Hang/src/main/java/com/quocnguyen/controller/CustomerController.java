package com.quocnguyen.controller;

import com.quocnguyen.model.Customer;
import com.quocnguyen.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
   @GetMapping("/{id}")
   public ModelAndView showInformation(@PathVariable Long id) {
       ModelAndView modelAndView = new ModelAndView("info");
       Customer customer =customerService.findOne(id);
       modelAndView.addObject("customer", customer);
       return modelAndView;
   }
    @GetMapping({"","/listCustomer"})
    public String showList(Model model) {
        List<Customer> listCus=customerService.showList();
        model.addAttribute("listCus",listCus);
        return "list";
    }

}
