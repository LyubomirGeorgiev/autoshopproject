package autoshop.shop.data.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parts")
public class Part extends BaseEntity{

    @Column(name = "part_number")
    private String partNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "technical_specs")
    private String technicalSpecs;

    @OneToMany(mappedBy = "part")
    List<PartWarehouse> partWarehouseList;

    public Part() {
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
