package autoshop.shop.data.entities;

import autoshop.shop.data.entities.enums.PaymentType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "inocming_payments")
public class IncomingPayment extends BaseEntity{

    @Column(name = "payment_number")
    private int paymentNumber;

    @Column(name = "date")
    private Date date;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "bills_payments",
            joinColumns = @JoinColumn(name = "bill_id"),
            inverseJoinColumns = @JoinColumn(name = "payment_id")
    )
    private Set<Bill> bills;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private OutgoingInvoice outgoingInvoice;

    @OneToMany(mappedBy = "incomingPayment")
    private Set<CashTransaction> cashTransactions;

    @OneToMany(mappedBy = "incomingPayment")
    private Set<BankTransaction> bankTransactions;

    public IncomingPayment() {
    }

    public int getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(int paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }

    public OutgoingInvoice getOutgoingInvoice() {
        return outgoingInvoice;
    }

    public void setOutgoingInvoice(OutgoingInvoice outgoingInvoice) {
        this.outgoingInvoice = outgoingInvoice;
    }
}
