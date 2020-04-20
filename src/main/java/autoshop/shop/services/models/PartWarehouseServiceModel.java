package autoshop.shop.services.models;

import autoshop.shop.data.entities.Bill;
import autoshop.shop.data.entities.Part;
import autoshop.shop.data.entities.Supplier;
import autoshop.shop.data.entities.enums.PartStatus;

import java.math.BigDecimal;
import java.util.Date;

public class PartWarehouseServiceModel {

    private Long partInventoryNumber;

    private Date deliveredDate;

    private Date soldDate;

    private BigDecimal deliveryPrice;

    private BigDecimal officialSellingPrice;

    private BigDecimal soldPrice;

    private int supplierDiscount;

    private int sellingDiscount;

    private PartStatus partStatus;

    private Part part;

    private Supplier supplier;

    private Bill bill;

    public PartWarehouseServiceModel() {
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

    public PartStatus getPartStatus() {
        return partStatus;
    }

    public void setPartStatus(PartStatus partStatus) {
        this.partStatus = partStatus;
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
