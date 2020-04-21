package autoshop.shop.services.services;

import autoshop.shop.data.entities.Part;
import autoshop.shop.services.models.PartServiceModel;
import autoshop.shop.web.api.models.PartAddModel;

public interface PartService {

    Part getPartByPartNumber(String partNumber);

    Part seedPartInDb(PartServiceModel partServiceModel);
}
