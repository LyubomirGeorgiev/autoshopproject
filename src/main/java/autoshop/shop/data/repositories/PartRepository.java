package autoshop.shop.data.repositories;

import autoshop.shop.data.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part, String> {

    Part findByPartNumber(String partNumber);
}
