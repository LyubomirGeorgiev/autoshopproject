package autoshop.shop.web.api.controllers;

import autoshop.shop.services.models.ClientRegisterServiceModel;
import autoshop.shop.services.services.ClientService;
import autoshop.shop.web.api.models.ClientRegisterModel;
import autoshop.shop.web.api.models.ClientViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/clients")
public class ClientsController {

    private final ModelMapper modelMapper;
    private final ClientService clientService;

    public ClientsController(ModelMapper modelMapper, ClientService clientService) {
        this.modelMapper = modelMapper;
        this.clientService = clientService;
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

    @ModelAttribute("clientRegisterModel")
    public ClientRegisterModel clientRegisterModel(){
        return new ClientRegisterModel();
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
