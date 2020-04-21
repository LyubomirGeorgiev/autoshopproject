package autoshop.shop.services.services;

import autoshop.shop.data.entities.Bill;
import autoshop.shop.data.entities.PartWarehouse;
import autoshop.shop.data.entities.enums.PartStatus;
import autoshop.shop.services.models.PartWarehouseServiceModel;
import autoshop.shop.web.api.models.PartAddModel;

import java.math.BigDecimal;
import java.util.List;

public interface PartWarehouseService {

    List<PartWarehouseServiceModel> getAvailablePartsWarehouse();

    PartWarehouse getPartByPartNumber(Long partInventoryNumber);

    void setPartToBill(String id, PartWarehouse part);

    PartWarehouse addPartToWarehouse(PartAddModel partAddModel);

    void editPartSoldPrice(BigDecimal soldPrice, PartWarehouse part);

    void setPartSold(PartWarehouse part, PartStatus partStatus);

}
