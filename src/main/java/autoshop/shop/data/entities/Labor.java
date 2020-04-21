package autoshop.shop.data.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "labor")
public class Labor extends BaseEntity{

    @Column(name = "labor_number")
    private int laborNumber;

    @Column(name = "action")
    private String action;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "single_price")
    private BigDecimal singlePrice;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "bill_id", nullable = false)
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Labor() {
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

    public int getLaborNumber() {
        return laborNumber;
    }

    public void setLaborNumber(int laborNumber) {
        this.laborNumber = laborNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
