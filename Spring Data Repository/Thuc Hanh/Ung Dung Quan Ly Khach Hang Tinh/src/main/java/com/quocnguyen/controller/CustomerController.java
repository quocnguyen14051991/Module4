package com.quocnguyen.controller;

import com.quocnguyen.entity.Customer;
import com.quocnguyen.entity.Provice;
import com.quocnguyen.service.CustomerService;
import com.quocnguyen.service.ProviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    ProviceService proviceService;

    @GetMapping("/listCustomer")
    public String listCustomer(Model model) {
        List<Customer> customerList = customerService.listAll();
        model.addAttribute("customerList", customerList);
        return "listcustomer";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(RedirectAttributes redirectAttributes, @PathVariable Long id) {
        Customer customer = customerService.findById(id);
        customerService.remove(customer);
        redirectAttributes.addFlashAttribute("delete success", "delete Success");
        return "redirect:/listCustomer";
    }

    @GetMapping("/editCustomer/{id}")
    public String editCustomerView(Model model, @PathVariable Long id) {
        Customer customer = customerService.findById(id);
        List<Provice> proviceList=proviceService.listAll();
        model.addAttribute("customer", customer);
        model.addAttribute("proviceList",proviceList);
        return "editCustomer";
    }
    @PostMapping("/editCustomer")
    public String editCustomer(Model model, RedirectAttributes redirectAttributes, @ModelAttribute Customer customer){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","update success");
        return "redirect:/listCustomer";
    }
    @GetMapping("/createCustomer")
    public String createCustomerView(Model model){
        Customer customer=new Customer();
        List<Provice> proviceList=proviceService.listAll();
        model.addAttribute("customer",customer);
        model.addAttribute("proviceList",proviceList);
        return "createcustomer";
    }
    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute Customer customer,RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","create success");
        return "redirect:/listCustomer";
    }

}
