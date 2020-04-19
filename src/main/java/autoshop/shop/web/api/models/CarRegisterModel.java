package autoshop.shop.web.api.models;

import autoshop.shop.data.entities.Client;
import autoshop.shop.data.entities.enums.EngineType;

import javax.persistence.*;

public class CarRegisterModel {

    private String make;

    private String model;

    private String year;

    private EngineType engineType;

    private String engineInfo;

    private String vin;

    private String email;

    public CarRegisterModel() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public String getEngineInfo() {
        return engineInfo;
    }

    public void setEngineInfo(String engineInfo) {
        this.engineInfo = engineInfo;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
