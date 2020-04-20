package autoshop.shop.web.api.models;

import autoshop.shop.data.entities.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BillViewModel {

    private Date startDate;

    private Date endDate;

    private BigDecimal laborAmount;

    private BigDecimal partsAmount;

    private BigDecimal totalAmount;

    private String activitiesNeeded;

    private int billNumber;

    private int percent_paid;

    private Car car;

    private List<PartWarehouse> parts;

    private List<Labor> laborList;

    private Set<IncomingPayment> incomingPayments;

    private OutgoingInvoice outgoingInvoice;

    public BillViewModel() {
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

    public int getPercent_paid() {
        return percent_paid;
    }

    public void setPercent_paid(int percent_paid) {
        this.percent_paid = percent_paid;
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

    public Set<IncomingPayment> getIncomingPayments() {
        return incomingPayments;
    }

    public void setIncomingPayments(Set<IncomingPayment> incomingPayments) {
        this.incomingPayments = incomingPayments;
    }

    public OutgoingInvoice getOutgoingInvoice() {
        return outgoingInvoice;
    }

    public void setOutgoingInvoice(OutgoingInvoice outgoingInvoice) {
        this.outgoingInvoice = outgoingInvoice;
    }
}
