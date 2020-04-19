package autoshop.shop.web.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserHomeController {

    @GetMapping("/home")
    public ModelAndView getHome(ModelAndView modelAndView){

        modelAndView.setViewName("/user/home");
        return modelAndView;
    }
}
