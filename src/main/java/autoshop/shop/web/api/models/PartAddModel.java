package autoshop.shop.web.api.models;

import autoshop.shop.data.entities.Supplier;

import java.math.BigDecimal;
import java.util.Date;

public class PartAddModel {

    private String partNumber;

    private String name;

    private String brand;

    private String technicalSpecs;

    private Date deliveredDate;

    private BigDecimal deliveryPrice;

    private BigDecimal officialSellingPrice;

//    private Supplier supplier;

    public PartAddModel() {
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTechnicalSpecs() {
        return technicalSpecs;
    }

    public void setTechnicalSpecs(String technicalSpecs) {
        this.technicalSpecs = technicalSpecs;
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
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

//    public Supplier getSupplier() {
//        return supplier;
//    }
//
//    public void setSupplier(Supplier supplier) {
//        this.supplier = supplier;
//    }
}
