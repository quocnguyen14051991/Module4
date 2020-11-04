package com.quocnguyen.controller;

import com.quocnguyen.entity.CategoryEntity;
import com.quocnguyen.entity.DigitalEntity;
import com.quocnguyen.service.CategoryService;
import com.quocnguyen.service.DigitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class DigitalController {
    @Autowired
    DigitalService digitalService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/digital")
    public String listDigital(Model model, @PageableDefault(size = 4) Pageable pageable) {
        Page<DigitalEntity> digitalPage = digitalService.findAll(pageable);
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("digitalPage", digitalPage);
        return "list_digital";
    }

    @GetMapping("/digital/{id}/delete")
    public String deleteDigital(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        DigitalEntity digital = digitalService.findById(id);
        digitalService.delete(digital);
        redirectAttributes.addFlashAttribute("message", "delete Success");
        return "redirect:/digital";
    }

    @GetMapping("/createDigital")
    public String createDigitalView(Model model) {
        DigitalEntity digital = new DigitalEntity();
        List<CategoryEntity> category = categoryService.findAll();
        model.addAttribute(digital);
        model.addAttribute("category", category);
        return "create_digital";
    }

    @PostMapping("/createDigital")
    public String crateDigital(Model model, @Validated @ModelAttribute DigitalEntity digital , RedirectAttributes redirectAttributes) {
        digitalService.save(digital);

        redirectAttributes.addFlashAttribute("message", "create Digital Success");
        return "redirect:/digital";
    }

    @GetMapping("/digital/{id}/edit")
    public String editDigital(Model model, @PathVariable Integer id) {
        DigitalEntity digital = digitalService.findById(id);
        List<CategoryEntity> category = categoryService.findAll();
        model.addAttribute("category", category);
        model.addAttribute(digital);
        return "edit_digital";
    }

    @PostMapping("/editDigital")
    public String editDigital(RedirectAttributes redirectAttributes, @ModelAttribute DigitalEntity digital) {
        digitalService.save(digital);
        redirectAttributes.addFlashAttribute("message", "edit success");
        return "redirect:/digital";
    }

    @GetMapping("/homePage")
    public String home(Model model, @PageableDefault(size = 4) Pageable pageable) {
        Page<DigitalEntity> digitalPage = digitalService.findAll(pageable);
        model.addAttribute("digitalPage",digitalPage);
        return "home";
    }

}
