package autoshop.shop.web.api.controllers;

import autoshop.shop.services.models.CarServiceRegisterModel;
import autoshop.shop.services.models.CarViewServiceModel;
import autoshop.shop.services.models.ClientViewServiceModel;
import autoshop.shop.services.services.CarService;
import autoshop.shop.services.services.ClientService;
import autoshop.shop.services.services.UserService;
import autoshop.shop.web.api.models.CarRegisterModel;
import autoshop.shop.web.api.models.CarViewModel;
import autoshop.shop.web.api.models.ClientViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/cars")
public class CarsController {

    private final CarService carService;
    private final ClientService clientService;
    private final ModelMapper modelMapper;

    @Autowired
    public CarsController(CarService carService, ClientService clientService, ModelMapper modelMapper) {
        this.carService = carService;
        this.clientService = clientService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ModelAndView getCarIndex(ModelAndView modelAndView){

//        Map<ClientViewModel, List<CarViewModel>> carsByUser = new LinkedHashMap<>();
//
//        for (Map.Entry<ClientViewServiceModel, List<CarViewServiceModel>> entry:
//             this.carService.carsByClient().entrySet()) {
//            carsByUser.put(this.modelMapper.map(entry.getKey(), ClientViewModel.class),
//                    entry.getValue().stream().map(e -> this.modelMapper.map(e, CarViewModel.class))
//                            .collect(Collectors.toList()));
//        }

        modelAndView.setViewName("/admin/cars/index");
        return modelAndView;
    }

    @ModelAttribute("carRegisterModel")
    public CarRegisterModel carRegisterModel(){
        return new CarRegisterModel();
    }

    @GetMapping("/add")
    public ModelAndView getAddCar(@ModelAttribute("carRegisterModel") CarRegisterModel carRegisterModel,
                                  ModelAndView modelAndView){

        List<ClientViewModel> clients = this.clientService
                .findAllClients()
                .stream()
                .map(c -> this.modelMapper.map(c, ClientViewModel.class))
                .collect(Collectors.toList());

        modelAndView.addObject("clients", clients);
        modelAndView.setViewName("/admin/cars/add");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView postAddCar(@Valid @ModelAttribute("carRegisterModel") CarRegisterModel carRegisterModel,
                                   BindingResult bindingResult,
                                   ModelAndView modelAndView){

        if (bindingResult.hasErrors()){

            modelAndView.setViewName("/admin/cars/add");
            return modelAndView;
        }

        this.carService.addCarToDb(this.modelMapper.map(carRegisterModel, CarServiceRegisterModel.class));

        modelAndView.setViewName("/admin/cars/added");
        return modelAndView;
    }

    @GetMapping("/all")
    public ModelAndView getAllCarView(ModelAndView modelAndView){

        modelAndView.addObject("cars", this.carService.viewAllCars());

        modelAndView.setViewName("admin/cars/all");
        return modelAndView;
    }
}
