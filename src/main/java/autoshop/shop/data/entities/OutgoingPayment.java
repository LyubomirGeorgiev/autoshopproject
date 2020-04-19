package autoshop.shop.data.entities;

import autoshop.shop.data.entities.enums.PaymentCategory;
import autoshop.shop.data.entities.enums.PaymentType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "outgoing_payment")
public class OutgoingPayment extends BaseEntity{

    @Column(name = "payment_number")
    private int paymentNumber;

    @Column(name = "payment_type")
    private PaymentType paymentType;

    @Column(name = "payment_category")
    private PaymentCategory paymentCategory;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "recipient")
    private String recipient;

    @ManyToOne
    @JoinColumn(name = "suplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToOne
    private IncomingInvoice incomingInvoice;

    @OneToMany(mappedBy = "outgoingPayment")
    private Set<CashTransaction> cashTransactions;

    @OneToMany(mappedBy = "outgoingPayment")
    private Set<BankTransaction> bankTransactions;

    public OutgoingPayment() {
    }

    public int getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(int paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentCategory getPaymentCategory() {
        return paymentCategory;
    }

    public void setPaymentCategory(PaymentCategory paymentCategory) {
        this.paymentCategory = paymentCategory;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public IncomingInvoice getIncomingInvoice() {
        return incomingInvoice;
    }

    public void setIncomingInvoice(IncomingInvoice incomingInvoice) {
        this.incomingInvoice = incomingInvoice;
    }
}
