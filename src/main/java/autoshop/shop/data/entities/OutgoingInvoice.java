package autoshop.shop.data.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "outgoing_invoices")
public class OutgoingInvoice extends BaseEntity{

    @Column(name = "invoice_number")
    private int invoiceNumber;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private InvoiceInfo recipient;

    @Column(name = "date")
    private Date date;

    @Column(name = "total_amount")
    private BigDecimal total_amount;

    @OneToMany(mappedBy = "outgoingInvoice")
    private Set<Bill> bills;

    @OneToMany(mappedBy = "outgoingInvoice")
    private Set<IncomingPayment> payments;

    public OutgoingInvoice() {
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public InvoiceInfo getRecipient() {
        return recipient;
    }

    public void setRecipient(InvoiceInfo recipient) {
        this.recipient = recipient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }

    public Set<IncomingPayment> getPayments() {
        return payments;
    }

    public void setPayments(Set<IncomingPayment> payments) {
        this.payments = payments;
    }
}
