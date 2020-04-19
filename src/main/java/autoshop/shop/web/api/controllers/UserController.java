package autoshop.shop.web.api.controllers;

import autoshop.shop.services.models.UserServiceRegisterModel;
import autoshop.shop.services.services.UserService;
import autoshop.shop.web.api.models.UserRegisterModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @ModelAttribute("userRegisterModel")
    public UserRegisterModel userRegisterModel(){
        return new UserRegisterModel();
    }

    @GetMapping("/register")
    public ModelAndView getRegister(@ModelAttribute("userRegisterModel") UserRegisterModel userRegisterModel,
                                    ModelAndView modelAndView){

        modelAndView.setViewName("/user/register");

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView postRegister(@Valid @ModelAttribute("userRegisterModel") UserRegisterModel userRegisterModel,
                                     BindingResult bindingResult,
                                     ModelAndView modelAndView){

        if (bindingResult.hasErrors()){
            modelAndView.setViewName("/user/register");
            return modelAndView;
        }

        if (userService.register(this.modelMapper.map(userRegisterModel, UserServiceRegisterModel.class)) == null){
            modelAndView.setViewName("/user/register");
            return modelAndView;
        }

        modelAndView.setViewName("/user/registered");
        return modelAndView;
    }
}
