package autoshop.shop.data.repositories;

import autoshop.shop.data.entities.PartWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartWarehouseRepository extends JpaRepository<PartWarehouse, String> {

    List<PartWarehouse> findAllBySoldDateIsNull();
}
