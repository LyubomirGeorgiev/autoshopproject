package autoshop.shop.services.services;

import autoshop.shop.data.entities.Supplier;
import autoshop.shop.services.models.SupplierAddServiceModel;

public interface SupplierService {

    Supplier getSupplierByName(String name);

    Supplier addSupplier(SupplierAddServiceModel supplierAddServiceModel);
}
