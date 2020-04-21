package autoshop.shop.services.models;

import autoshop.shop.data.entities.Bill;
import autoshop.shop.data.entities.Employee;

import java.math.BigDecimal;
import java.util.Date;

public class LaborServiceModel {

    private int laborNumber;

    private String action;

    private int quantity;

    private BigDecimal singlePrice;

    private BigDecimal totalPrice;

    private Date date;

    private Bill bill;

    private Employee employee;

    public LaborServiceModel() {
    }

    public int getLaborNumber() {
        return laborNumber;
    }

    public void setLaborNumber(int laborNumber) {
        this.laborNumber = laborNumber;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(BigDecimal singlePrice) {
        this.singlePrice = singlePrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
