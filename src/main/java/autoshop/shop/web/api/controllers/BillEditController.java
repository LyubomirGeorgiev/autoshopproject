package autoshop.shop.web.api.controllers;

import autoshop.shop.data.entities.PartWarehouse;
import autoshop.shop.services.services.BillEditService;
import autoshop.shop.services.services.PartWarehouseService;
import autoshop.shop.web.api.models.BillViewModel;
import autoshop.shop.web.api.models.PartWarehouseModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/bills")
public class BillEditController {

    private final BillEditService billEditService;
    private final ModelMapper modelMapper;
    private final PartWarehouseService partWarehouseService;

    @Autowired
    public BillEditController(BillEditService billEditService,
                              ModelMapper modelMapper,
                              PartWarehouseService partWarehouseService) {
        this.billEditService = billEditService;
        this.modelMapper = modelMapper;
        this.partWarehouseService = partWarehouseService;
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

    @GetMapping("/{billNumber}")
    public ModelAndView getBillByNumber(@PathVariable("billNumber") int billNumber,
                                        @ModelAttribute("partWarehouseModel") PartWarehouseModel partWarehouseModel,
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

        modelAndView.setViewName("/admin/bills/billsByNumber");
        return modelAndView;
    }

    @PostMapping("/parts/{billNumber}")
    public ModelAndView postPartsToBill(@PathVariable("billNumber") int billNumber,
                                        ModelAndView modelAndView){



        modelAndView.setViewName("redirect:/admin/bills/billsByNumber");
        return modelAndView;
    }
}
