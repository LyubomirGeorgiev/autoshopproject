package autoshop.shop.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee extends BaseEntity{

    @Column(name = "employee_number")
    private int employeeNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "uin")
    private String uin;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "hire_date")
    private Date hireDate;

    @Column(name = "quit_date")
    private Date quitDate;

    @OneToMany(mappedBy = "employee")
    private Set<OutgoingPayment> salaryPayments;

    public Employee() {
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getQuitDate() {
        return quitDate;
    }

    public void setQuitDate(Date quitDate) {
        this.quitDate = quitDate;
    }

    public Set<OutgoingPayment> getSalaryPayments() {
        return salaryPayments;
    }

    public void setSalaryPayments(Set<OutgoingPayment> salaryPayments) {
        this.salaryPayments = salaryPayments;
    }
}
