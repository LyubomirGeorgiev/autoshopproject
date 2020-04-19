package autoshop.shop.data.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "invoice_info")
public class InvoiceInfo extends BaseEntity{

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "uic")
    private String uic;

    @Column(name = "tax_number")
    private String taxNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "ceo_name")
    private String ceoName;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "recipient")
    private Set<OutgoingInvoice> invoices;

    public InvoiceInfo() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUic() {
        return uic;
    }

    public void setUic(String uic) {
        this.uic = uic;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCeoName() {
        return ceoName;
    }

    public void setCeoName(String ceoName) {
        this.ceoName = ceoName;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
