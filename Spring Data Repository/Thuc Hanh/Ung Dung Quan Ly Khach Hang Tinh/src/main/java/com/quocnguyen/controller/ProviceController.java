package com.quocnguyen.controller;

import com.quocnguyen.entity.Provice;
import com.quocnguyen.service.ProviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.List;

@Controller
public class ProviceController {
    @Autowired
    ProviceService proviceService;

    @GetMapping({"", "/listProvice"})
    public String listProvice(Model model) {
        List<Provice> proviceList = proviceService.listAll();
        model.addAttribute("proviceList", proviceList);
        return "listprovice";
    }

    @GetMapping("/create")
    public String createProvinceView(Model model) {
        Provice provice = new Provice();
        model.addAttribute("provice", provice);
        return "createprovice";
    }

    @PostMapping("/createProvice")
    public String createProvince(@ModelAttribute Provice provice, Model model) {
        proviceService.save(provice);
        model.addAttribute("message", "create Success");
        model.addAttribute("provice",new Provice());
        return "createprovice";
    }
    @GetMapping("/delete/{id}")
    public String deleteProvince(@PathVariable Long id, RedirectAttributes redirectAttributes){
        Provice provice =proviceService.findById(id);
        proviceService.remove(provice);
        redirectAttributes.addFlashAttribute("message","delete Success");
        return "redirect:/listProvice";
    }
    @GetMapping("/edit/{id}")
    public String updateProvince(@PathVariable Long id, Model model){
        Provice provice =proviceService.findById(id);
        model.addAttribute("provice",provice);
        return "edit";
    }
    @PostMapping("/editProvice")
    public String updateProvince(@ModelAttribute Provice provice,RedirectAttributes redirectAttributes){
        proviceService.save(provice);
        redirectAttributes.addFlashAttribute("message","update Success");
        return "redirect:/listProvice";
    }
}
