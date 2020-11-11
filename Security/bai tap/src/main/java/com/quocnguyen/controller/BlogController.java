package com.quocnguyen.controller;


import com.quocnguyen.entity.CategoryEntity;
import com.quocnguyen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/listCategory")
    public String listCategory(Model model, @PageableDefault(size = 10) Pageable pageable) {
        model.addAttribute("categoryList", categoryService.findAll(pageable));
        return "list_category";
    }

    @GetMapping("/category/{id}/delete")
    public String deleteCategory(RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        CategoryEntity category = categoryService.findById(id);
        categoryService.delete(category);
        redirectAttributes.addFlashAttribute("message", "delete success");
        return "redirect:/listCategory";
    }

    @GetMapping("/category/create")
    public String createCategoryView(Model model) {
        CategoryEntity category = new CategoryEntity();
        model.addAttribute("category", category);
        return "create_category";
    }

    @PostMapping("/category/create")
    public String createCategory(RedirectAttributes redirectAttributes, @ModelAttribute CategoryEntity category) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("mesage", "create Success");
        return "redirect:/listCategory";
    }

    @GetMapping("/category/{id}/edit")
    public String editCategoryView(@PathVariable Integer id, Model model) {
        CategoryEntity category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "edit_category";
    }

    @PostMapping("/category/edit")
    public String editCategory(RedirectAttributes redirectAttributes, @ModelAttribute CategoryEntity category) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/listCategory";
    }

    @GetMapping("/category/search")
    public String searchNameCategory(Model model, @RequestParam("keyword") String keyword, @PageableDefault(size = 10) Pageable pageable) {
        Page<CategoryEntity> categoryList = categoryService.findByNameCategory(keyword, pageable);
        if (categoryList.isEmpty()) {
            model.addAttribute("message", "Name Not Found");
            model.addAttribute("categoryList", categoryService.findAll(pageable));
        } else {
            model.addAttribute("categoryList", categoryList);
            model.addAttribute("keyword", keyword);
        }
        return "list_category";
    }

}
