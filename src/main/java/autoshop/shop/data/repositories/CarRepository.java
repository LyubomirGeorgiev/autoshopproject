package autoshop.shop.data.repositories;

import autoshop.shop.data.entities.Car;
import autoshop.shop.data.entities.Client;
import autoshop.shop.services.models.CarViewServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

    List<CarViewServiceModel> findAllByClient(Client client);
}
