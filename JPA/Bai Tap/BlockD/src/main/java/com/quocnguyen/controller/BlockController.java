package com.quocnguyen.controller;

import com.quocnguyen.entity.BlockA;
import com.quocnguyen.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlockController {
    @Autowired
    BlockService blockService;
    @GetMapping({"", "/listAll"})
    public String listAll(Model model){
       List<BlockA> blockList= blockService.findAll();
       model.addAttribute("blockList",blockList);
        return "main";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model){
        BlockA blockA=blockService.findById(id);
        blockService.remove(blockA);
        List<BlockA> blockList= blockService.findAll();
        model.addAttribute("blockList",blockList);
        return "main";
    }
    @GetMapping("/create")
    public String create(Model model){
        BlockA blockA =new BlockA();
        model.addAttribute(blockA);
        return "create";
    }
    @PostMapping("/createNew")
    public String createNew(@ModelAttribute BlockA blockA, RedirectAttributes redirectAttributes)
    {
        blockService.save(blockA);
        redirectAttributes.addFlashAttribute("add success","add ok");
       return  "redirect:/listAll";
    }

}
