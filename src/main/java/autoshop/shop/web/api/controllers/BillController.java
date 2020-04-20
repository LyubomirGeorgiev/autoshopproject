package autoshop.shop.web.api.controllers;

import autoshop.shop.data.entities.Car;
import autoshop.shop.services.models.BillCreateServiceModel;
import autoshop.shop.services.services.BillService;
import autoshop.shop.services.services.CarService;
import autoshop.shop.services.services.ClientService;
import autoshop.shop.web.api.models.BillCreateModel;
import autoshop.shop.web.api.models.CarViewModel;
import autoshop.shop.web.api.models.ClientViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/bills")
public class BillController {

    private final ClientService clientService;
    private final CarService carService;
    private final BillService billService;
    private final ModelMapper modelMapper;

    @Autowired
    public BillController(ClientService clientService, CarService carService, BillService billService, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.carService = carService;
        this.billService = billService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("billCreateModel")
    public BillCreateModel billCreateModel(){
        return new BillCreateModel();
    }

    @GetMapping("/")
    public ModelAndView getBillsPage(@ModelAttribute("billCreateModel") BillCreateModel billCreateModel,
                                     ModelAndView modelAndView){

        modelAndView.setViewName("/admin/bills/index");
        return modelAndView;
    }

    private Car addedCar = new Car();

    @GetMapping("/add")
    public ModelAndView getAddBill(@ModelAttribute("billCreateModel") BillCreateModel billCreateModel,
                                   ModelAndView modelAndView){

        List<CarViewModel> cars = this.carService
                .viewAllCars()
                .stream()
                .map(car -> this.modelMapper.map(car, CarViewModel.class))
                .collect(Collectors.toList());

        modelAndView.addObject("cars", cars);

        modelAndView.addObject("addedCar", addedCar);
        modelAndView.setViewName("/admin/bills/add");

        addedCar = null;

        return modelAndView;
    }



    @PostMapping("/add")
    public ModelAndView postAddBill(@ModelAttribute("billCreateModel") BillCreateModel billCreateModel,
                                    ModelAndView modelAndView,
                                    RedirectAttributes redirectAttributes){

        Car car = this.carService.getCarByLicensePlate(billCreateModel.getLicensePlate());
        billCreateModel.setCar(car);

        addedCar = null;

        if(this.billService.createBill(this.modelMapper.map(billCreateModel, BillCreateServiceModel.class)) == null){

            modelAndView.setViewName("/admin/bills/add");
            return modelAndView;
        }

        addedCar = car;

        modelAndView.setViewName("redirect:/admin/bills/add");
        return modelAndView;
    }
}
