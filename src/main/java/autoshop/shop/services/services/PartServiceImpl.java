package autoshop.shop.services.services;

import autoshop.shop.data.entities.Part;
import autoshop.shop.data.repositories.PartRepository;
import autoshop.shop.services.models.PartServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartServiceImpl implements PartService{

    private final PartRepository partRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, ModelMapper modelMapper) {
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Part getPartByPartNumber(String partNumber) {

        return this.partRepository.findByPartNumber(partNumber);
    }

    @Override
    public Part seedPartInDb(PartServiceModel partServiceModel) {

        Part part = this.modelMapper.map(partServiceModel, Part.class);

        return this.partRepository.saveAndFlush(part);
    }
}
