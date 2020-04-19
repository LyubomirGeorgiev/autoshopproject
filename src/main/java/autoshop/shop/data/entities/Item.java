package autoshop.shop.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item extends BaseEntity{

    @Column(name = "quantity")
    private int quantity;

    @OneToOne
    private Product product;

    @ManyToOne
    @JoinColumn(name = "incoming_invoice_id")
    private IncomingInvoice incomingInvoice;

    public Item() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public IncomingInvoice getIncomingInvoice() {
        return incomingInvoice;
    }

    public void setIncomingInvoice(IncomingInvoice incomingInvoice) {
        this.incomingInvoice = incomingInvoice;
    }
}
