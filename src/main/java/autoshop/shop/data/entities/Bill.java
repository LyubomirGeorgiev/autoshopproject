package autoshop.shop.data.entities;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bills")
public class Bill extends BaseEntity{

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "labor_amount")
    @ColumnDefault("0")
    private BigDecimal laborAmount;

    @Column(name = "parts_amount")
    @ColumnDefault("0")
    private BigDecimal partsAmount;

    @Column(name = "total_amount")
    @ColumnDefault("0")
    private BigDecimal totalAmount;

    @Column(name = "activities_needed", length = 500)
    private String activitiesNeeded;

    @Column(name = "bill_number")
    private int billNumber;

    @Column(name = "percent_paid")
    @ColumnDefault("0")
    private int percent_paid;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @OneToMany(mappedBy = "bill")
    private List<PartWarehouse> parts;

    @OneToMany(mappedBy = "bill")
    private List<Labor> laborList;

    @ManyToMany(mappedBy = "bills")
    private Set<IncomingPayment> incomingPayments;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private OutgoingInvoice outgoingInvoice;


    public Bill() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getLaborAmount() {
        return laborAmount;
    }

    public void setLaborAmount(BigDecimal laborAmount) {
        this.laborAmount = laborAmount;
    }

    public BigDecimal getPartsAmount() {
        return partsAmount;
    }

    public void setPartsAmount(BigDecimal partsAmount) {
        this.partsAmount = partsAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
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

    public List<PartWarehouse> getParts() {
        return parts;
    }

    public void setParts(List<PartWarehouse> parts) {
        this.parts = parts;
    }

    public List<Labor> getLaborList() {
        return laborList;
    }

    public void setLaborList(List<Labor> laborList) {
        this.laborList = laborList;
    }

    public int getPercent_paid() {
        return percent_paid;
    }

    public void setPercent_paid(int percent_paid) {
        this.percent_paid = percent_paid;
    }
}
