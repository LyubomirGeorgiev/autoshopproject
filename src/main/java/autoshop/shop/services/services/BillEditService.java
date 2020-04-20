package autoshop.shop.services.services;

import autoshop.shop.services.models.BillViewServiceModel;

import java.util.List;

public interface BillEditService {

    List<BillViewServiceModel> getAllOpenBills();

    BillViewServiceModel getBillByBillNumber(int billNumber);
}
