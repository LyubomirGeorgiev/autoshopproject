package autoshop.shop.services.services;

import autoshop.shop.services.models.PartWarehouseServiceModel;

import java.util.List;

public interface PartWarehouseService {
    List<PartWarehouseServiceModel> getAvailablePartsWarehouse();
}
