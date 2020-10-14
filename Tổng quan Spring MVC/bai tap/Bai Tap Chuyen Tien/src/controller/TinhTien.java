package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.Sum;

@Controller
public class TinhTien {
@Autowired
Sum sum;

    @GetMapping({"/", "/abc"})

    public String GoHome() {
        return "home";
    }

    @GetMapping({"/sum"})
    public String Tinh(@RequestParam String a, Model model) {
        double result = sum.sum(Double.parseDouble(a));
        model.addAttribute("result",result);
        return "ketQua";
    }

}
