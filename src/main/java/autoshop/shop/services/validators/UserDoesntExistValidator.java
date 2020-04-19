package autoshop.shop.services.validators;

import autoshop.shop.services.services.UserService;
import autoshop.shop.web.api.models.UserRegisterModel;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserDoesntExistValidator implements ConstraintValidator<UserDoesntExist, Object> {

    private final UserService userService;

    @Autowired
    public UserDoesntExistValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(UserDoesntExist constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {

        UserRegisterModel user = (UserRegisterModel) obj;
        return !userService.usernameExist(user.getUsername());
    }
}
