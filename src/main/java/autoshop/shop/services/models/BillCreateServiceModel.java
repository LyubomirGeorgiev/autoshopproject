package autoshop.shop.services.models;

import autoshop.shop.data.entities.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BillCreateServiceModel {

    private Date startDate;

    private String activitiesNeeded;

    private int billNumber;

    private Car car;

    public BillCreateServiceModel() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getActivitiesNeeded() {
        return activitiesNeeded;
    }

    public void setActivitiesNeeded(String activitiesNeeded) {
        this.activitiesNeeded = activitiesNeeded;
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
