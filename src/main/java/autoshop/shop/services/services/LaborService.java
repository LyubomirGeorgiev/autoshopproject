package autoshop.shop.services.services;

import autoshop.shop.data.entities.Labor;
import autoshop.shop.services.models.LaborServiceModel;

public interface LaborService {

    Labor addLabor(LaborServiceModel laborServiceModel, int billNumber);
}
