package autoshop.shop.services.models;

import autoshop.shop.data.entities.enums.ClientType;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.Set;

public class UserServiceRegisterModel {

    private Long customerNumber;
    private String username;
    private String password;
    private String email;

    private Set<RoleServiceModel> authorities;

    public UserServiceRegisterModel() {
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RoleServiceModel> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<RoleServiceModel> authorities) {
        this.authorities = authorities;
    }
}
