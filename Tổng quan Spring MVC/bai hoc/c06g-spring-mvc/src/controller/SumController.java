package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.SumService;
import service.impl.SumServiceImpl;

@Controller
public class SumController {

    @Qualifier("sumServiceImpl")
    @Autowired
    private SumService sumService;

    @GetMapping({"/", "/abc"})
    public String goGreeting() {
        return "hello_spring";
    }

    @GetMapping("/sumPage")
    public String goSumPage() {
        return "sum_page";
    }

//    @GetMapping("/sum2Num")
//    public String sum2Num(@RequestParam String num1, @RequestParam(value = "b") String num2, Model model) {
//        double resultFinal = Double.parseDouble(num1) + Double.parseDouble(num2);
//
//        model.addAttribute("resultFinalFromController", resultFinal);
//
//        return "result";
//    }

//    @GetMapping("/sum2Num")
//    public ModelAndView sum2Num(@RequestParam String num1, @RequestParam(value = "b") String num2) {
//        ModelAndView modelAndView = new ModelAndView("result");
//
//        double resultFinal = Double.parseDouble(num1) + Double.parseDouble(num2);
//
//        modelAndView.addObject("resultFinalFromController", resultFinal);
//
//        return modelAndView;
//    }

    @GetMapping("/sum2Num")
    public String sum2Num(@RequestParam String num1, @RequestParam(value = "b") String num2, ModelMap modelMap) {
        double resultFinal = sumService.sum2Num(Double.parseDouble(num1), Double.parseDouble(num2));

        modelMap.put("resultFinalFromController", resultFinal);

        return "result";
    }
}
