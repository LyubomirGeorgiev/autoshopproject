package autoshop.shop.services.services;

import autoshop.shop.data.repositories.PartWarehouseRepository;
import autoshop.shop.services.models.PartWarehouseServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartWarehouseServiceImpl implements PartWarehouseService{

    private final PartWarehouseRepository partWarehouseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PartWarehouseServiceImpl(PartWarehouseRepository partWarehouseRepository, ModelMapper modelMapper) {
        this.partWarehouseRepository = partWarehouseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PartWarehouseServiceModel> getAvailablePartsWarehouse() {

        List<PartWarehouseServiceModel> parts = this
                .partWarehouseRepository
                .findAllBySoldDateIsNull()
                .stream()
                .map(part -> this.modelMapper.map(part, PartWarehouseServiceModel.class))
                .collect(Collectors.toList());

        return parts;
    }
}
