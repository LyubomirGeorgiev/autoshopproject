package autoshop.shop.data.repositories;

import autoshop.shop.data.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, String> {

    List<Bill> findAllByEndDateIsNull();

    Bill findBillByBillNumber(int billNumber);

    @Modifying(flushAutomatically = true)
    @Query(value = "update Bill b set b = ?1 where b.id = ?2")
    void updateBill(Bill bill, String billId);
}
