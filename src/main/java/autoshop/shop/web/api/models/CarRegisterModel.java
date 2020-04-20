package autoshop.shop.web.api.models;

import autoshop.shop.data.entities.Client;
import autoshop.shop.data.entities.enums.EngineType;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CarRegisterModel {

    @Size(min = 6, max = 8, message = "Invalid license plate.")
    private String licensePlate;

    @Size(min = 3, max = 12, message = "Invalid Make.")
    private String make;

    @Size(min = 3, max = 12, message = "Invalid Model.")
    private String model;

    @Pattern(regexp = "^\\d{4}$", message = "Invalid Year.")
    private String year;

    private EngineType engineType;

    private String engineInfo;

    private String vin;

    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$", message = "Invalid Email.")
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

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
