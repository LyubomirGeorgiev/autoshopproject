package autoshop.shop.data.entities;

import autoshop.shop.data.entities.enums.PartStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "parts_warehouse")
public class PartWarehouse extends BaseEntity{

    @Column(name = "part_inventory_number")
    private Long partInventoryNumber;

    @Column(name = "delivered_date")
    private Date deliveredDate;

    @Column(name = "sold_date")
    private Date soldDate;

    @Column(name = "delivery_price")
    private BigDecimal deliveryPrice;

    @Column(name = "official_selling_price")
    private BigDecimal officialSellingPrice;

    @Column(name = "sold_price")
    private BigDecimal soldPrice;

    @Column(name = "supplier_discount")
    private int supplierDiscount;

    @Column(name = "selling_discount")
    private int sellingDiscount;

    @Column(name = "part_status")
    @Enumerated(EnumType.STRING)
    private PartStatus partStatus;

    @ManyToOne
    @JoinColumn(name = "part_id", nullable = false)
    private Part part;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    public PartWarehouse() {
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public Date getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(Date soldDate) {
        this.soldDate = soldDate;
    }

    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public BigDecimal getOfficialSellingPrice() {
        return officialSellingPrice;
    }

    public void setOfficialSellingPrice(BigDecimal officialSellingPrice) {
        this.officialSellingPrice = officialSellingPrice;
    }

    public BigDecimal getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(BigDecimal soldPrice) {
        this.soldPrice = soldPrice;
    }

    public int getSupplierDiscount() {
        return supplierDiscount;
    }

    public void setSupplierDiscount(int supplierDiscount) {
        this.supplierDiscount = supplierDiscount;
    }

    public int getSellingDiscount() {
        return sellingDiscount;
    }

    public void setSellingDiscount(int sellingDiscount) {
        this.sellingDiscount = sellingDiscount;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public PartStatus getPartStatus() {
        return partStatus;
    }

    public void setPartStatus(PartStatus partStatus) {
        this.partStatus = partStatus;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Long getPartInventoryNumber() {
        return partInventoryNumber;
    }

    public void setPartInventoryNumber(Long partInventoryNumber) {
        this.partInventoryNumber = partInventoryNumber;
    }

}
