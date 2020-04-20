package autoshop.shop.data.repositories;

import autoshop.shop.data.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, String> {

    List<Bill> findAllByEndDateIsNull();

    Bill findBillByBillNumber(int billNumber);
}
