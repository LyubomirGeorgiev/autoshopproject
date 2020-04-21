package autoshop.shop.services.services;

import autoshop.shop.data.entities.Bill;
import autoshop.shop.data.repositories.BillRepository;
import autoshop.shop.services.models.BillCreateServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BillServiceImpl implements BillService{

    private final BillRepository billRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BillServiceImpl(BillRepository billRepository, ModelMapper modelMapper) {
        this.billRepository = billRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Bill createBill(BillCreateServiceModel billCreateServiceModel) {
        billCreateServiceModel.setStartDate(new Date());
        billCreateServiceModel.setBillNumber((int) this.billRepository.count() + 1);

        Bill bill = this.modelMapper.map(billCreateServiceModel, Bill.class);

        return this.billRepository.saveAndFlush(bill);
    }

    @Override
    public Bill getBillByBillNumber(int billNumber) {

        return this.billRepository.findBillByBillNumber(billNumber);
    }
}
