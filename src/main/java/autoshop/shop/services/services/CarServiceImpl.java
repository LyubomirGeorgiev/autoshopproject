package autoshop.shop.services.services;

import autoshop.shop.data.entities.Car;
import autoshop.shop.data.entities.Client;
import autoshop.shop.data.repositories.CarRepository;
import autoshop.shop.services.models.CarServiceRegisterModel;
import autoshop.shop.services.models.CarViewServiceModel;
import autoshop.shop.services.models.ClientViewServiceModel;
import autoshop.shop.web.api.models.CarViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final ClientService clientService;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, ClientService clientService) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.clientService = clientService;
    }

    @Override
    public CarServiceRegisterModel addCarToDb(CarServiceRegisterModel carServiceRegisterModel) {

        Car car = this.modelMapper.map(carServiceRegisterModel, Car.class);

        car.setClient(this.clientService.getClientByEmail(carServiceRegisterModel.getEmail()));

        this.carRepository.saveAndFlush(car);

        return this.modelMapper.map(car, CarServiceRegisterModel.class);
    }

    @Override
    public List<CarViewServiceModel> viewAllCars() {

        List<CarViewServiceModel> cars = this.carRepository.findAllOrderByClientName()
                .stream()
                .map(c -> this.modelMapper.map(c, CarViewServiceModel.class))
                .collect(Collectors.toList());

        return cars;
    }

    @Override
    public List<CarViewServiceModel> viewCarsByClient(Client client) {

        return this.carRepository.findAllByClient(client);
    }

    @Override
    public Map<ClientViewServiceModel, List<CarViewServiceModel>> carsByClient() {

        Map<ClientViewServiceModel, List<CarViewServiceModel>> carsClients = new LinkedHashMap<>();

        this.clientService.findAllClients().forEach(c -> {
            carsClients.put(c, new ArrayList<>());
            this.carRepository.findAllByClient(this.modelMapper.map(c, Client.class)).forEach(carViewServiceModel -> {
                carsClients.get(c).add(carViewServiceModel);
                    }

            );
        });

        return carsClients;
    }

    @Override
    public List<CarViewServiceModel> getCarsByCustomerNumber(Long customerNumber) {

        return this.carRepository.findCarsByCustomerNumber(customerNumber)
                .stream()
                .map(car -> this.modelMapper.map(car, CarViewServiceModel.class))
                .collect(Collectors.toList());
    }
}
