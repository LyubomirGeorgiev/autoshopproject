package autoshop.shop.data.repositories;

import autoshop.shop.data.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, String> {

    Supplier findByName(String name);
}
