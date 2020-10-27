package com.quocnguyen.giohang.controller;

import com.quocnguyen.giohang.entity.Product;
import com.quocnguyen.giohang.model.Card;
import com.quocnguyen.giohang.service.ProductService;
import com.quocnguyen.giohang.service.impl.CardManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class CardController {
    @Autowired
    private CardManager cardManager;
    @Autowired
    private ProductService productService;

    @GetMapping("/cart")
    public String viewCart() {
        return "cart";
    }

    @PostMapping("/cart/add")
    public String add(HttpSession session, @RequestParam("id") Product product
            , @RequestParam(value = "qty", required = false, defaultValue = "1") int qty, RedirectAttributes redirectAttributes) {
        Card card = cardManager.getCard(session);
        card.addItem(product, qty);
        redirectAttributes.addFlashAttribute("mesage", "addSuccess");
        return "redirect:/cart";
    }

    @GetMapping("/cart/remove/{id}")
    public String remove(HttpSession session, @PathVariable("id") Integer id,RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        Card card = cardManager.getCard(session);
        card.removeItem(product);
        redirectAttributes.addFlashAttribute("mesage", "addSuccess");
        return "redirect:/cart";
    }

    @RequestMapping("/cart/update")
    public String update(HttpSession session, @RequestParam("id") Integer id
            , @RequestParam("qty") int qty,RedirectAttributes redirectAttributes) {
        Product product = this.productService.findById(id);
        Card card = cardManager.getCard(session);
        card.updateItem(product, qty);
        redirectAttributes.addFlashAttribute("mesage", "addSuccess");
        return "redirect:/cart";
    }
}
