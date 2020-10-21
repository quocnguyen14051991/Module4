package com.quocnguyen.controller;

import com.quocnguyen.entity.Comment;
import com.quocnguyen.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class Img {
    @Autowired
    CommentService commentService;
    @GetMapping({"","/home"})
    public String home(Model model){
        Comment comment=new Comment();
        model.addAttribute("comment",comment);
        List<Comment> commentList =this.commentService.listAll();
        model.addAttribute("commentList",commentList);
        return "home";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Comment comment, RedirectAttributes redirectAttributes)
    {
        this.commentService.createComment(comment);
        redirectAttributes.addFlashAttribute("create is ok","create ok");
        return "redirect:/home";
    }
//    @PostMapping("/set")
//    public String setLike(Model model){
//
//
//    }
}
