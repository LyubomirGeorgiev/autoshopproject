package autoshop.shop.services.models;

import autoshop.shop.data.entities.PartWarehouse;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

public class PartServiceModel {

    private String partNumber;

    private String name;

    private String brand;

    private String technicalSpecs;

    List<PartWarehouse> partWarehouseList;

    public PartServiceModel() {
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

    public List<PartWarehouse> getPartWarehouseList() {
        return partWarehouseList;
    }

    public void setPartWarehouseList(List<PartWarehouse> partWarehouseList) {
        this.partWarehouseList = partWarehouseList;
    }
}
