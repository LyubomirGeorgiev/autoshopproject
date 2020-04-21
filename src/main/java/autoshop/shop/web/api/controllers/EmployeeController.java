package autoshop.shop.web.api.controllers;

import autoshop.shop.services.models.EmployeeServiceModel;
import autoshop.shop.services.services.EmployeeService;
import autoshop.shop.web.api.models.EmployeeAddModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ModelAndView getEmployeeIndex(ModelAndView modelAndView){

        modelAndView.setViewName("/admin/employees/index");
        return modelAndView;
    }

    @ModelAttribute("employeeAddModel")
    public EmployeeAddModel employeeAddModel(){
        return new EmployeeAddModel();
    }

    @GetMapping("/add")
    public ModelAndView getAddEmployee(@ModelAttribute("employeeAddModel") EmployeeAddModel employeeAddModel,
                                       ModelAndView modelAndView){

        modelAndView.setViewName("/admin/employees/add");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView postAddEmployee(@ModelAttribute("employeeAddModel") EmployeeAddModel employeeAddModel,
                                        ModelAndView modelAndView){

        this.employeeService.addEmployee(this.modelMapper.map(employeeAddModel, EmployeeServiceModel.class));

        modelAndView.setViewName("redirect:/admin/employees/add");
        return modelAndView;
    }
}
