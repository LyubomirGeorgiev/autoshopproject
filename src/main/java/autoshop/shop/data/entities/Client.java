package autoshop.shop.data.entities;

import autoshop.shop.data.entities.enums.ClientType;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client extends BaseEntity{

    @Column(name = "customer_number")
    private Long customerNumber;

    @Column(name ="name")
    private String name;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "second_phone_number")
    private String secondPhoneNumber;

    @Column(name = "third_phone_number")
    private String thirdPhoneNumber;

    @Column(name = "clientType")
    @Enumerated(EnumType.STRING)
    private ClientType clientType;

    @Column(name = "registered_date")
    private Date registeredDate;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "client")
    private Set<Car> cars;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "client")
    private Set<InvoiceInfo> invoiceInfoSet;

    public Client() {
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSecondPhoneNumber() {
        return secondPhoneNumber;
    }

    public void setSecondPhoneNumber(String secondPhoneNumber) {
        this.secondPhoneNumber = secondPhoneNumber;
    }

    public String getThirdPhoneNumber() {
        return thirdPhoneNumber;
    }

    public void setThirdPhoneNumber(String thirdPhoneNumber) {
        this.thirdPhoneNumber = thirdPhoneNumber;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
