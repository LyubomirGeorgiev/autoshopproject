package autoshop.shop.web.api.models;

import autoshop.shop.data.entities.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BillCreateModel {

    private String activitiesNeeded;

    private Car car;

    private String licensePlate;

    public BillCreateModel() {
    }

    public String getActivitiesNeeded() {
        return activitiesNeeded;
    }

    public void setActivitiesNeeded(String activitiesNeeded) {
        this.activitiesNeeded = activitiesNeeded;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
