package autoshop.shop.data.repositories;

import autoshop.shop.data.entities.Bill;
import autoshop.shop.data.entities.PartWarehouse;
import autoshop.shop.data.entities.enums.PartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface PartWarehouseRepository extends JpaRepository<PartWarehouse, String> {

    List<PartWarehouse> findAllBySoldDateIsNullOrderByDeliveredDate();

    PartWarehouse findByPartInventoryNumber(Long inventoryNumber);

    @Modifying(flushAutomatically=true)
    @Query(value = "update PartWarehouse p set p.bill.id = ?1 where p.id = ?2")
    void setPartToBill(String id, String partWarehouseId);

    @Modifying(flushAutomatically=true)
    @Query(value = "update PartWarehouse p set p.soldPrice = ?1 where p.id = ?2")
    void setPartWarehouseSoldPrice(BigDecimal bigDecimal, String id);

    @Modifying(flushAutomatically=true)
    @Query(value = "UPDATE PartWarehouse p set p.partStatus = ?2 where p.id = ?1")
    void setPartStatusSold(String partId, PartStatus partStatus);

    @Modifying(flushAutomatically=true)
    @Query(value = "UPDATE PartWarehouse p set p.soldDate = ?2 where p.id = ?1")
    void setPartSellingDate(String partId, Date date);
}
