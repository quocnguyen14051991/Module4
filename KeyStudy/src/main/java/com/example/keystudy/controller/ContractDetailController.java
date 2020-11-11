package com.example.keystudy.controller;

import com.example.keystudy.entity.contract.AttachService;
import com.example.keystudy.entity.contract.Contract;
import com.example.keystudy.entity.contract.ContractDetail;
import com.example.keystudy.service.AttachFuramaService;
import com.example.keystudy.service.ContractDetailService;
import com.example.keystudy.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contractsDetails")
public class ContractDetailController {
    @Autowired
    ContractDetailService contractDetailService;
    @Autowired
    ContractService contractService;
    @Autowired
    AttachFuramaService attachFuramaService;

    @GetMapping({"", "/listContractDetail"})
    public String listContractDetail(Model model) {
        List<ContractDetail> contractDetails = this.contractDetailService.findAll();
        model.addAttribute("contractDetails", contractDetails);
        return "contract-detail";
    }

    @GetMapping("/create")
    public String createContractDetail(Model model) {
        ContractDetail contractDetail = new ContractDetail();
        List<AttachService> attachServices = this.attachFuramaService.findAll();
        List<Contract> contracts = this.contractService.findAll();
        model.addAttribute("contractDetail", contractDetail);
        model.addAttribute("attachServices", attachServices);
        model.addAttribute("contracts", contracts);
        return "create-contract-detail";
    }

    @PostMapping("/create")
    public String createContractDetail(@ModelAttribute ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        this.contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message", "create is ok");
        return "redirect:/contractsDetails/listContractDetail";
    }
}
