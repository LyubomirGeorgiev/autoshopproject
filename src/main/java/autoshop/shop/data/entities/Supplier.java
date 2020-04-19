package autoshop.shop.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity{

    @Column(name = "supplier_number")
    private int supplier_number;

    @Column(name = "name")
    private String name;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "supervisor_name")
    private String supervisorName;

    @Column(name = "supervisor_phone")
    private String supervisorPhone;

    @Column(name = "office_phone")
    private String officePhone;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "supplier")
    private Set<BankAccount> bankAccounts;

    @OneToMany(mappedBy = "supplier")
    private List<PartWarehouse> parts;

    @OneToMany(mappedBy = "supplier")
    private Set<OutgoingPayment> outgoingPayments;

    public Supplier() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getSupervisorPhone() {
        return supervisorPhone;
    }

    public void setSupervisorPhone(String supervisorPhone) {
        this.supervisorPhone = supervisorPhone;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
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

    public Set<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Set<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<PartWarehouse> getParts() {
        return parts;
    }

    public void setParts(List<PartWarehouse> parts) {
        this.parts = parts;
    }

    public int getSupplier_number() {
        return supplier_number;
    }

    public void setSupplier_number(int supplier_number) {
        this.supplier_number = supplier_number;
    }

    public Set<OutgoingPayment> getOutgoingPayments() {
        return outgoingPayments;
    }

    public void setOutgoingPayments(Set<OutgoingPayment> outgoingPayments) {
        this.outgoingPayments = outgoingPayments;
    }
}
