package autoshop.shop.services.services;

import autoshop.shop.data.repositories.BillRepository;
import autoshop.shop.services.models.BillViewServiceModel;
import autoshop.shop.web.api.models.BillViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillEditServiceImpl implements BillEditService{

    private final ModelMapper modelMapper;
    private final BillRepository billRepository;

    @Autowired
    public BillEditServiceImpl(ModelMapper modelMapper, BillRepository billRepository) {
        this.modelMapper = modelMapper;
        this.billRepository = billRepository;
    }

    @Override
    public List<BillViewServiceModel> getAllOpenBills() {

        List<BillViewServiceModel> bills = this.billRepository
                .findAllByEndDateIsNull()
                .stream()
                .map(bill -> this.modelMapper.map(bill, BillViewServiceModel.class))
                .collect(Collectors.toList());

        return bills;
    }

    @Override
    public BillViewServiceModel getBillByBillNumber(int billNumber) {

        BillViewServiceModel bill = this.modelMapper
                .map(this.billRepository.findBillByBillNumber(billNumber),
                        BillViewServiceModel.class);

        return bill;
    }
}
