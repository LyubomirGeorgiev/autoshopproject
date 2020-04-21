package autoshop.shop.data.repositories;

import autoshop.shop.data.entities.Labor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaborRepository extends JpaRepository<Labor, String> {
}
