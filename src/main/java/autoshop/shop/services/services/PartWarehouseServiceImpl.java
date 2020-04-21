package autoshop.shop.services.services;

import autoshop.shop.data.entities.Bill;
import autoshop.shop.data.entities.PartWarehouse;
import autoshop.shop.data.entities.Supplier;
import autoshop.shop.data.entities.enums.PartStatus;
import autoshop.shop.data.repositories.PartWarehouseRepository;
import autoshop.shop.services.models.PartServiceModel;
import autoshop.shop.services.models.PartWarehouseServiceModel;
import autoshop.shop.web.api.models.PartAddModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartWarehouseServiceImpl implements PartWarehouseService{

    private final PartWarehouseRepository partWarehouseRepository;
    private final ModelMapper modelMapper;
    private final PartService partService;

    @Autowired
    public PartWarehouseServiceImpl(PartWarehouseRepository partWarehouseRepository, ModelMapper modelMapper, PartService partService) {
        this.partWarehouseRepository = partWarehouseRepository;
        this.modelMapper = modelMapper;
        this.partService = partService;
    }

    @Override
    public List<PartWarehouseServiceModel> getAvailablePartsWarehouse() {

        List<PartWarehouseServiceModel> parts = this
                .partWarehouseRepository
                .findAllBySoldDateIsNullOrderByDeliveredDate()
                .stream()
                .map(part -> this.modelMapper.map(part, PartWarehouseServiceModel.class))
                .collect(Collectors.toList());

        return parts;
    }

    @Override
    public PartWarehouse getPartByPartNumber(Long partInventoryNumber) {

        return this
                .partWarehouseRepository
                .findByPartInventoryNumber(partInventoryNumber);
    }

    @Override
    public void setPartToBill(String id, PartWarehouse part) {

        this.partWarehouseRepository.setPartToBill(id, part.getId());
    }

    @Override
    public PartWarehouse addPartToWarehouse(PartAddModel partAddModel) {

        PartWarehouseServiceModel partWarehouseServiceModel =
                this.modelMapper.map(partAddModel, PartWarehouseServiceModel.class);

        partWarehouseServiceModel.setDeliveredDate(new Date());
        partWarehouseServiceModel.setPartInventoryNumber(this.partWarehouseRepository.count() + 1);
        partWarehouseServiceModel.setPartStatus(PartStatus.AVAILABLE);
//        partWarehouseServiceModel.setSupplier(new Supplier());

        if (this.partService.getPartByPartNumber(partAddModel.getPartNumber()) == null){
            //the part doesn't exist and we need to add it to the database

            PartServiceModel partServiceModel = this.modelMapper
                    .map(partAddModel, PartServiceModel.class);

            this.partService.seedPartInDb(partServiceModel);
        }

        partWarehouseServiceModel.setPart(this.partService.getPartByPartNumber(partAddModel.getPartNumber()));

        PartWarehouse partWarehouse = this.modelMapper.map(partWarehouseServiceModel, PartWarehouse.class);

        return this.partWarehouseRepository.saveAndFlush(partWarehouse);
    }

    @Override
    public void editPartSoldPrice(BigDecimal soldPrice, PartWarehouse part) {

        this.partWarehouseRepository.setPartWarehouseSoldPrice(soldPrice, part.getId());
    }

    @Override
    public void setPartSold(PartWarehouse part, PartStatus partStatus) {

        this.partWarehouseRepository.setPartStatusSold(part.getId(), partStatus);

        this.partWarehouseRepository.setPartSellingDate(part.getId(), new Date());
    }

}
