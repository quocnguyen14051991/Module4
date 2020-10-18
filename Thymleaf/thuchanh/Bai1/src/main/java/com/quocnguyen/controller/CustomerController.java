package com.quocnguyen.controller;

import com.quocnguyen.model.Customer;
import com.quocnguyen.service.CustomerService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping({"", "/index"})
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList", customerList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }


    @PostMapping("/save")
    public String create(Model model, Customer customer, RedirectAttributes redirectAttributes) {
        customer.setId((int) (Math.random() * 10000));
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        customerService.delete(id);
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList", customerList);
        return "index";
    }

    @GetMapping("/update/{id}")
    public String viewUpdate(Model model,@PathVariable int id) {
     Customer customerEdit= customerService.findId(id);
        model.addAttribute(customerEdit);
        return "edit";
    }

    @PostMapping("/edit")
    public String customerEdit(Customer customer, RedirectAttributes redirect)
    {
        customerService.update(customer.getId(),customer);
        redirect.addFlashAttribute("success");
        return "redirect:/index";
    }
    @GetMapping("/view/{id}")
    public String view(Model model,@PathVariable int id){
        model.addAttribute("customer",customerService.findId(id));
        return "view";
    }

}
