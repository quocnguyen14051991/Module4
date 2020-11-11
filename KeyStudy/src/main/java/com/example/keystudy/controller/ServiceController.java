package com.example.keystudy.controller;

import com.example.keystudy.entity.service.RentType;
import com.example.keystudy.entity.service.ServiceFurama;
import com.example.keystudy.entity.service.ServiceType;
import com.example.keystudy.service.RentTypeService;
import com.example.keystudy.service.ServiceFuramaService;
import com.example.keystudy.service.ServiceTypeService;
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

@Controller
@RequestMapping("/services")
public class ServiceController {
    @Autowired
    ServiceFuramaService serviceFuramaService;
    @Autowired
    ServiceTypeService serviceTypeService;
    @Autowired
    RentTypeService rentTypeService;

    @GetMapping({"", "/listService"})
    public String listService(Model model, @PageableDefault(size = 5) Pageable pageable) {
        Page<ServiceFurama> services = this.serviceFuramaService.findAll(pageable);
        model.addAttribute("services", services);
        return "service";
    }

    @GetMapping("/create")
    public String createService(Model model) {
        ServiceFurama serviceFurama = new ServiceFurama();
        List<ServiceType> serviceTypes = this.serviceTypeService.findAll();
        List<RentType> rentTypes = this.rentTypeService.findAll();
        model.addAttribute("serviceFurama", serviceFurama);
        model.addAttribute("rentTypes", rentTypes);
        model.addAttribute("serviceTypes", serviceTypes);
        return "create-service";
    }

    @PostMapping("/createPost")
    public String CreateServicePost(RedirectAttributes redirectAttributes, @Valid @ModelAttribute ServiceFurama serviceFurama, BindingResult bindingResult,Model model) {
        new ServiceFurama().validate(serviceFurama,bindingResult);
        if(bindingResult.hasErrors()){
            List<ServiceType> serviceTypes = this.serviceTypeService.findAll();
            List<RentType> rentTypes = this.rentTypeService.findAll();
            model.addAttribute("rentTypes", rentTypes);
            model.addAttribute("serviceTypes", serviceTypes);
            return "create-service";
        }
        else {
            this.serviceFuramaService.save(serviceFurama);
            redirectAttributes.addFlashAttribute("create is ok", "message");
            return "redirect:/services/listService";
        }
    }
}
