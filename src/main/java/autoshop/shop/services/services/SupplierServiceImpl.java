package autoshop.shop.services.services;

import autoshop.shop.data.entities.Supplier;
import autoshop.shop.data.repositories.SupplierRepository;
import autoshop.shop.services.models.SupplierAddServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class SupplierServiceImpl implements SupplierService{

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Supplier getSupplierByName(String name) {

        return this.supplierRepository.findByName(name);
    }

    @Override
    public Supplier addSupplier(SupplierAddServiceModel supplierAddServiceModel) {

        Supplier supplier = this.modelMapper.map(supplierAddServiceModel, Supplier.class);

        supplier.setSupplierNumber(this.supplierRepository.findAll().size() + 1);
        supplier.setRegistrationDate(LocalDate.now());

        return this.supplierRepository.saveAndFlush(supplier);
    }
}
