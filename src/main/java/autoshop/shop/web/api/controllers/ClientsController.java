package autoshop.shop.web.api.controllers;

import autoshop.shop.services.models.ClientRegisterServiceModel;
import autoshop.shop.services.services.CarService;
import autoshop.shop.services.services.ClientService;
import autoshop.shop.web.api.models.CarViewModel;
import autoshop.shop.web.api.models.ClientRegisterModel;
import autoshop.shop.web.api.models.ClientViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/clients")
public class ClientsController {

    private final ModelMapper modelMapper;
    private final ClientService clientService;
    private final CarService carService;

    public ClientsController(ModelMapper modelMapper, ClientService clientService, CarService carService) {
        this.modelMapper = modelMapper;
        this.clientService = clientService;
        this.carService = carService;
    }

    @ModelAttribute("clientRegisterModel")
    public ClientRegisterModel clientRegisterModel(){
        return new ClientRegisterModel();
    }

    @GetMapping("/clients")
    public ModelAndView getClientsPage(@ModelAttribute ModelAndView modelAndView){

        List<ClientViewModel> clientViewModelList =
                this.clientService.findAllClients()
                .stream()
                .map(c -> this.modelMapper
                        .map(c, ClientViewModel.class))
                .collect(Collectors.toList());

        modelAndView.addObject("clients", clientViewModelList);

        modelAndView.setViewName("/admin/clients/clients");
        return modelAndView;
    }

    @GetMapping("/clients/{customer_number}")
    public ModelAndView getCarsByName(@PathVariable("customer_number") Long customer_number, ModelAndView modelAndView){

        List<CarViewModel> cars = this.carService.getCarsByCustomerNumber(customer_number)
                .stream()
                .map(car -> this.modelMapper.map(car, CarViewModel.class))
                .collect(Collectors.toList());

        ClientViewModel client = this.modelMapper.map(this.clientService.getClientByClientNumber(customer_number), ClientViewModel.class);

        modelAndView.addObject("cars", cars);
        modelAndView.addObject("client", client);

        modelAndView.setViewName("/admin/clients/carsByClient");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView getAddClient(@ModelAttribute("clientRegisterModel") ClientRegisterModel clientRegisterModel,
                                     ModelAndView modelAndView){

        modelAndView.setViewName("/admin/clients/addClients");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView postAddClient(@Valid @ModelAttribute("clientRegisterModel") ClientRegisterModel clientRegisterModel,
                                      BindingResult bindingResult,
                                      ModelAndView modelAndView){

        if (bindingResult.hasErrors()){

            modelAndView.setViewName("/admin/clients/addClients");
            return modelAndView;
        }

        this.clientService.register(this.modelMapper.map(clientRegisterModel, ClientRegisterServiceModel.class));

        modelAndView.setViewName("/admin/clients/addedClient");
        return modelAndView;
    }
}
