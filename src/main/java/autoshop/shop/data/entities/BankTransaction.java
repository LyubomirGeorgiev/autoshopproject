package autoshop.shop.data.entities;

import autoshop.shop.data.entities.enums.TransactionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "bank_transactions")
public class BankTransaction extends BaseEntity{

    @Column(name = "date")
    private Date date;

    @Column(name = "transaction_type")
    private TransactionType transactionType;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "outgoing_payment_id")
    private OutgoingPayment outgoingPayment;

    @ManyToOne
    @JoinColumn(name = "incoming_payment_id")
    private IncomingPayment incomingPayment;

    public BankTransaction() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OutgoingPayment getOutgoingPayment() {
        return outgoingPayment;
    }

    public void setOutgoingPayment(OutgoingPayment outgoingPayment) {
        this.outgoingPayment = outgoingPayment;
    }

    public IncomingPayment getIncomingPayment() {
        return incomingPayment;
    }

    public void setIncomingPayment(IncomingPayment incomingPayment) {
        this.incomingPayment = incomingPayment;
    }
}
