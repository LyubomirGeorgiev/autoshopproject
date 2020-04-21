package autoshop.shop.web.api.models;

import autoshop.shop.data.entities.Labor;
import autoshop.shop.data.entities.OutgoingPayment;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class EmployeeAddModel {

    private String name;

    private String position;

    private String uin;

    private String address;

    private String phoneNumber;

    private String email;

    private Date quitDate;

    public EmployeeAddModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUin() {
        return uin;
    }

    public void setUin(String uin) {
        this.uin = uin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getQuitDate() {
        return quitDate;
    }

    public void setQuitDate(Date quitDate) {
        this.quitDate = quitDate;
    }
}
