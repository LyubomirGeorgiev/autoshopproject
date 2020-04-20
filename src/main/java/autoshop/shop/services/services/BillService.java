package autoshop.shop.services.services;

import autoshop.shop.data.entities.Bill;
import autoshop.shop.services.models.BillCreateServiceModel;

public interface BillService {

    Bill createBill(BillCreateServiceModel billCreateServiceModel);
}
