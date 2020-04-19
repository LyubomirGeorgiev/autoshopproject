package autoshop.shop.web.api.models;

import autoshop.shop.data.entities.enums.ClientType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;


public class ClientRegisterModel {

    @NotEmpty(message = "Name cannot be empty.")
    private String name;

    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$", message = "Invalid person name. Enter first and last name.")
    private String contactPerson;

    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$", message = "Invalid email")
    private String email;

    @Pattern(regexp = "^[0-9+]*$", message = "Phone can consist of only digits and + in beginning")
    private String phoneNumber;

    @Pattern(regexp = "^[0-9+]*$", message = "Second phone can consist of only digits and + in beginning")
    private String secondPhoneNumber;

    @Pattern(regexp = "^[0-9+]*$", message = "Third phone can consist of only digits and + in beginning")
    private String thirdPhoneNumber;

    private ClientType clientType;

    public ClientRegisterModel() {
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
}
