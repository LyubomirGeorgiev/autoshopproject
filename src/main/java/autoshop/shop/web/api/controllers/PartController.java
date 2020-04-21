package autoshop.shop.web.api.controllers;

import autoshop.shop.services.services.PartWarehouseService;
import autoshop.shop.web.api.models.PartAddModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/parts")
public class PartController {

    private final PartWarehouseService partWarehouseService;
    private final ModelMapper modelMapper;

    @Autowired
    public PartController(PartWarehouseService partWarehouseService, ModelMapper modelMapper) {
        this.partWarehouseService = partWarehouseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ModelAndView getPartsIndex(ModelAndView modelAndView){

        modelAndView.setViewName("/admin/parts/index");
        return modelAndView;
    }

    @ModelAttribute("partAddModel")
    public PartAddModel partAddModel(){
        return new PartAddModel();
    }

    @GetMapping("/add")
    public ModelAndView getAddPart(@ModelAttribute("partAddModel") PartAddModel partAddModel,
                                   ModelAndView modelAndView){

        modelAndView.setViewName("/admin/parts/add");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView postAddPart(@ModelAttribute("partAddModel") PartAddModel partAddModel,
                                    ModelAndView modelAndView){

        if(this.partWarehouseService.addPartToWarehouse(partAddModel) == null){

            modelAndView.setViewName("/admin/parts/add");
            return modelAndView;
        }

        modelAndView.setViewName("redirect:/admin/parts/add");
        return modelAndView;
    }
}
