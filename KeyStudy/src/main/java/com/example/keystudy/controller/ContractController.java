package com.example.keystudy.controller;

import com.example.keystudy.entity.contract.Contract;
import com.example.keystudy.entity.customer.Customer;
import com.example.keystudy.entity.employee.Employee;
import com.example.keystudy.entity.service.ServiceFurama;
import com.example.keystudy.service.ContractService;
import com.example.keystudy.service.CustomerService;
import com.example.keystudy.service.EmployeeService;
import com.example.keystudy.service.ServiceFuramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    ContractService contractService;
    @Autowired
    CustomerService customerService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ServiceFuramaService serviceFuramaService;

    @GetMapping({"", "/listContract"})
    public String listContract(@PageableDefault(size = 5) Pageable pageable, Model model) {
        Page<Contract> contracts = this.contractService.findAll(pageable);
        model.addAttribute("contracts", contracts);
        return "contract";
    }

    @GetMapping("/create")
    public String createContract(Model model) {
        Contract contract = new Contract();
        List<Customer> customers = this.customerService.findAll();
        List<Employee> employees = this.employeeService.findAll();
        List<ServiceFurama> serviceFuramas = this.serviceFuramaService.findAll();
        model.addAttribute("contract", contract);
        model.addAttribute("customers", customers);
        model.addAttribute("employees", employees);
        model.addAttribute("serviceFuramas", serviceFuramas);
        return "create-contract";
    }
    @PostMapping("/create")
    public String createContract(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes)
    {
        this.contractService.save(contract);
        redirectAttributes.addFlashAttribute("message","create ok");
        return "redirect:/contracts/listContract";
    }
}
