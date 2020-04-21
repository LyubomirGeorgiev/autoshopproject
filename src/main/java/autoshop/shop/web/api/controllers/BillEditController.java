package autoshop.shop.web.api.controllers;

import autoshop.shop.services.models.LaborServiceModel;
import autoshop.shop.services.services.BillEditService;
import autoshop.shop.services.services.EmployeeService;
import autoshop.shop.services.services.LaborService;
import autoshop.shop.services.services.PartWarehouseService;
import autoshop.shop.web.api.models.BillViewModel;
import autoshop.shop.web.api.models.EmployeeViewModel;
import autoshop.shop.web.api.models.LaborModel;
import autoshop.shop.web.api.models.PartWarehouseModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/bills")
public class BillEditController {

    private final BillEditService billEditService;
    private final ModelMapper modelMapper;
    private final PartWarehouseService partWarehouseService;
    private final EmployeeService employeeService;
    private final LaborService laborService;

    @Autowired
    public BillEditController(BillEditService billEditService,
                              ModelMapper modelMapper,
                              PartWarehouseService partWarehouseService,
                              EmployeeService employeeService,
                              LaborService laborService) {
        this.billEditService = billEditService;
        this.modelMapper = modelMapper;
        this.partWarehouseService = partWarehouseService;
        this.employeeService = employeeService;
        this.laborService = laborService;
    }

    @GetMapping("/edit")
    public ModelAndView getEditBillPage(ModelAndView modelAndView){

        List<BillViewModel> bills = this.billEditService
                .getAllOpenBills()
                .stream()
                .map(bill -> this.modelMapper.map(bill, BillViewModel.class))
                .collect(Collectors.toList());

        modelAndView.addObject("bills", bills);

        modelAndView.setViewName("/admin/bills/edit");
        return modelAndView;
    }

    @ModelAttribute("partWarehouseModel")
    public PartWarehouseModel partWarehouseModel(){
        return new PartWarehouseModel();
    }

    @ModelAttribute("laborModel")
    public LaborModel laborAddModel(){
        return new LaborModel();
    }

    @GetMapping("/{billNumber}")
    public ModelAndView getBillByNumber(@PathVariable("billNumber") Integer billNumber,
                                        @ModelAttribute("partWarehouseModel") PartWarehouseModel partWarehouseModel,
                                        @ModelAttribute("laborModel") LaborModel laborModel,
                                        ModelAndView modelAndView){

        BillViewModel bill = this.modelMapper
                .map(this.billEditService.getBillByBillNumber(billNumber), BillViewModel.class);

        modelAndView.addObject("bill", bill);

        List<PartWarehouseModel> parts = this.partWarehouseService
                .getAvailablePartsWarehouse()
                .stream()
                .map(part -> this.modelMapper.map(part, PartWarehouseModel.class))
                .collect(Collectors.toList());

        modelAndView.addObject("parts", parts);

        List<EmployeeViewModel> employees = this.employeeService
                .getAllEmployees()
                .stream()
                .map(e -> this.modelMapper.map(e, EmployeeViewModel.class))
                .collect(Collectors.toList());

        modelAndView.addObject("employees", employees);

        modelAndView.setViewName("/admin/bills/billsByNumber");
        return modelAndView;
    }

    @Transactional
    @PostMapping("/{billNumber}/parts")
    public ModelAndView postPartsToBill(@PathVariable("billNumber") Integer billNumber,
                                        @ModelAttribute("partWarehouseModel") PartWarehouseModel partWarehouseModel,
                                        ModelAndView modelAndView){

        this.billEditService.addPartToBill(partWarehouseModel, billNumber);

        modelAndView.setViewName("/admin/bills/addedPart");
        return modelAndView;
    }

    @Transactional
    @PostMapping("/{billNumber}/labor")
    public ModelAndView postLaborToBill(@PathVariable("billNumber") Integer billNumber,
                                        @ModelAttribute("laborModel") LaborModel laborModel,
                                        ModelAndView modelAndView){

        this.billEditService.addLaborToBill(this.modelMapper.map(laborModel, LaborServiceModel.class), billNumber);

        modelAndView.setViewName("/admin/bills/addedLabor");
        return modelAndView;
    }

    @GetMapping("/laboradded")
    public ModelAndView getAddedLabor(
                                        @ModelAttribute("partWarehouseModel") PartWarehouseModel partWarehouseModel,
                                        @ModelAttribute("laborModel") LaborModel laborModel,
                                        ModelAndView modelAndView){

        modelAndView.setViewName("/admin/bills/addedLabor");
        return modelAndView;
    }

    @GetMapping("/partadded")
    public ModelAndView getAddedPart(
            @ModelAttribute("partWarehouseModel") PartWarehouseModel partWarehouseModel,
            @ModelAttribute("laborModel") LaborModel laborModel,
            ModelAndView modelAndView){

        modelAndView.setViewName("/admin/bills/addedPart");
        return modelAndView;
    }
}
