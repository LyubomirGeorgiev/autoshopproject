package autoshop.shop.services.services;

import autoshop.shop.data.entities.Labor;
import autoshop.shop.data.repositories.LaborRepository;
import autoshop.shop.services.models.LaborServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class LaborServiceImpl implements LaborService{

    private final LaborRepository laborRepository;
    private final ModelMapper modelMapper;
    private final BillService billService;
    private final EmployeeService employeeService;

    @Autowired
    public LaborServiceImpl(LaborRepository laborRepository, ModelMapper modelMapper, BillService billService, EmployeeService employeeService) {
        this.laborRepository = laborRepository;
        this.modelMapper = modelMapper;
        this.billService = billService;
        this.employeeService = employeeService;
    }

    @Override
    public Labor addLabor(LaborServiceModel laborServiceModel, int billNumber) {

        Labor labor = this.modelMapper.map(laborServiceModel, Labor.class);

        labor.setLaborNumber((int) (this.laborRepository.count() + 1));
        labor.setDate(new Date());
        labor.setBill(this.billService.getBillByBillNumber(billNumber));
        labor.setEmployee(laborServiceModel.getEmployee());
        labor.setTotalPrice(laborServiceModel.getSinglePrice()
                .multiply(new BigDecimal(laborServiceModel.getQuantity())));
        labor.setEmployee(this.employeeService.getEmployeeByEmployeeNumber(laborServiceModel.getEmployeeNumber()));

        return this.laborRepository.saveAndFlush(labor);
    }
}
