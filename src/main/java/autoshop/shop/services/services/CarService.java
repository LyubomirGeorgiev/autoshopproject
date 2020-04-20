package autoshop.shop.services.services;

import autoshop.shop.data.entities.Car;
import autoshop.shop.data.entities.Client;
import autoshop.shop.services.models.CarServiceRegisterModel;
import autoshop.shop.services.models.CarViewServiceModel;
import autoshop.shop.services.models.ClientViewServiceModel;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CarService {

    CarServiceRegisterModel addCarToDb(CarServiceRegisterModel carServiceRegisterModel);

    List<CarViewServiceModel> viewAllCars();

    List<CarViewServiceModel> viewCarsByClient(Client client);

    Map<ClientViewServiceModel, List<CarViewServiceModel>> carsByClient();

    List<CarViewServiceModel> getCarsByCustomerNumber(Long customerNumber);

    Car getCarByLicensePlate(String licensePlate);
}
