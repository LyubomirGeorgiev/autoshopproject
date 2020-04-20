package autoshop.shop.web.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/money")
public class MoneyController {

    @GetMapping("/")
    public ModelAndView getMoneyIndex(ModelAndView modelAndView){

        modelAndView.setViewName("/admin/money/index");
        return modelAndView;
    }
}
