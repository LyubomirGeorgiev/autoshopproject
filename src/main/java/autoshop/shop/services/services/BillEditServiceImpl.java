package autoshop.shop.services.services;

import autoshop.shop.data.entities.Bill;
import autoshop.shop.data.entities.Labor;
import autoshop.shop.data.entities.PartWarehouse;
import autoshop.shop.data.entities.enums.PartStatus;
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

        Bill bill = this.billRepository.findBillByBillNumber(billNumber);

        this.partWarehouseService.editPartSoldPrice(partWarehouseModel.getSoldPrice(), part);

        this.partWarehouseService.setPartToBill(bill.getId(), part);

        this.partWarehouseService.setPartSold(part, PartStatus.SOLD);

        bill.setPartsAmount(updatePartsFinalAmount(bill, partWarehouseModel.getSoldPrice()));

        bill.setTotalAmount(updateBillTotalAmount(bill, partWarehouseModel.getSoldPrice()));

        this.billRepository.updateBill(bill, bill.getId());
    }

    @Override
    public void addLaborToBill(LaborServiceModel laborServiceModel, int billNumber) {

        laborServiceModel.setTotalPrice(laborServiceModel.getSinglePrice().multiply(new BigDecimal(laborServiceModel.getQuantity())));
        this.laborService.addLabor(laborServiceModel, billNumber);
        Bill bill = this.billRepository.findBillByBillNumber(billNumber);

        bill.setLaborAmount(updateLaborTotalAmount(bill));
        bill.setTotalAmount(updateBillTotalAmount(bill, laborServiceModel.getTotalPrice()));

        this.billRepository.updateBill(bill, bill.getId());

    }

    @Override
    public BigDecimal updateBillTotalAmount(Bill bill, BigDecimal addedPartPrice) {

        if (bill.getTotalAmount() == null){
            return addedPartPrice;
        }

        return addedPartPrice.add(bill.getTotalAmount());
    }

    @Override
    public BigDecimal updateLaborTotalAmount(Bill bill) {

        return bill.getLaborList().stream().map(Labor::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    @Override
    public BigDecimal updatePartsFinalAmount(Bill bill, BigDecimal addedPartPrice) {

        if (bill.getPartsAmount() == null){

            return addedPartPrice;
        }

        return addedPartPrice.add(bill.getPartsAmount());
    }
}
