package autoshop.shop.web.api.models;

import autoshop.shop.services.validators.EmailDoesntExist;
import autoshop.shop.services.validators.PasswordMatches;
import autoshop.shop.services.validators.UserDoesntExist;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@PasswordMatches
@UserDoesntExist
@EmailDoesntExist
//@PhoneDoesntExist
public class UserRegisterModel {

    @Size(min = 3, max = 12, message = "size must be between 3 and 12 symbols")
    @Pattern(regexp = "^(?=.{3,12}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$", message = "Username can be only between 3 and 12 symbols. No special symbols allowed.")
    private String username;

    @Pattern(regexp = "^(?=.*[0-9]+.*)(?=.*[a-zA-Z]+.*)[0-9a-zA-Z]{6,}$", message = "Password must be between 4 and 8 symbols, must include one lower case letter, one upper case letter and one digit")
    private String password;

    private String confirmPassword;

    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$", message = "Invalid email")
    private String email;

//    @Pattern(regexp = "^[0-9+]*$", message = "Phone can consist of only digits and + in beginning")
//    private String phoneNumber;
//
//    @Pattern(regexp = "^[0-9+]*$", message = "Phone can consist of only digits and + in beginning")
//    private String altPhoneNumber;
//
//    private String name;
//
//    private ClientType clientType;
//
//    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$", message = "Invalid person name. Enter first and last name.")
//    private String contactPerson;

    public UserRegisterModel() {
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
