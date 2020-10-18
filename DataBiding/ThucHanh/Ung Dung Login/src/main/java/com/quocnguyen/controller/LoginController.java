package com.quocnguyen.controller;

import com.quocnguyen.model.Login;
import com.quocnguyen.model.User;
import com.quocnguyen.repository.UserDAO;
import com.quocnguyen.service.CheckLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    CheckLogin checkLogin;

    @PostMapping("/login")
    public ModelAndView checkLogin(@ModelAttribute("login") Login login) {
        User user = checkLogin.checkLoginUser(login);
        if (user == null) {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("user");
            modelAndView.addObject("user", user);
            return modelAndView;
        }

    }
//    @GetMapping({"","/"})
//    public ModelAndView home(){
//        ModelAndView modelAndView = new ModelAndView("home","login",new Login());
//        return modelAndView;
//    }

    @GetMapping({"", "/"})
    public String home(Model model) {
        model.addAttribute("login", new Login("avc", "1234"));
        return "home";
    }
}
