package com.quocnguyen.giohang.controller;

import com.quocnguyen.giohang.entity.Product;
import com.quocnguyen.giohang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping({"", "/product"})
    public String listProduct(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "list_all_product";
    }

    @GetMapping("/detail/{id}")
    public String detailProduct(Model model, @PathVariable Integer id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "detail_product";
    }
    @RequestMapping("/card")
    public String cart(){
        return "cart";
    }
    @GetMapping("/checklogin")
    public String checkLogin(Model model){

        return "login";
    }
}
