package com.quocnguyen.controller;

import com.quocnguyen.model.Product;
import com.quocnguyen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping({"", "/home"})
    public String home(Model model) {
        List<Product> productList = productService.listAll();
        model.addAttribute("productList", productList);
        return "home";
    }

    @GetMapping("/create")
    public String createView(Model model) {
        model.addAttribute("product", new Product());
        return "create_product";
    }

    @PostMapping("/save")
    public String createProduct(Model model, Product product, RedirectAttributes redirectAttributes) {
        product.setIdProduct((int) (Math.random() * 1000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "save success");
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, Model model) {
        productService.delete(id);
        List<Product> productList = productService.listAll();
        model.addAttribute("productList", productList);
        return "home";
    }

    @GetMapping("/update/{id}")
    public String updateView(Model model, @PathVariable int id) {
        Product productEdit = productService.findId(id);
        model.addAttribute(productEdit);
        return "edit";
    }

    @PostMapping("/edit")
    public String editProduct(Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getIdProduct(), product);
        redirectAttributes.addFlashAttribute("update success");
        return "redirect:/home";
    }

    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable int id) {
        model.addAttribute("product", productService.findId(id));
        return "view";
    }
}
