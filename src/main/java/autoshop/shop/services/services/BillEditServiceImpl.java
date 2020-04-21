package autoshop.shop.services.services;

import autoshop.shop.data.entities.Bill;
import autoshop.shop.data.entities.Labor;
import autoshop.shop.data.entities.PartWarehouse;
import autoshop.shop.data.repositories.BillRepository;
import autoshop.shop.services.models.BillViewServiceModel;
import autoshop.shop.services.models.LaborServiceModel;
import autoshop.shop.web.api.models.PartWarehouseModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillEditServiceImpl implements BillEditService{

    private final ModelMapper modelMapper;
    private final BillRepository billRepository;
    private final PartWarehouseService partWarehouseService;
    private final LaborService laborService;

    @Autowired
    public BillEditServiceImpl(ModelMapper modelMapper, BillRepository billRepository, PartWarehouseService partWarehouseService, LaborService laborService) {
        this.modelMapper = modelMapper;
        this.billRepository = billRepository;
        this.partWarehouseService = partWarehouseService;
        this.laborService = laborService;
    }

    @Override
    public List<BillViewServiceModel> getAllOpenBills() {

        return this.billRepository
                .findAllByEndDateIsNull()
                .stream()
                .map(bill -> this.modelMapper.map(bill, BillViewServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public BillViewServiceModel getBillByBillNumber(int billNumber) {

        BillViewServiceModel bill = this.modelMapper
                .map(this.billRepository.findBillByBillNumber(billNumber),
                        BillViewServiceModel.class);

        return bill;
    }

    @Override
    public void addPartToBill(PartWarehouseModel partWarehouseModel, int billNumber) {

        PartWarehouse part = this.partWarehouseService.getPartByPartNumber(partWarehouseModel.getPartInventoryNumber());

        this.partWarehouseService.editPartSoldPrice(partWarehouseModel.getSoldPrice(), part);

        Bill bill = this.billRepository.findBillByBillNumber(billNumber);

        this.partWarehouseService.setPartToBill(bill.getId(), part);

        bill.setPartsAmount(updatePartsFinalAmount(bill));

        bill.setTotalAmount(updateBillTotalAmount(bill));

        this.billRepository.updateBill(bill, bill.getId());
    }

    @Override
    public void addLaborToBill(LaborServiceModel laborServiceModel, int billNumber) {

        Labor labor = this.laborService.addLabor(laborServiceModel, billNumber);
        Bill bill = this.billRepository.findBillByBillNumber(billNumber);

        bill.setLaborAmount(updateLaborTotalAmount(bill));
        bill.setTotalAmount(updateBillTotalAmount(bill));

        this.billRepository.updateBill(bill, bill.getId());

    }

    @Override
    public BigDecimal updateBillTotalAmount(Bill bill) {

        return bill.getParts().stream().map(PartWarehouse::getSoldPrice).reduce(BigDecimal.ZERO, BigDecimal::add)
                .add(bill.getLaborList().stream().map(Labor::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    @Override
    public BigDecimal updateLaborTotalAmount(Bill bill) {

        return bill.getLaborList().stream().map(Labor::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    @Override
    public BigDecimal updatePartsFinalAmount(Bill bill) {

        return bill.getParts().stream().map(PartWarehouse::getSoldPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
