package com.example.baitap.controller;

import com.example.baitap.entity.Sach;
import com.example.baitap.service.impl.SachImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SachController {
    @Autowired
    SachImplService sachImplService;

    @GetMapping({"", "/listSach"})
    public String listSach(Model model) {
        List<Sach> sachList = this.sachImplService.findAll();
        model.addAttribute("sachList", sachList);
        return "list_sach";
    }
    @GetMapping("/muonsach/{id}")
    public String muonsach(Model model){

        
    }
}
