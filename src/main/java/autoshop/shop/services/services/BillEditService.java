package autoshop.shop.services.services;

import autoshop.shop.data.entities.Bill;
import autoshop.shop.data.entities.PartWarehouse;
import autoshop.shop.services.models.BillViewServiceModel;
import autoshop.shop.services.models.LaborServiceModel;
import autoshop.shop.web.api.models.PartWarehouseModel;

import java.math.BigDecimal;
import java.util.List;

public interface BillEditService {

    List<BillViewServiceModel> getAllOpenBills();

    BillViewServiceModel getBillByBillNumber(int billNumber);

    void addPartToBill(PartWarehouseModel partWarehouseModel, int billNumber);

    void addLaborToBill(LaborServiceModel laborServiceModel, int billNumber);

    BigDecimal updatePartsFinalAmount(Bill bill);

    BigDecimal updateBillTotalAmount(Bill bill);

    BigDecimal updateLaborTotalAmount(Bill bill);
}
