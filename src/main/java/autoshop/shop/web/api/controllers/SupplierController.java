package autoshop.shop.web.api.controllers;

import autoshop.shop.data.entities.Supplier;
import autoshop.shop.services.models.SupplierAddServiceModel;
import autoshop.shop.services.services.SupplierService;
import autoshop.shop.web.api.models.SupplierAddModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/suppliers")
public class SupplierController {

    private final SupplierService supplierService;
    private final ModelMapper modelMapper;

    @Autowired
    public SupplierController(SupplierService supplierService, ModelMapper modelMapper) {
        this.supplierService = supplierService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ModelAndView getSupplierHome(ModelAndView modelAndView){

        modelAndView.setViewName("/admin/suppliers/index");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView getAddSupplier(@ModelAttribute("supplierAddModel") SupplierAddModel supplierAddModel,
                                       ModelAndView modelAndView){

        modelAndView.setViewName("/admin/suppliers/add");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView postAddSupplier(@ModelAttribute("supplierAddModel") SupplierAddModel supplierAddModel,
                                        ModelAndView modelAndView){

        try {
            this.supplierService.addSupplier(this.modelMapper.map(supplierAddModel, SupplierAddServiceModel.class));

            modelAndView.addObject("supplier", supplierAddModel);

            modelAndView.setViewName("redirect:/admin/suppliers/" + supplierAddModel.getName());
            return modelAndView;
        } catch (Exception ex){

            modelAndView.setViewName("admin/suppliers/add");
            return modelAndView;
        }

    }

    @GetMapping("/{name}")
    public ModelAndView getSupplierAdded(@PathVariable String name,
                                         ModelAndView modelAndView){

        Supplier supplier = this.supplierService.getSupplierByName(name);

        modelAndView.addObject("supplier", supplier);

        modelAndView.setViewName("/admin/suppliers/added");
        return modelAndView;
    }
}
