package autoshop.shop.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product extends BaseEntity{

    @Column(name = "part_number")
    private String partNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "price_no_tax")
    private BigDecimal priceNoTax;

    @Column(name = "tax_amount")
    private BigDecimal taxAmount;

    @Column(name = "price_with_tax")
    private BigDecimal priceWithTax;

    @OneToOne
    private Item item;

    public Product() {
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPriceNoTax() {
        return priceNoTax;
    }

    public void setPriceNoTax(BigDecimal priceNoTax) {
        this.priceNoTax = priceNoTax;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getPriceWithTax() {
        return priceWithTax;
    }

    public void setPriceWithTax(BigDecimal priceWithTax) {
        this.priceWithTax = priceWithTax;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
